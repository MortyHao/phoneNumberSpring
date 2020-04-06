package com.finra.assignment.service;

import com.finra.assignment.data.PhoneDB;
import com.finra.assignment.pojo.PhoneResponseDTO;
import com.finra.assignment.utility.PhoneUtility;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PhoneServiceImpl implements PhoneService{

    @Override
    public PhoneResponseDTO getPhoneNumberCombination(String phone, int pageIdx, int pageNum) {
        Map<String, List<String>> phoneMap = PhoneDB.getPhoneMap();
        if(!phoneMap.containsKey(phone)) {
            generatePhoneCombination(phone);
        }
        List<String> phoneCombination = phoneMap.get(phone);
        List<String> res = new ArrayList<>();
        int left = pageIdx * pageNum;
        int right = (pageIdx + 1) * pageNum - 1;
        while(left <= right && left < phoneCombination.size()) {
            res.add(phoneCombination.get(left++));
        }
        return new PhoneResponseDTO(phoneCombination.size(), res);
    }

    private void generatePhoneCombination(String phone) {
        Map<String, List<String>> phoneMap = PhoneDB.getPhoneMap();
        List<String> list = new ArrayList<>();
        helper(list, phone, 0, new StringBuilder());
        phoneMap.put(phone, list);
    }

    private void helper(List<String> list, String phone, int idx, StringBuilder sb) {
        if(sb.length() == phone.length()) {
            list.add(sb.toString());
            return;
        }

        int num = phone.charAt(idx) - '0';
        int len = sb.length();
        String word = PhoneUtility.getCharListFromButton(num);
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            sb.append(c);
            helper(list, phone, idx + 1, sb);
            sb.setLength(len);
        }
    }


    public static void main(String[] args) {
        PhoneServiceImpl p = new PhoneServiceImpl();
        p.generatePhoneCombination("2190");
    }
}
