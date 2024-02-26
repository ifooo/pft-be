package com.parcels.repository;

import com.parcels.domain.Transaction;
import com.parcels.domain.enums.TransactionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Page<Transaction> findAllByTransactionTypeAndDateFromBetween(TransactionType transactionType, OffsetDateTime from, OffsetDateTime to,
                                                                 Pageable pageable);

    Page<Transaction> findAllByDateFromBetween(OffsetDateTime from, OffsetDateTime to,
                                               Pageable pageable);


}
