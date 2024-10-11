package com.monitor.monitoringApp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IncomeDto {
    Long id;

    String title;

    String description;

    String category;

    LocalDate date;

    Double amount;

}
