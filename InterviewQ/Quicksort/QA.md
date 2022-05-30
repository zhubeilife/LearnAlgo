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

## Decimal dominants

Given an array with `n` keys, design an algorithm to find all values that occur more than `n/10` times. The expected running time of your algorithm should be linear.

### Hint:

determine the `(n/10)th` largest key using quickselect and check if it occurs more than `n/10` times.

Alternate solution hint: use 9 counters.

### 2022-05-08 submit:

用个dict来进行记录？
