package com.financeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.financeapp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

    @Query("from Account where username = :username and password = :password")
    Account authenticate(@Param("username") String username, @Param("password") String password);
    
    @Query("from Account where username = :username")
    Account exists(@Param("username") String username);

    @Query("from Account where accountId = :accountId")
    Account exists(@Param("accountId") long accountId);
}
