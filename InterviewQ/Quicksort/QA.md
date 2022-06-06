# Quicksort

## Nuts and bolts 

A disorganized carpenter has a mixed pile of `n` nuts and `n` bolts. The goal is to find the corresponding pairs of nuts and bolts. Each nut fits exactly one bolt and each bolt fits exactly one nut. By fitting a nut and a bolt together, the carpenter can see which one is bigger (but the carpenter cannot compare two nuts or two bolts directly). Design an algorithm for the problem that uses at most proportional to `nlogn` compares (probabilistically).

### Hint:

modify the quicksort partitioning part of quicksort.

Remark: This research [paper](http://www.cs.ucla.edu/~rafail/PUBLIC/17.pdf) gives an algorithm that runs in `n*log^4n` time in the worst case.

### 2022-05-08 submit:

没有想明白，看的提示[link](https://medium.com/@pushpak.sharma/divide-and-conquer-nuts-bolts-problem-92082115a056)

[image](NutsAndBolts.png)

这个算法其实也是quicksort的变种，最重要的是能够保证，分组之后两个数组都是大小对应的。另外是对应的nut和bolt也都在对应分组里。

## Selection in two sorted arrays

Given two sorted arrays `a[]` and `b[]`, of lengths `n1` and `n2` and an integer `0 <= k < n1 + n2`, design an algorithm to find a key of rank `k`. The order of growth of the worst case running time of your algorithm should be `logn`, where `n = n1 + n2`.

+ Version 1: n1=n2 (equal length arrays) and k=n/2 (median).
+ Version 2: k=n/2 (median).
+ Version 3: no restrictions.

### Hint:

there are two basic approaches.

+ Approach A: Compute the median in a[] and the median in b[]. Recur in a sub-problem of roughly half the size.

+ Approach B: Design a constant-time algorithm to determine whether a[i] is a key of rank k. Use this subroutine and binary search.

Dealing with corner cases can be tricky.

### 2022-05-08 submit:

没有想到应该怎么解答，只想到将两个数组merge到一起，但是这样的复杂度就是`O(n)`

### 参考

这道题前前后后看了很多的参考，但是还是挺迷糊的。

主要的想法就是用分而治之的方法，去掉一部分的备选项，缩小选择的范围。

解释的相对明白一些是　[寻找两个正序数组的中位数-爱代码爱编程.pdf](./寻找两个正序数组的中位数-爱代码爱编程.pdf)

## Decimal dominants

Given an array with `n` keys, design an algorithm to find all values that occur more than `n/10` times. The expected running time of your algorithm should be linear.

### Hint:

determine the `(n/10)th` largest key using quick-select and check if it occurs more than `n/10` times.

Alternate solution hint: use 9 counters.

### 2022-05-08 submit:

用个dict来进行记录，每个出现的次数，但是空间复杂度就是O(n)

###  参考

然后这个题的一个信息点是，`n`个数，出现大于`n/10`的那么只可能有9个。

#### 第一种解法

是Moore majority vote algorithm 算法的变种。

> 核心是对拼消耗：类似我们玩的即时战略游戏：魔兽争霸，三国群英传等。假设地图上有一家（称作红色军）拥有所有军队中一半以上的小兵，在直接对拼下不虚任何对手（不同队伍小兵1v1地同归于尽），其他队伍像蓝色、绿色、紫色等，有可能会互相消耗，但是最后留在地图上的一定是同一队人数最多的红色。 (https://www.jianshu.com/p/f62d0832e0ab)

```java
class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            count += (num == res) ? 1 : -1;
        }

        return res;
    }
}
```

衍生出来的就是求9个最大的数。

#### 第二种解法

大概的意思就是说如果出现超过n/10次，那么元素必然出现在n/10)-th, (2n/10)-th, … (9n/10)-th处。---> 不过还是不是非常的理解这个算法。　

We can also use a selection algorithm to solve the problem in a linear time. If we imagine the array was sorted in a descending order, we can narrow our candidates to 9 elements, namely (n/10)-th, (2n/10)-th, … (9n/10)-th elements.

In this imaginary sorted version of the array, any elements left to (n/10)-th array cannot occur more than n/10 times because there won’t be enough room.

Using QuickSelect, we can get (n/10)-th largest element from the array without sorting the entire array. After checking if (n/10)-th largest element is decimal dominant, we apply the same procedure to the array including and to the right side of (n/10)-th largest element. This means we check for (2n/10)-th largest element, and so on.

This takes ~N time (9 calls to QuickSelect) and ~1 space.
