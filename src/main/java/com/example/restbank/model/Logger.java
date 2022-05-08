package com.example.restbank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Logger {

    @Id
    private int acctID;
    private String transactionType;
    private String transactionStatus;
    private int initBal;
    private int finalBal;

    public Logger() {

    }

    public Logger(int acctID, String transactionType, String transactionStatus, int initBal, int finalBal) {
        super();
        this.acctID = acctID;
        this.transactionType = transactionType;
        this.transactionStatus = transactionStatus;
        this.initBal = initBal;
        this.finalBal = finalBal;
    }

    public int getAcctID() {
        return acctID;
    }

    public void setAcctID(int acctID) {
        this.acctID = acctID;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transacType) {
        this.transactionType = transacType;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public int getInitBal() {
        return initBal;
    }

    public void setInitBal(int initBal) {
        this.initBal = initBal;
    }

    public int getFinalBal() {
        return finalBal;
    }

    public void setFinalBal(int finalBal) {
        this.finalBal = finalBal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Logger logger = (Logger) o;
        return acctID == logger.acctID && initBal == logger.initBal && finalBal == logger.finalBal && Objects.equals(transactionType, logger.transactionType) && Objects.equals(transactionStatus, logger.transactionStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acctID, transactionType, transactionStatus, initBal, finalBal);
    }
}