package com.monitor.monitoringApp.Repositry;

import com.monitor.monitoringApp.Entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}
