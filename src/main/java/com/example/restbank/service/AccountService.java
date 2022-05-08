package com.example.restbank.service;

import com.example.restbank.model.Accounts;
import com.example.restbank.reapsitory.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {
    @Autowired
    private AccountsRepository accountRepository;

    public void createAccount(Accounts acct) {
        accountRepository.save(acct);
    }

    public Accounts getAccountInfo(int acctID) {
        return accountRepository.findById(acctID).orElse(null);
    }

    public void deleteAccount(int acctID) {
        accountRepository.deleteById(acctID);
    }

    public int getBalance(int acctID) {
        return accountRepository.findBalanceByAcctID(acctID);
    }

    public void depositAmount(int acctID, int amount) {
        accountRepository.saveBalanceByAcctID(acctID, amount);
    }

    public void withdrawAmount(int acctID, int amount) {
        accountRepository.withdrawAmountByAcctID(acctID, amount);
    }

    public void transferAmount(int acctID, int destAcctID, int amount) {
        accountRepository.withdrawAmountByAcctID(acctID, amount);
        accountRepository.saveBalanceByAcctID(destAcctID, amount);
    }

}