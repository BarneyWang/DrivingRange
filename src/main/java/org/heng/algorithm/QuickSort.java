package org.heng.algorithm;

/**
 * Created by wangdi5 on 2015/5/25.
 */
public class QuickSort {


    public static void sort(int arr[],int low,int high)
    {
        int l=low;
        int h=high;
        int povit=arr[low];

        while(l<h)
        {
            while(l<h&&arr[h]>=povit)
                h--;
            if(l<h){
                int temp=arr[h];
                arr[h]=arr[l];
                arr[l]=temp;
                l++;
            }

            while(l<h&&arr[l]<=povit)
                l++;

            if(l<h){
                int temp=arr[h];
                arr[h]=arr[l];
                arr[l]=temp;
                h--;
            }
        }
        System.out.println(arr.toString());
        System.out.print("l="+(l+1)+"h="+(h+1)+"povit="+povit+"\n");
        if(l>low)sort(arr,low,l-1);
        if(h<high)sort(arr,l+1,high);
    }

    public static void main(String[] args) {
        int[] list={34,3,53,2,23,7,14,10};
        sort(list,0,list.length-1);
        for(int i=0;i<list.length;i++){
            System.out.print(list[i]+" ");
        }
        System.out.println();

    }
}
