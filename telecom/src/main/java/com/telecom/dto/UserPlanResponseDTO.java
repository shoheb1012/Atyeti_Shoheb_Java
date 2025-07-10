package com.telecom.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

import java.time.LocalDate;

@Data

public class UserPlanResponseDTO {

    private Long userPlanId;
    private String userName;
    private String userEmail;
    private String planValidity;
    private Double planPrice;
    private String status;
    private LocalDate startDate;
    private String dataAllowance;
    private String talkTime;
    private String smsAllowance;
    private String phoneNumber;
    private LocalDate expiryDate;

    public UserPlanResponseDTO(Long userPlanId, String userName, String userEmail,
                               String planValidity, Double planPrice, String status,
                               LocalDate startDate, String dataAllowance, String talkTime,
                               String smsAllowance, String phoneNumber, LocalDate expiryDate) {
        this.userPlanId = userPlanId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.planValidity = planValidity;
        this.planPrice = planPrice;
        this.status = status;
        this.startDate = startDate;
        this.dataAllowance = dataAllowance;
        this.talkTime = talkTime;
        this.smsAllowance = smsAllowance;
        this.phoneNumber = phoneNumber;
        this.expiryDate = expiryDate;
    }


}

