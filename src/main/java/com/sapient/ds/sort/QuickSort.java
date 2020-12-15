package com.sapient.ds.sort;

import java.util.Arrays;
/*
  average or best case : Time complexity - 0(nlogn) | space complexity - logn
  Worst case : O(n2) --> Can use RandomizedPartition
  Not Stable - Insertion position change
  InPlace Sorting Algo - used by many language lib
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] A={7,5,6,2,1,3,8,4};
        QuickSort(A,0,A.length-1);
        Arrays.stream(A).forEach(System.out::print);
        System.out.println();
    }

    private  static  void QuickSort(int[] A,int start,int end){
        if(start<end) {
            int pIndex = partition(A, start, end);
            QuickSort(A, start, pIndex - 1);
            QuickSort(A, pIndex + 1, end);
        }
    }
    private static int partition(int[] A,int start,int end){
        int pIndex=start;

        for(int i=start;i<end;i++) {
            if (A[i] < A[end]) {
                swap(A,i,pIndex);
                pIndex++;
            }
        }
        swap(A,pIndex,end);
        return  pIndex ;
    }

    private static void swap(int[] A,int i, int pIndex) {
        int temp=A[i];
        A[i]=A[pIndex];
        A[pIndex]=temp;
    }
}
