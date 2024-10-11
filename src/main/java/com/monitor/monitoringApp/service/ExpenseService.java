package com.monitor.monitoringApp.service;

import com.monitor.monitoringApp.Entity.Expense;
import com.monitor.monitoringApp.dto.ExpenseDto;

import java.util.List;


public interface ExpenseService {

    Expense postExpense(ExpenseDto expenseDto);

    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id);

    Expense updateExpense(Long id, ExpenseDto expenseDto);

    void deleteExpense(Long id);

}
