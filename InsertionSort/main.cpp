#include <iostream>
#include "SortTestHelper.h"
#include "SelectionSort.h"

using namespace std;

template<typename T>
void insertionSort(T arr[], int n) {
    //从第一个元素开始，第0个元素已经有序了
    for(int i=1; i<n; i++) {
       //寻找元素 arr[i] 合适的插入位置
       //j 与前一个元素比较， j 不能等于0，最多考虑到 j=1
//       for(int j=i; j>0; j--) {
//           if(arr[j] < arr[j-1]) {
//               swap(arr[j], arr[j-1]);
//           } else {
//               break;
//           }
//       }
        //与上面等价
        for(int j=i; j>0 && arr[j] < arr[j-1]; j--) {
            swap(arr[j], arr[j-1]);
        }
    }
}

int main() {
    std::cout << "Hello, World!" << std::endl;
    int n=10000;
    int *arr = SortTestHelper::generateRandomArray(n,0,n);
    int *arr2 = SortTestHelper::copyIntArray(arr, n);

    SortTestHelper::testSort("Insertion Sort", insertionSort, arr, n);
    SortTestHelper::testSort("Selection Sort", selectionSort, arr2, n);

    delete[] arr;
    delete[] arr2;
    return 0;
}