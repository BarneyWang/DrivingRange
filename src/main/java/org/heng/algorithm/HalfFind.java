package org.heng.algorithm;

/**
 * Created by wangdi5 on 2015/5/25.
 */
public class HalfFind {


    public static int binarySearch(int[] a,int num){


        int startPos = 0;
        int endPos = a.length-1;
        int m = (startPos + endPos) / 2;
        while(startPos <= endPos){
            if(num == a[m])
                return m;
            if(num > a[m]) {
                startPos = m + 1;
            }
            if(num < a[m]) {
                endPos = m -1;
            }
            m = (startPos + endPos) / 2;
        }
        return -1;


    }

    public static void main(String[] args) {
        int a[] = { 1, 3, 6, 8, 9};
        int i = 9;

        System.out.println(binarySearch(a, i));
    }
}
