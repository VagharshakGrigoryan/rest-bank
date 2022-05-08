package com.example.restbank.service;

import com.example.restbank.model.Logger;
import com.example.restbank.reapsitory.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {
    final LoggerRepository loggerRepository;

    public LoggerService(LoggerRepository loggerRepository) {
        this.loggerRepository = loggerRepository;
    }

    public void addLog(Logger logger) {
        loggerRepository.save(logger);
    }

    public Logger showLog(int acctID) {
        return loggerRepository.findById(acctID).orElse(null);
    }

    public void deleteLog(int acctID) {
        loggerRepository.deleteById(acctID);
    }
}