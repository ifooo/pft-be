package com.parcels.endpoint.dto.out;

import com.parcels.domain.enums.TransactionType;

import java.time.OffsetDateTime;

public record TransactionOut(Long id,
                             TransactionType transactionType,
                             Double amount,
                             String description,
                             String category,
                             OffsetDateTime dateFrom) {
}
