package com.parcels.transaction.dto;

import com.parcels.domain.enums.Currency;
import com.parcels.domain.enums.TransactionType;

import java.time.OffsetDateTime;

import static com.parcels.domain.enums.TransactionType.INCOME;

public record TransactionDto(Long id,
                             TransactionType transactionType,
                             Double amount,
                             Currency currency,
                             String description,
                             String category,
                             OffsetDateTime dateFrom) {
}
