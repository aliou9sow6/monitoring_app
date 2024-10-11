package com.monitor.monitoringApp.service;

import com.monitor.monitoringApp.Entity.Income;
import com.monitor.monitoringApp.dto.IncomeDto;

import java.util.List;

public interface IncomeService {

    Income postIncome(IncomeDto incomeDto);

    List<IncomeDto> getAllIncomes();

    Income updateIncome(Long id, IncomeDto incomeDto);

    Income getIncomeById(Long id);

    void deleteIncomeById(Long id);

}
