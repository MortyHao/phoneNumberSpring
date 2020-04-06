package com.finra.assignment.pojo;

import java.util.List;

public class PhoneResponseDTO {

    private int count;
    private List<String> phoneCombination;


    public PhoneResponseDTO() {
    }

    public PhoneResponseDTO(int count, List<String> phoneCombination) {
        this.count = count;
        this.phoneCombination = phoneCombination;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<String> getPhoneCombination() {
        return phoneCombination;
    }

    public void setPhoneCombination(List<String> phoneCombination) {
        this.phoneCombination = phoneCombination;
    }
}
