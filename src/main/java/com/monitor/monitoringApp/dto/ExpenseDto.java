package com.monitor.monitoringApp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseDto {
    Long id;

    String title;

    String description;

    String category;

    LocalDate date;

    Integer amount;
}
