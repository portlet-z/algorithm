//
// Created by 张新征 on 2019-01-22.
//

#ifndef QUICKSORT2_QUICKSORT_H
#define QUICKSORT2_QUICKSORT_H
#include <iostream>
#include "SortTestHelper.h"
#include "MergeSort.h"

using namespace std;

//对 arr[l...r]部分进行 partition 操作
//返回 p,使得 arr[l...p-1] < arr[p]; arr[p+1...r] > arr[p]
template<typename T>
int __partition(T arr[], int l, int r) {
    swap(arr[rand() % (r-l+1) + l],arr[l]);
    T v = arr[l];
    // arr[l+1...j] < v; arr[j+1...i) > v
    int j = l;
    for(int i=l+1; i<=r; i++) {
        if(arr[i] < v) {
//            swap(arr[j+1], arr[i]);
//            j++;
            //和上面两行代码等价
            swap(arr[++j], arr[i]);
        }
    }
    swap(arr[l], arr[j]);
    return j;
}

//对 arr[l...r]部分进行快速排序
template<typename T>
void __quickSort(T arr[], int l, int r){
//    if(l >= r) {
//        return;
//    }
    if(r - l <= 15) {
        insertionSort(arr, l, r);
        return;
    }
    int p = __partition(arr, l, r);
    __quickSort(arr, l, p-1);
    __quickSort(arr, p+1, r);
}

template<typename T>
void quickSort(T arr[], int n) {
    srand(time(NULL));
    __quickSort(arr, 0, n);
}
#endif //QUICKSORT2_QUICKSORT_H
