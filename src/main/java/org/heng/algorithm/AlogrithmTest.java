package org.heng.algorithm;

/**
 * Created by wangdi5 on 2015/5/24.
 */
public class AlogrithmTest{



    public static String longestCommonSubstring(String first, String second) {
        String tmp = "";
        String max = "";
        for (int i=0; i < first.length(); i++){
            for (int j = 0; j < second.length(); j++){
                for (int k = 1; (k+i) <= first.length() && (k+j) <= second.length(); k++){
                    if (first.substring(i, k + i).equals(second.substring(j, k + j))){
                        tmp = first.substring(i, k + i);
                    }
                    else{
                        if (tmp.length() > max.length()){

                            max = tmp;
                        }
                        tmp = "";
                    }
                }
                if (tmp.length() > max.length()){
                    max = tmp;
                }
                tmp = "";
            }
        }
        return max;
    }

        public static void main(String[] args) {
            System.out.println(longestCommonSubstring("abcewawdawsd","bbbawdbbb"));

//            testBeforeAndAfter();
        }

        /**
        * 分解质因数
        * @param number
        */
        public static void getPrimeFactors(final int  number){
           if(number <2){
               System.out.println("需要大于2");
               return;
           }
            String str = "";
            int i=2;
            int x = number;
            int amount=0;
            for (i=2; i<x; i++) {
                if(x % i == 0 ){
                    str += i + "*";
                    x = x / i;
                    i--;
                    amount++;

                }
            }
            str += i;
            amount++;
            System.out.println(number + "的分解质因素结果为：" +str+",个数为"+amount);
        }



    public static void testBeforeAndAfter(){

      int i =0;
        int k =0;
                int z = 100;
        int r=100;
        z+=++k;
        r+=i++;

//        for(int x=1;x<100;x++){
//
//            i++;
//            ++k;
//
//        }
        System.out.println(z);
        System.out.println(r);
    }


}
