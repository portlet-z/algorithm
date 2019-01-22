//
// Created by 张新征 on 2019-01-22.
//

#ifndef MERGESORTBU_MERGESORT_H
#define MERGESORTBU_MERGESORT_H
#include <iostream>
#include "SortTestHelper.h"
#include "InsertionSort.h"

using namespace std;

/**
 * 将 arr[l...mid]和 arr[mid+1...r]两部分进行归并
 * @tparam T
 * @param arr
 * @param l
 * @param mid
 * @param r
 */
template<typename T>
void __merge(T arr[], int l, int mid, int r) {

    T aux[r-l+1];
    for(int i=l; i<=r; i++){
        aux[i-l] = arr[i];
    }

    int i=l;
    int j = mid+1;
    for(int k=l; k<=r; k++){
        if(i > mid) {
            arr[k] = aux[j-l];
            j++;
        } else if(j > r) {
            arr[k] = aux[i-l];
            i++;
        } else if(aux[i-l] < aux[j-l]) {
            arr[k] = aux[i-l];
            i++;
        } else {
            arr[k] = aux[j-l];
            j++;
        }
    }
}

/**
 * 递归使用归并排序，对 arr[l...r]的范围进行排序
 * @tparam T
 */
template<typename T>
void __mergeSort(T arr[], int l, int r) {
    //处理递归到底的情况
//    if(l >= r) {
//        return;
//    }
    if(r - l <= 15) {
        insertionSort(arr, l, r);
        return;
    }

    int mid = (r-l)/2 + l;
    __mergeSort(arr, l, mid);
    __mergeSort(arr, mid+1, r);
    //1.第一个优化
    if(arr[mid] > arr[mid+1]) {
        //归并操作
        __merge(arr, l, mid, r);
    }

}

template<typename T>
void mergeSort(T arr[], int n) {
    __mergeSort(arr, 0, n);
}
#endif //MERGESORTBU_MERGESORT_H
