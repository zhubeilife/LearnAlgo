# Week1 Union-Find

## Social network connectivity

Q:
Given a social network containing n members and a log file containing mm timestamps at which times pairs of members formed friendships, design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend … of a friend). Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. The running time of your algorithm should be m*logn or better and use extra space proportional to n.

A:
使用一个额外的数据来记录当前组的个数

## Union-find with specific canonical element

Q:
Add a method find() to the union-find data type so that find(i) returns the largest element in the connected component containing i. The operations, union(), connected(), and find() should all take logarithmic time or better.

A:
Hint: maintain an extra array to the weighted quick-union data structure that stores for each root i the large element in the connected component containing i.

## Successor with delete

Q:
Given a set of nn integers S={0,1,…,n−1} and a sequence of requests of the following form:

+ Remove x from S
+ Find the successor of x: the smallest y in S such that y≥x.

design a data type so that all operations (except construction) take logarithmic time or better in the worst case.

A:
同样适用UF算法，注意这里说的是大于等于。
