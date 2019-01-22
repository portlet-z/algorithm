#include <iostream>
#include "Heap.h"
#include "MergeSort.h"
#include "QuickSort.h"
#include "QuickSort2.h"
#include "SortTestHelper.h"

using namespace std;

template <typename T>
void heapSort1(T arr[], int n) {
    MaxHeap<T> maxHeap = MaxHeap<T>(n);
    for(int i=0; i<n; i++) {
        maxHeap.insert(arr[i]);
    }
    for(int i=n-1; i>=0; i--) {
        arr[i] = maxHeap.extractMax();
    }
}

template <typename T>
void heapSort2(T arr[], int n) {
    MaxHeap<T> maxHeap = MaxHeap<T>(arr, n);
    for(int i=n-1; i>=0; i--) {
        arr[i] = maxHeap.extractMax();
    }
}

int main() {
    std::cout << "Hello, World!" << std::endl;
    int n = 1000000;
    int* arr1 = SortTestHelper::generateRandomArray(n, 0, n);
    int* arr2 = SortTestHelper::copyIntArray(arr1, n);
    int* arr3 = SortTestHelper::copyIntArray(arr1, n);
    int* arr4 = SortTestHelper::copyIntArray(arr1, n);
    int* arr5 = SortTestHelper::copyIntArray(arr1, n);

    SortTestHelper::testSort("Merge Sort", mergeSort, arr1, n);
    SortTestHelper::testSort("Quick Sort", quickSort, arr2, n);
    SortTestHelper::testSort("Quick Sort2", quickSort2, arr3, n);
    SortTestHelper::testSort("Heap Sort1", heapSort1, arr4, n);
    SortTestHelper::testSort("Heap Sort2", heapSort2, arr5, n);

    delete[] arr1;
    delete[] arr2;
    delete[] arr3;
    delete[] arr4;
    delete[] arr5;
    cout<<endl;

    int swapTimes = 100;
    arr1 = SortTestHelper::generateNearlyOrderedArray(n, swapTimes);
    arr2 = SortTestHelper::copyIntArray(arr1, n);
    arr3 = SortTestHelper::copyIntArray(arr1, n);
    arr4 = SortTestHelper::copyIntArray(arr1, n);
    arr5 = SortTestHelper::copyIntArray(arr1, n);

    SortTestHelper::testSort("Merge Sort", mergeSort, arr1, n);
    SortTestHelper::testSort("Quick Sort", quickSort, arr2, n);
    SortTestHelper::testSort("Quick Sort2", quickSort2, arr3, n);
    SortTestHelper::testSort("Heap Sort1", heapSort1, arr4, n);
    SortTestHelper::testSort("Heap Sort2", heapSort2, arr5, n);

    delete[] arr1;
    delete[] arr2;
    delete[] arr3;
    delete[] arr4;
    delete[] arr5;
    return 0;
}