package com.duanding.formatter;

/**
 * Created by duanding on 16/5/11.
 */
public class StringUitl {

    public static boolean isChatInString(char c,String str){
        if(str.isEmpty()){
            return false;
        }
        return str.indexOf(c) != -1;
    }

    /**
     * 判断一个字符串里的所有字符是否被另一个字符串包含
     * @param s
     * @param str
     * @return
     */
    public static boolean isStrInString(String s,String str){
        if(str.isEmpty() || s.isEmpty()){
            return false;
        }

        int len = s.length();
        int count = 0;
        for (; count < len ; count++){
            if(!isChatInString(s.charAt(count),str)){
                break;
            }
        }

        return count == len - 1;
    }

}
