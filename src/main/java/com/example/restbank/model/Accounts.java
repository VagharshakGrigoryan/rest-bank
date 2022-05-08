package com.example.restbank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountID;
    private int balance;
    private String acctStatus;

    public Accounts() {

    }

    public Accounts(int accountID, int balance, String acctStatus) {
        super();
        this.accountID = accountID;
        this.balance = balance;
        this.acctStatus = acctStatus;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int acctID) {
        this.accountID = acctID;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return accountID == accounts.accountID && balance == accounts.balance && Objects.equals(acctStatus, accounts.acctStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountID, balance, acctStatus);
    }
}