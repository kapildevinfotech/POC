package com.sapient.ds.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] A={7,5,6,2,4,3,8,1};
        mergeSort(A,A.length);
        Arrays.stream(A).forEach(System.out::print);
        System.out.println();
    }

    static void mergeSort(int[] A,int n){
        if(n<2){
            return;
        }
        int mid=n/2;
        int L[] =new int[mid];
        int R[]=new int[n-mid];

        for(int i=0;i<mid;i++){
            L[i]=A[i];
        }
        int k=0;
        for(int i=mid;i<n;i++){
            R[k]=A[i];
            k++;
        }

        mergeSort(L,L.length);
        mergeSort(R,R.length);
        merge(L,R,A);
    }

    static void merge(int[] L,int[] R,int[] A){
        int i=0,j=0,k=0;
        int nL=L.length,nR=R.length;
        while(i<nL && j<nR){
            if(L[i] < R[j]){
                A[k]=L[i];
                i++;
            }else if(R[j] < L[i]){
                A[k]=R[j];
                j++;
            }
            k++;
        }
        while(i<nL){
            A[k++]=L[i];
            i++;
        }
        while(j<nR){
            A[k++]=R[j];
            j++;
        }
    }
}

