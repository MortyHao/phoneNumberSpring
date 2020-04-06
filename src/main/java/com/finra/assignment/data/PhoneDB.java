package com.finra.assignment.data;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PhoneDB {

    private static volatile Map<String, List<String>> phoneMap;

    private PhoneDB(){}

    public static Map<String, List<String>> getPhoneMap() {
        if(phoneMap == null) {
            synchronized (PhoneDB.class) {
                if(phoneMap == null) {
                    phoneMap = new ConcurrentHashMap<>();
                }
            }
        }
        return phoneMap;
    }
}
