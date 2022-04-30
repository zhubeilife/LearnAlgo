# Mergesort

## Merging with smaller auxiliary array

Suppose that the subarray `a[0]` to `a[n−1]` is sorted and the subarray `a[n]` to `a[2∗n−1]` is sorted. How can you merge the two subarrays so that `a[0]` to `a[2∗n−1]` is sorted using an auxiliary array of length `n` (instead of `2n`)?

### 2022-04-30 Answer:

```txt
| a | b | c | d |    | a | d |
| a*| b | c | d*|    | b | d*|
| a*| b*| c | d*|    | b*| c |
| a*| b*| c*| d*|
```

==> 这个想法好像更复杂了，其实仔细看merge sort的代码就能搞定这个问题？

### Hint

copy only the left half into the auxiliary array.

## Counting inversions

An inversion in an array `a[]` is a pair of entries `a[i]` and `a[j]` such that `i < j` but `a[i] > a[j]`. Given an array, design a linearithmic algorithm to count the number of inversions.

### 2022-04-30 Answer:

Get array

[(i, a[i]) ... (j, a[j])]

sort it using merge sort by the value

then get the new array, for every item index n:

if n(now index) > i(previous index), if means there have

n - i pair.

==> 不确定这样想是否是对的？

### Hint

count while mergesorting.

## Shuffling a linked list

Given a singly-linked list containing `n` items, rearrange the items uniformly at random. Your algorithm should consume a logarithmic (or constant) amount of extra memory and run in time proportional to `nlogn` in the worst case.

### Hint

design a linear-time subroutine that can take two uniformly shuffled linked lists of sizes `n1` and `n2` and combined them into a uniformly shuffled linked lists of size `n1+n2`.

### 2022-04-30

week2学的是如何shuffle an array：
+ 一个办法是给数组中每个元素一个随机，然后sort这个数组
+ 另外一个是在第i次迭代的时候，生成一个[0, i]之间的随机数r, 然后交换a[i] 和 a[r]

[ShuffleAlist](ShuffleAList.java) 里面实现了这两个方法

