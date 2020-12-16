package com.sapient.ds.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a={2,3,5,6,7,8,9};
        int x=3;
        int p=binarySearch(a,x);
        System.out.printf("Element %d found at %d%n",x,p);
    }

    private static int binarySearch(int[] a, int x) {
        int left=0;
        int right=a.length-1;
        int mid;

        while(left<=right){
            mid=(left+right)/2;
            if(x==a[mid]){
                return mid;
            }
            if(x > a[mid]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
}
