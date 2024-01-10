package com.parcels.repository;

import com.parcels.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}
