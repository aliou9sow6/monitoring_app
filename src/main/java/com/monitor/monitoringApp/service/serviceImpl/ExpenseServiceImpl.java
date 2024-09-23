package com.monitor.monitoringApp.service.serviceImpl;

import com.monitor.monitoringApp.Entity.Expense;
import com.monitor.monitoringApp.Repositry.ExpenseRepository;
import com.monitor.monitoringApp.dto.ExpenseDto;
import com.monitor.monitoringApp.service.ExpenseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    private Expense saveOrUpdateExpense(Expense expense, ExpenseDto expenseDto) {
        expense.setTitle(expenseDto.getTitle());
        expense.setDescription(expenseDto.getDescription());
        expense.setAmount(expenseDto.getAmount());
        expense.setCategory(expenseDto.getCategory());
        expense.setDate(expenseDto.getDate());

        return expenseRepository.save(expense);
    }

    public Expense postExpense(ExpenseDto expenseDto) {
        return saveOrUpdateExpense(new Expense(), expenseDto);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll().stream().toList();
    }

    public Expense getExpenseById(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        if (expense.isPresent()) {
            return expense.get();
        }else {
            throw new EntityNotFoundException("Expense is not present with id " + id);
        }
    }

    public Expense updateExpense(Long id, ExpenseDto expenseDto) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            return saveOrUpdateExpense(optionalExpense.get(), expenseDto);
        }else {
            throw new EntityNotFoundException("Expense is not present with id " + id);
        }
    }

    public void deleteExpense(@PathVariable Long id){
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            expenseRepository.delete(optionalExpense.get());
        }else {
            throw new EntityNotFoundException("Expense is not present with id " + id);
        }
    }
}

