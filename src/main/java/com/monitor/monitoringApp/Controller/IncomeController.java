package com.monitor.monitoringApp.Controller;

import com.monitor.monitoringApp.Entity.Income;
import com.monitor.monitoringApp.dto.IncomeDto;
import com.monitor.monitoringApp.service.IncomeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/income")
@RequiredArgsConstructor
@CrossOrigin("*")
public class IncomeController {

    private final IncomeService incomeService;

    @PostMapping()
    public ResponseEntity<?> postIncome(@RequestBody IncomeDto incomeDto){
        Income createIncome = incomeService.postIncome(incomeDto);

        if (createIncome != null){
            return  ResponseEntity.status(HttpStatus.CREATED).body(createIncome);
        }else {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAllIncomes(){
        return ResponseEntity.ok(incomeService.getAllIncomes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIncomeById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(incomeService.getIncomeById(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> UpdateIncome(@PathVariable Long id, @RequestBody IncomeDto incomeDto){
        try{
            return ResponseEntity.ok(incomeService.updateIncome(id, incomeDto));
        } catch (EntityNotFoundException e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    /*public ResponseEntity<?> deleteIncome(@PathVariable Long id){
        return incomeService.deleteIncomeById(id);
    }*/
}
