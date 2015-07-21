package org.heng.algorithm;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *  String abcd 列出ABCD所有的组合
 * Created by wangdi5 on 2015/6/15.
 */
public class Sortabcd {

    static String s="abcd";


    static void sort(String input){
        Set<String> results = new LinkedHashSet<String>();

        for (int i=0; i<input.length(); i++)
            for (int j=0; j<input.length(); j++){
                String current = input.substring(j, j+1);
                Set<String> newones = new LinkedHashSet<String>();
                for(String s : results){
                    if (s.indexOf(current)==-1) s+=current;
                    newones.add(s);
                }
                results.addAll(newones);
            }
        for (String s: results){
            if (s.length()==input.length()){

                System.out.println(s);
            }

        }
    }


    public static void main(String[] args) {
        String input = "abc";    //求a/b/c三个字符的全排列
        Set<String> results = new LinkedHashSet<String>();
        results.add("");
        for (int i=0; i<input.length(); i++)
            for (int j=0; j<input.length(); j++){
                String current = input.substring(j, j+1);
                Set<String> newones = new LinkedHashSet<String>();
                for(String s : results){
                    if (s.indexOf(current)==-1) {

                        s+=current;
                    }
                    newones.add(s);
                }
                results.addAll(newones);
            }
        for (String s: results)
            if (s.length()==input.length())System.out.println(s);

    }
}
