package com.sapient.ds.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a={2,3,5,6,7,8,9};
        int x=8;
        //int p=binarySearch(a,x);
        int p=recursiveBinarySearch(a,x,0,a.length-1);
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

    private static int recursiveBinarySearch(int[] a, int x,int left,int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (x == a[mid]) {
            return mid;
        } else if (x > a[mid]) {
           return recursiveBinarySearch(a, x, mid + 1, right);
        } else {
            return recursiveBinarySearch(a, x, left, mid - 1);
        }
    }
}
