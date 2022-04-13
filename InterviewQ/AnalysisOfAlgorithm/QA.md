# QA
## 3-SUM in quadratic time

Design an algorithm for the 3-SUM problem that takes time proportional to $n^2$ in the worst case. You may assume that you can sort the n integers in time proportional to $n^2$ or better.

Note: these interview questions are ungraded and purely for your own enrichment. To get a hint, submit a solution.

Hint: given an integer x and a sorted array a[] of nn distinct integers, design a linear-time algorithm to determine if there exists two distinct indices a[i] + a[j] = x

## Search in a bitonic array.

An array is bitonic if it is comprised of an increasing sequence of integers followed immediately by a decreasing sequence of integers. Write a program that, given a bitonic array of n distinct integer values, determines whether a given integer is in the array.

+ `Standard version`: Use $~3lgn$ compares in the worst case.

+ `Signing bonus`: Use $~2lgn$ compares in the worst case (and prove that no algorithm can guarantee to perform fewer than $~2lgn$ compares in the worst case).

Hints: Standard version. First, find the maximum integer using  1lgn compares—this divides the array into the increasing and decreasing pieces.

Signing bonus. Do it without finding the maximum integer(Because n distinct integer).
