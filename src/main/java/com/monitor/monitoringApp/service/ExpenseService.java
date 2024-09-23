package com.monitor.monitoringApp.service;

import com.monitor.monitoringApp.Entity.Expense;
import com.monitor.monitoringApp.dto.ExpenseDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


public interface ExpenseService {

    Expense postExpense(ExpenseDto expenseDto);

    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id);

    Expense updateExpense(Long id, ExpenseDto expenseDto);

    void deleteExpense(Long id);

}
