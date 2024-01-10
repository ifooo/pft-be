package com.parcels.transaction.dto;

import com.parcels.domain.enums.TransactionType;

import java.time.OffsetDateTime;

import static com.parcels.domain.enums.TransactionType.INCOME;

public record TransactionDto(Long id,
                             TransactionType transactionType,
                             Double amount,
                             String description,
                             String category,
                             OffsetDateTime dateFrom) {
}
