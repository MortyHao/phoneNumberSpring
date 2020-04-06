package com.finra.assignment.controller;


import com.finra.assignment.pojo.PhoneResponseDTO;
import com.finra.assignment.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

@RestController
public class PhoneController {

    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    //localhost:4200/2315021230?pageIdx=1&pageNum=20
    @CrossOrigin
    @GetMapping("/{phone}")
    public ResponseEntity<PhoneResponseDTO> getPhoneCombination(
                        @PathVariable("phone") String phone,
                        @RequestParam(name = "pageIdx", required = true) int pageIdx,
                        @RequestParam(name = "pageNum", required = true) int pageNum
                    ) {

        return new ResponseEntity<PhoneResponseDTO>(
                phoneService.getPhoneNumberCombination(phone, pageIdx, pageNum),
                HttpStatus.OK
        );
    }


    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        return new ResponseEntity<Object>(name + " parameter is missing", HttpStatus.BAD_REQUEST);
    }
}
