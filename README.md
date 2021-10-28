# 算法指标：
> 时间复杂度：常数操作数量表达式中不要低阶项、只要高阶项且忽略高阶项系数，剩下的部分如果为：f(N)，那么时间复杂度: O(f(N))
1. 常数操作：一个操作如果和样本数据量没有关系，每次都是固定时间内完成的操作，称之为：常数操作
2. 常数项时间：评价一个算法流程的好坏：先看时间复杂度的指标，然后再比较不同数据样本下的实际运行时间，称之为：常数项时间

> 空间复杂度
## 位操作：
> 异或运算(^)：相同为0，不同为1，同样可以称之为：无进位相加
1. 0 ^ N = N N ^ N = 0
2. 交换律、结合律：a ^ b = b ^ a,(a ^ b) ^ c = a ^ (b ^ c)
3. 若a 和 b 的物理地址不同,可以实现不用临时变量完成a,b值交换
   + a = a ^ b  b = a ^ b  a = a ^ b
      - 推导过程：b = a ^ b ^ b = a ^ (b ^ b) = a ^ 0 = a,  a = a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b
   + 还有一种做法： a = a + b, b = a - b, a = a - b
      - 推导过程：b = a + b - b = a, a = a + b - a = b
   + 为啥要地址不同，若地址相同，则： a = a ^ b = 0 &a = &b, *b = 0 , 0 ^ 0 = 0,同理：a = a + b, &a = &b = 2a 

> 与运算(&)：都为1，返回1，否则返回0
   1. N & 0 = 0 ==> 置空
   2. 取出数X对应位, N & 10000 = 000010000 or 00000000, 判断出某位是0还是1

> 或运算(|): 1|1=1,1|0=1,0|0=0
   1. 将数X某个位上置为1 N | 00001000 = xxxx1xxx

> 非(~): ~0 = 1, ~1 = 0

> 取出某个不为0的数二进制数钟最右侧为1的数：num = a & (~a + 1)

## master公式：
> T(N) = a * T(N/b) + O(N^d)
   + log(b,a) > d -> 时间复杂度：O(N^log(b,a))
   + log(b,a) = d -> 时间复杂度：O(N^d*logN)
   + log(b,a) < d -> 时间复杂度：O(N^d)
> master公式的使用，若一个递归函数操作过程符合master公式，则可以直接算出这个递归函数的时间复杂度
   + 比如用一个二分法查找一个数组中的最大值，此时T(N)母问题 = 2 * T(N / 2) + O(1);
     + 符合master公式 a = 2,b = 2,d = 0=>时间复杂度：O(N ^ 1) = O(1)
   + 比如用一个左侧2/3，右侧2/3来分别查找出一个数组中的最大值，此时T(N)母问题 = 2 * T(2/3 * N) + O(1) ==>T(N) = 2 * T(N / (3/2)) + O(1)
     + 符合master公式，a = 2,b = 3/2, d=0
   + 比如用一个左侧2/3，右侧1/3来分别查找出一个数组中的最大值，此时T(N)母问题 = T(2/3 * N) + T(1/3 * N) + O(1) ==>T(N) = T(N / (3/2)) + T(N / 3) + O(1)
     + 不符合master公式