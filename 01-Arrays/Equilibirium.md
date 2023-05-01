# [Equilibirium Index](https://www.codingninjas.com/codestudio/problems/equilibrium-index_893014)

## Problem Statement

You are given an array Arr consisting of N integers. You need to find the equilibrium index of the array.
An index is considered as an equilibrium index if the sum of elements of the array to the left of that index is equal to the sum of elements to the right of it.

Note:
1. The array follows 0-based indexing, so you need to return the 0-based index of the element.
2. Note that the element at the equilibrium index won’t be considered for either left sum or right sum.
3. If there are multiple indices which satisfy the given condition, then return the left-most index i.e if there are indices i,j,k…. which are equilibrium indices, return the minimum among them
4. If no such index is present in the array, return -1.
___
### Input / Output

1.  
    #### Input
    1 7 3 6 5 6

    #### Output
    3

2.  
    #### Input
    1 2 2 9 3 2

    #### Output
    3

3.  
    #### Input
    1 2 3 4

    #### Output
    -1
___
[LeetCode](https://leetcode.com/problems/find-pivot-index/description/)