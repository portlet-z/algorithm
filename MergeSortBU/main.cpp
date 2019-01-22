#include <iostream>
#include "SortTestHelper.h"
#include "MergeSort.h"

using namespace std;

template<typename T>
void mergeSortBU(T arr[], int n) {
    for(int sz = 1; sz <= n; sz += sz) {
        for(int i=0; i+sz<n; i += sz + sz) {
            //对 arr[i...i+sz-1]和 arr[i+sz...i+2*sz-1]进行归并
            __merge(arr, i, i+sz-1, min(i + sz + sz - 1, n-1));
        }
    }
}

int main() {
    std::cout << "Hello, World!" << std::endl;
    int n = 500000;
    int* arr1 = SortTestHelper::generateRandomArray(n, 0, n);
    int* arr2 = SortTestHelper::copyIntArray(arr1, n);
    SortTestHelper::testSort("Merge Sort", mergeSort, arr1, n);
    SortTestHelper::testSort("Merge Sort BU", mergeSortBU, arr2, n);
    delete[] arr1;
    delete[] arr2;
    return 0;
}