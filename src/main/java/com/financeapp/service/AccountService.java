package com.financeapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financeapp.entity.Account;
import com.financeapp.exceptions.*;
import com.financeapp.repository.AccountRepository;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Account registerAccount(Account account) throws DuplicateUsernameException, InvalidUsernameException, InvalidPasswordException{
        if(exists(account.getUsername())){
            throw new DuplicateUsernameException();
        }

        if(account.getUsername().length() < 6 || account.getUsername().length() > 255 || account.getUsername().indexOf(" ") != -1){
            throw new InvalidUsernameException();
        }

        String password = account.getPassword();
        if(password.length() < 8 || password.length() > 255 || password.toLowerCase().equals(password) || password.indexOf(" ") != -1){
            throw new InvalidPasswordException();
        }

        return accountRepository.save(account);
    }

    public Account verifyAccount(Account account) throws InvalidAccountDetailsException {
        Account verifiedAccount = accountRepository.authenticate(account.getUsername(), account.getPassword());
        if(verifiedAccount == null){
            throw new InvalidAccountDetailsException();
        }
        return verifiedAccount;
    }

    public boolean exists(Long accountId){
        return accountRepository.exists(accountId) != null;
    }

    public boolean exists(String username){
        return accountRepository.exists(username) != null;
    }
}
