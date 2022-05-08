package com.example.restbank.controller;

import com.example.restbank.model.Logger;
import com.example.restbank.service.LoggerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoggerController {

    private final LoggerService loggerService;

    public LoggerController(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    public void addLog(Logger logger) {
        loggerService.addLog(logger);
    }

    @GetMapping("/account/{accountID}/logs")
    public Logger showLog(@PathVariable int accountID) {
        return loggerService.showLog(accountID);
    }

    public void deleteLog(int acctID) {
        loggerService.deleteLog(acctID);
    }
}