# Q&A

## Intersection of two sets

Given two arrays `a[]` and `b[]`, each containing `n` distinct 2D points in the plane, design a subquadratic algorithm to count the number of points that are contained both in array a[] and array b[].

### 2022-04-25 thinking

concatenate and merge the arry and then find the duplicated elements.

### other answer by use hash directly to find the duplicated

[Link](https://www.cnblogs.com/evasean/p/7220036.html)

```java
 9     private Set<Point> s = new HashSet<Point>();
10     private int samePointsNum;
11     PlanePoints(int n,Point[] inputa, Point[] inputb){
12             for(int i=0;i<n;i++){
13                 s.add(inputa[i]);
14                 s.add(inputb[i]);
15         }
16             samePointsNum = 2*n - s.size();
17     }
```

## Permutation

Given two integer arrays of size n, design a subquadratic algorithm to determine whether one is a permutation of the other. That is, do they contain exactly the same entries but, possibly, in a different order.

## Dutch national flag

Given an array of nn buckets, each containing a red, white, or blue pebble, sort them by color. The allowed operations are:

+ swap(i,j):  swap the pebble in bucket i with the pebble in bucket j.

+ color(i): determine the color of the pebble in bucket i.

The performance requirements are as follows:

+ At most n calls to color().

+ At most nn calls to swap().

+ Constant extra space.

### 2022-04-25 thinking

first use a array to get all the data color and then use this array to do the insert select sort

---> 这种想法主要还是想能访问的次数为n，没有怎么考虑所处理数据的特性？比如说是不区分顺序的，或者说只要分成一组就行？
