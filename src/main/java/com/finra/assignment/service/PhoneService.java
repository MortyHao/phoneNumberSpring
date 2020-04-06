package com.finra.assignment.service;

import com.finra.assignment.pojo.PhoneResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PhoneService {
    PhoneResponseDTO getPhoneNumberCombination(String phone, int pageIdx, int pageNum);
}
