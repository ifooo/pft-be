package com.parcels.budget.dto;

import java.time.OffsetDateTime;

public record BudgetUpdateCommand(Long id,
                                  Long userId,
                                  Long categoryId,
                                  Double amount,
                                  OffsetDateTime startDate,
                                  OffsetDateTime endDate) {
}
