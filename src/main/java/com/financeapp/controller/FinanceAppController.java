package com.financeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.financeapp.entity.*;
import com.financeapp.service.*;
import com.financeapp.exceptions.*;;

@RestController
public class FinanceAppController {
    private AccountService accountService;

    @Autowired
    public FinanceAppController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("/register")
    public ResponseEntity<Account> postAccount(@RequestBody Account account){
        try{
            Account registeredAccount = accountService.registerAccount(account);
            return ResponseEntity.ok(registeredAccount);
        }catch (DuplicateUsernameException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<Account> postLogin(@RequestBody Account account){
        try{
            Account loginedAccount = accountService.verifyAccount(account);
            return ResponseEntity.ok(loginedAccount);
        }catch (InvalidAccountDetailsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
