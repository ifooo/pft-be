package com.parcels.endpoint.rest;

import com.parcels.budget.BudgetService;
import com.parcels.budget.dto.BudgetUpdateCommand;
import com.parcels.endpoint.dto.out.BudgetOut;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/budget")
@RequiredArgsConstructor
@Slf4j
public class BudgetResource {
    private final BudgetService budgetService;
    private final ConversionService conversionService;

    @PostMapping
    public ResponseEntity<BudgetOut> addBudget(@Valid @RequestBody BudgetUpdateCommand budgetPersistCommand) {
        final var result = budgetService.save(budgetPersistCommand);
        final var convertedResult = conversionService.convert(result, BudgetOut.class);
        return ResponseEntity.ok(convertedResult);
    }
}
