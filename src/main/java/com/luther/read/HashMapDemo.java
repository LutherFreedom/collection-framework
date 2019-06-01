package com.luther.read;

import java.util.HashMap;
import java.util.Map;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/5/31 10:27
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 */
public class HashMapDemo {
    public static  HashMap<String, String> map = new HashMap(){
        {
            put("lvpKey", "lvpValue");
            put("simoKey", "simoValue");
            put("poolKey", "poolValue");
        }
    };

    public static void main(String[] args) {
       String a =  map.get("simoKey");
        map.put("lvpKey", "lvpValueaaaaa");
        String aa = map.computeIfAbsent("lvpKey", (key)->{
            return "qaaaa";
        });
        System.out.println(map.size());
    }
}
