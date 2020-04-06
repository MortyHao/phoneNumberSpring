package com.finra.assignment.utility;

import com.finra.assignment.data.PhoneDB;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class PhoneUtility {

    private final static Map<Integer, String> phoneMap = new HashMap<>();

    static {
        init();
    }

    private PhoneUtility(){}

    private static void init() {
        phoneMap.put(2, "abc");
        phoneMap.put(3, "def");
        phoneMap.put(4, "ghi");
        phoneMap.put(5, "jkl");
        phoneMap.put(6, "mno");
        phoneMap.put(7, "pqrs");
        phoneMap.put(8, "tuv");
        phoneMap.put(9, "wxyz");
    }

    public static String getCharListFromButton(int num) {
        return phoneMap.getOrDefault(num, "") + num;
    }

}
