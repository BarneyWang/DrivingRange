package org.heng.algorithm;

/**
 * Created by wangdi5 on 2015/6/12.
 */
public class StringFindNumber {

   public static boolean isNumber(String temp){

       char[] chars = temp.toCharArray();
       for(char c:chars){

       if(!Character.isDigit(c)){
            return false;
       }
       }
       return true;
   }


    public static void main(String[] args) {
        String str="ab123cde12821&&87Hojkldasnyoi12399klmclkjiouiaods";
       int temp,max=0;

        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<=str.length();j++){
                System.out.println("str.substring("+i+","+j+")");
                 String x =str.substring(i, j);
                if(isNumber(x)){

//                System.out.println(str.substring(i,j));
                    temp = Integer.valueOf(x);
                    if(temp>max){
                        max=temp;
                    }
                }


            }

        }
        System.out.println(max);
    }
}
