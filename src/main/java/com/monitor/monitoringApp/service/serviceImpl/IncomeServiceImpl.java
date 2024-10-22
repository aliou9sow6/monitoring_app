package com.monitor.monitoringApp.service.serviceImpl;

import com.monitor.monitoringApp.Entity.Income;
import com.monitor.monitoringApp.Repositry.IncomeRepository;
import com.monitor.monitoringApp.dto.IncomeDto;
import com.monitor.monitoringApp.service.IncomeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;

    public Income saveOrUpdateIncome(Income income, IncomeDto incomeDto) {

        income.setId(incomeDto.getId());
        income.setTitle(incomeDto.getTitle());
        income.setDescription(incomeDto.getDescription());
        income.setCategory(incomeDto.getCategory());
        income.setDate(incomeDto.getDate());
        income.setAmount(incomeDto.getAmount());

        return incomeRepository.save(income);

    }

    public Income postIncome(IncomeDto incomeDto) {
        return saveOrUpdateIncome(new Income(), incomeDto);
    }

    public List<IncomeDto> getAllIncomes(){
        return incomeRepository.findAll().stream()
                .sorted(Comparator.comparing(Income::getDate).reversed())
                .map(Income::getIncomeDto)
                .collect(Collectors.toList());
    }

    public Income updateIncome(Long id, IncomeDto incomeDto) {
        Optional<Income> optionalIncome = incomeRepository.findById(id);

        if(optionalIncome.isPresent()) {
            return saveOrUpdateIncome(optionalIncome.get(), incomeDto);
        } else {
          throw new EntityNotFoundException("Income is not present with id " + id);
        }
    }

    public IncomeDto getIncomeById(Long id) {
        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if(optionalIncome.isPresent()) {
            return optionalIncome.get().getIncomeDto();
        } else {
            throw new EntityNotFoundException("Income is not present with id " + id);
        }
    }

    public void deleteIncomeById(@PathVariable Long id) {
        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if(optionalIncome.isPresent()) {
            incomeRepository.delete(optionalIncome.get());
        }  else {
            throw new EntityNotFoundException("Income is not present with id " + id);
        }
    }
}
