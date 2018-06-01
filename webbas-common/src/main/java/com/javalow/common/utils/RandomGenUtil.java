package com.javalow.common.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @anthor Satellite
 * RandomGenUtil
 * RandomGenUtil 工具类
 * http://www.javalow.com
 * @date 2018-06-01-14:54
 **/
public class RandomGenUtil {

    /**
     * 生成思维不重复的验证码
     *
     * @return 4位数key
     */
    public static String fourRandomGen() {

        String[] chars = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
                "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i",
                "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8",
                "9"};
        // String [] chars={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
        Random random = new Random();
        int count = 0;

        StringBuilder sb = new StringBuilder();//动态字符串

        while (true) {
            String c = chars[random.nextInt(chars.length)];

            if (sb.indexOf(c + "") == -1) {
                sb.append(c);
                count++;
                if (count == 6) {
                    break;
                }
            }

        }
        return sb.toString();
    }

    /**
     * 判断字符串是否存在于对象List
     *
     * @return
     */
    public static boolean strContainsList(List list, String str) {
        return Collections.frequency(list, str) > 0;
    }

    public static void main(String[] args) {
        List<String> test = new ArrayList<String>();
        test.add("a");
        test.add("b");
        test.add("i1VZ");
        System.out.println(strContainsList(test, "a"));
        System.out.println(strContainsList(test, "A"));
        System.out.println(strContainsList(test, "i1VZ"));
        System.out.println(fourRandomGen());
    }

}
