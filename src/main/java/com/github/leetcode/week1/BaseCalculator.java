package com.github.leetcode.week1;

import java.util.Stack;

/**
 * TODO 未实现
 * @author xinguai.liu
 */
public class BaseCalculator {

    private final Stack<Object> stack = new Stack<>();

    private final Stack<Integer> number = new Stack<>();

    private final Stack<Character> operator = new Stack<>();

    public Integer calc(String calcStr) {
        int result = 0;
        for (int i = 0; i < calcStr.length(); i++) {
            Object value = parse(i, calcStr);
            if (value == null) {
                continue;
            }
            if (value instanceof Operator) {
                if (value == Operator.RIGHT_PARENTHESIS) {
                    Integer num1 = (Integer) stack.pop();
                    Operator operator = (Operator) stack.pop();
                    Integer num2 = (Integer) stack.pop();
                    stack.pop();
                    stack.push(doCalc(num2, operator, num1));
                    continue;
                } else {
                    if (stack.size() >= 3) {
                        Object pop1 = stack.pop();
                        if (pop1 instanceof Integer) {
                            Operator pop2 = (Operator)stack.pop();
                            if (pop2.priority >= ((Operator) value).priority && stack.peek() instanceof Integer) {
                                Integer pop3 = (Integer)stack.pop();
                                stack.push(doCalc(pop3,pop2,(Integer) pop1));
                            } else {
                                stack.push(pop2);
                                stack.push(pop1);
                            }
                        } else {
                            stack.push(pop1);
                        }
                    }
                }
                stack.push(value);
            } else {
                stack.push(value);
            }
        }
        while (stack.size() >= 3) {
            Integer end = (Integer)stack.pop();
            Operator operator = (Operator) stack.pop();
            Integer start = (Integer)stack.pop();
            stack.push(doCalc(start,operator,end));
        }
        result += (Integer) stack.pop();
        return result;
    }

    protected Object parse(int index,String calcStr) {
        char charAt = calcStr.charAt(index);
        Object value = null;
        if (Character.isDigit(charAt)) {
            value = charAt - '0';
        } else {
            value = Operator.parse(charAt);
        }
        return value;
    }


    private int doCalc(Integer start, Operator operator, Integer end) {
        int result = 0;
        switch (operator) {
            case PLUS:
                result = start + end;
                break;
            case REDUCE:
                result = start - end;
                break;
            case MULTIPLY:
                result = start * end;
                break;
            case DIVISION:
                result = start / end;
                break;
            default:
        }
        return result;
    }


    enum Operator {
        /**
         * 加
         */
        PLUS('+', 1),
        /**
         * 减
         */
        REDUCE('-', 1),
        /**
         * 乘
         */
        MULTIPLY('*', 2),
        /**
         * 除
         */
        DIVISION('/', 2),
        /**
         * 左括号
         */
        LEFT_PARENTHESIS('(',3),
        /**
         * 右括号
         */
        RIGHT_PARENTHESIS(')',3);

        private final Character value;

        private final Integer priority;

        Operator(Character value, Integer priority) {
            this.value = value;
            this.priority = priority;
        }

        public static Operator parse(char value) {
            Operator[] operators = Operator.values();
            for (int i = 0; i < operators.length; i++) {
                if (value == operators[i].value.charValue()) {
                    return operators[i];
                }
            }
            return null;
        }
    }

}
