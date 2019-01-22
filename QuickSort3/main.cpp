#include <iostream>
#include "InsertionSort.h"
#include "SortTestHelper.h"
#include "QuickSort2.h"

using namespace std;

template <typename T>
void __quickSort3Ways(T arr[], int l, int r){
    if(r-l <= 15){
        insertionSort(arr, l, r);
        return;
    }

    //partition
    swap(arr[l], arr[rand()%(r-l+1)+l]);
    T v = arr[l];
    //arr[l+1...lt] < v
    int lt = l;
    //arr[gt...r] > v
    int gt = r+1;
    //arr[lt+1...i) === v
    int i = l+1;
    while (i < gt) {
        if(arr[i] < v) {
            swap(arr[i], arr[lt+1]);
            lt++;
            i++;
        } else if (arr[i] > v) {
            swap(arr[i], arr[gt-1]);
            gt--;
        } else {
            i++;
        }
    }
    swap(arr[l], arr[lt]);

    __quickSort3Ways(arr, l, lt-1);
    __quickSort3Ways(arr, gt, r);
}

template <typename T>
void quickSort3Ways(T arr[], int n) {
    srand(time(NULL));
    __quickSort3Ways(arr, 0, n-1);
}

int main() {
    std::cout << "Hello, World!" << std::endl;
    int n = 2000000;
    int* arr1 = SortTestHelper::generateRandomArray(n, 0, 10);
    int* arr2 = SortTestHelper::copyIntArray(arr1, n);
    int* arr3 = SortTestHelper::copyIntArray(arr1, n);

    SortTestHelper::testSort("MergeSort", mergeSort, arr1, n);
    SortTestHelper::testSort("QuickSort2", quickSort2, arr2, n);
    SortTestHelper::testSort("QuickSort2", quickSort3Ways, arr3, n);

    delete[] arr1;
    delete[] arr2;
    delete[] arr3;
    return 0;
}