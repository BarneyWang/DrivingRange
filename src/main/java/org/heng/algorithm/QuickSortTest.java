package org.heng.algorithm;

/**
 * Created by wangdi5 on 2015/5/25.
 */
public class QuickSortTest {


    public static void sort(int[] a, int low, int high) {
          int l = low;
        int h = high;
        int middle = a[l];
        while (l<h){
            while(l<h&&a[h]>=middle)
                h--;
            if(l<h){
                int t = a[h];
                a[h]=a[l];
                a[l]=t;
                l++;

            }
            while (l<h&&a[l]<=middle)
                l++;
            if(l<h){
                int t = a[h];
                a[h]=a[l];
                a[l]=t;
                h--;
            }
        }
        if(l>low) sort(a,low,l-1);
        if(h<high) sort(a,l+1,high);


    }


    public static void main(String[] args) {
        int[] list = {34, 3, 53, 2, 23, 7, 14, 10};
        sort(list, 0, list.length - 1);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();

    }
}
