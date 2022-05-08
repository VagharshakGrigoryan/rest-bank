package com.example.restbank.reapsitory;

import com.example.restbank.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AccountsRepository extends CrudRepository<Accounts, Integer>, JpaRepository<Accounts, Integer> {
    @Query("select balance from Accounts where accountID = ?1")
    int findBalanceByAcctID(int acctID);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Accounts set balance = balance+?2 where accountID=?1")
    void saveBalanceByAcctID(int acctID, int balance);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Accounts set balance = balance-?2 where accountID=?1")
    void withdrawAmountByAcctID(int acctID, int balance);

}