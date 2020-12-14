package com.sapient.ds.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] A={7,5,6,2,4};
        int n=A.length;
        for(int i=0;i<n;i++){
            int val=A[i];
            int hole=i;
            for (int j=i-1 ; j >= 0 ; j--){
                if(A[j] > val){
                    A[j+1]=A[j];
                    hole--;
                }else{
                    break;
                }
            }
            A[hole] = val;
        }

        Arrays.stream(A).forEach(System.out::print);
    }
}
