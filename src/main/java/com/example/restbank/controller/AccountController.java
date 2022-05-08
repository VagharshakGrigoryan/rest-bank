package com.example.restbank.controller;

import com.example.restbank.model.Accounts;
import com.example.restbank.model.Logger;
import com.example.restbank.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private final AccountService accountService;
    private final LoggerController loggerController;

    public AccountController(AccountService accountService, LoggerController loggerController) {
        this.accountService = accountService;
        this.loggerController = loggerController;
    }

    public void createAccount(int acctID, int balance, String acctStatus) {
        Accounts acct = new Accounts(acctID, balance, acctStatus);
        accountService.createAccount(acct);
    }

    @GetMapping("/account/{accountID}/balance")
    public int getBalance(@PathVariable int accountID) {
        return accountService.getBalance(accountID);
    }

    @PutMapping("/account/{accountID}/deposit/{amount}")
    public void depositAmount(@PathVariable int accountID, @PathVariable int amount) {
        int initBal = getBalance(accountID);
        accountService.depositAmount(accountID, amount);
        Logger logger = new Logger(accountID, "Deposited", "Success", initBal, initBal + amount);
        loggerController.addLog(logger);
    }

    @PutMapping("/account/{accountID}/withdraw/{amount}")
    public void withdrawAmount(@PathVariable int accountID, @PathVariable int amount) {
        int initBal = getBalance(accountID);
        accountService.withdrawAmount(accountID, amount);
        Logger logger = new Logger(accountID, "Withdrawn", "Success", initBal, initBal - amount);
        loggerController.addLog(logger);
    }

    @PutMapping("/account/{accountID}/transfer/{destAcctID}/{amount}")
    public void transferAmount(@PathVariable int accountID, @PathVariable int destAcctID, @PathVariable int amount) {
        int initBalSender = getBalance(accountID);
        int initBalReceiver = getBalance(destAcctID);
        accountService.transferAmount(accountID, destAcctID, amount);
        Logger loggerSender = new Logger(accountID, "Transferred", "Success", initBalSender, initBalSender - amount);
        loggerController.addLog(loggerSender);
        Logger loggerReceiver = new Logger(destAcctID, "Received", "Success", initBalReceiver,
                initBalReceiver + amount);
        loggerController.addLog(loggerReceiver);
    }

    @DeleteMapping("/account/{accountID}")
    public void deleteAccount(@PathVariable int accountID) {
        accountService.deleteAccount(accountID);
        loggerController.deleteLog(accountID);
    }

    @GetMapping("/account/{accountID}")
    public Accounts getAccountInfo(@PathVariable int accountID) {
        return accountService.getAccountInfo(accountID);
    }

}