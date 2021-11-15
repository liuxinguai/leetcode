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

## 排序
1. 冒泡：依次循环遍历数组元素，每次循环选择出当前数组未排序部分的最大值放到未排序部分的末尾，选择过程：依次比较数组中两个相邻元素的大小，若前一个元素大于后一个元素，在交换前后位置
2. 选择：依次循环遍历数组元素，每次循环选择出当前数组中最小值放置在数组的起始位置（上依次最小值位置的下一个位置）
3. 插入：依次循环遍历数组元素，每次循环遍历数组将一个数插入到一个有序数组的合适位置中
4. 归并：将一个数组划分成等规模的两块有序数组，然后在将着两块有序数组合并在一起：
   1. 归并过程，使用一个辅助数组，数组大小为两个数组的和 a1[index1] <= a2[index2] ,a1放在辅助数组的尾部,index1++,index2不变，否则index2++,index1不变
   2. 将数组划分成等规模的两块，然后在递归进行归并，至到整个数组被拆分成等规模的两块有序的数组  
5. 快排：在数组中随机选择一个数num1，将这个数与数组的末尾交换，然后取出数组末尾进行patition过程，将num1与大于num的最开始地方前一个元素交换，然后将数组划分成两块依次进行上一个步骤
   1. patition: 将数组按num划分成如下结构：小于num的放在在数组左边，等于num的放在数组中间，大于num的放在数组的右边
6. 桶排序：将一个数组变为小根堆，然后依次取出数组的第一个位置的数，再让这个数组变为小根堆，依次执行以上过程
## 堆结构
> 概念：就是一个用数组实现的完全二叉树

> 堆结构的性质
1. 堆结构中一个子树根结点数组下标为i，若它有左孩子结点则左孩子结点数组下标为2*i+1
2. 堆结构中一个子树根结点数组下标为i，若它有右孩子结点则右孩子结点数组下标下标为2*i+2
3. 若一个结点的位置为i，则它的父节点位置为：i-1/2
> 大根堆: 如果每个子树中的最大值都在顶部则称这个堆为大根堆

> 小根堆: 如果每个子树中的最小值都在顶部则称这个堆为小根堆

> 堆结构两个重要的操作：headInsert操作和headify
+ headInsert:将一个数插入到数组（这个数组是一个满足小根堆结构的）末尾index位置，然后比较(index-1)/2父节点的值是否大于这个数，若大于则位置不动，若小于，交换双方位置，index = (index-1)/2
+ headify: 将一个数组的头元素去除，然后将数组的尾元素重新放置在数组的头元素上，数组大小-1，比较头节点和左右两个子节点的大小，若头节点小于左右两个子节点不动，若头节点小于左节点位置交换，头节点变为左节点，依次下去
> 优先级队列结构就是一个堆结构 


## 链表
> 链表的反向遍历：
1. 快方法：指针的反向引用，例如：a->b->c->d
   1. head = a; node = head.next==>b, temp = node.next==>c node.next = head,head.next = null,head = temp; 重复以上过程，当 head.next = null,head.next = node;
2. 慢方法：利用栈的特性：先进后出，例如 a->b-c->d依次压入栈中，再依次弹出栈
> 回文链表：a->b->c->d->c->b->a
1. 慢方法：将链表依次压入栈中，再依次弹出但再弹出的过程中依次与原链表从头遍历比较是否相等
2. 快方法：利用快慢指针找出一个链表的中间位置，然后从这个位置开始依次将链表中的元素压入栈中，弹出栈跟原链表比较是否相等
3. 快慢指针技巧：首先将快指针和慢指针只想链表头，后面：快指针走两步，慢指针走一步
> 将一个链表按某个值num进行排序，小于num的放在链表的左边，等于num的放在链表的中间，大于num的放在链表的右边
1. 慢方法：将链表放入node数组中，然后通过快排的patition过程将数组变成：小于num在数组左边，等于num在数组中间，大于num在数组右边
2. 快方法：准备6个变量：lessStart,lessEnd,equalsStart,equalsEnd,moreStart,moreEnd,依次遍历链表
   1. 将小于num的放在lessStart~lessEnd过程，若lessStart=null,lessStart=lessEnd=node(小于num的第一个数)，若lessStart!=null,lessEnd.next=node(小于num的节点,node.next = null),lessEnd = node
   2. 将等于num的放在equalsStart~equalsEnd过程，若equalsStar=null,equalsStar=equalsEnd=node(小于num的第一个数)，若equalsStar!=null,equalsEnd.next=node(小于num的节点,node.next = null),equalsEnd = node
   3. 将大于num的放在moreStart~moreEnd过程，若moreStar=null,moreStar=moreEnd=node(小于num的第一个数)，若moreStar!=null,moreEnd.next=node(小于num的节点,node.next = null),moreEnd = node
   4. 遍历完成后，将lessEnd.next = equalsStart,equlasEnd.next = moreStart
## 二叉树
>树的遍历：先序、中序、后序、前序遍历
1. 先序遍历：先访问根节点，再先序遍历左子树、后序遍历右子树
2. 中序遍历：中序遍历左子树，访问根节点、中序遍历右子树
3. 后续遍历：后续遍历左子树，中序遍历右子树，再访问根节点
4. 前序遍历：按照从上到下顺序依次访问树中的每一个节点，树的同一层：按先左后右的顺序进行
>树遍历的递归序：通过递归来实现树的遍历：每个节点都需要通过递归函数三次，通过这三次可以得到一个树的递归序

1. 比如：一个三节点树（A，B，C）的递归序：A1、B1、B2、B3、A2、C1、C2、C3、A3


    protected <V extends Comparable> void recursionTraverse(Node<V> head, RecursionHandle<V> handle) {
        //页节点的的左孩子点和右孩子节点都为null，即结束递归
        if (head == null) {
            return;
        }
        if (handle.type() == Type.WIDTH) {
            widthTraverse(head,handle);
            return;
        }
    
        // 1 此地处理node为先序遍历：先序遍历：每个子树先根节点，左子树在进行先序遍历，右子树进行先序遍历
        if (handle.type() == Type.START) {
            handle.handle(head);
        }
        recursionTraverse(head.left,handle);
    
    
        // 2 此地处理node为中序遍历：中序遍历：每个子树左子数进行中序遍历，根节点，右子树进行中序遍历
        if (handle.type() == Type.MIDDLE) {
            handle.handle(head);
        }
        recursionTraverse(head.right,handle);
    
        // 3 此地处理node为后序遍历：后序遍历：每个子树左子数进行后序遍历，右子树进行后序遍历，根节点
        if (handle.type() == Type.END) {
            handle.handle(head);
        }
    } 

>  树的解题套路：
1. 将一个树的问题划分成等规模的两个左右子树的问题，然后再通过决策左右子树问题得到总问题的答案

##暴力尝试
1. 把问题转化成规模缩小了的同类问题的子问题
2. 有明确的不需要继续进行递归的条件
3. 有当得到了子问题的结果之后的决策过程
4. 不记录每一个子问题的解