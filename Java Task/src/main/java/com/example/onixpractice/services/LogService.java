package com.example.onixpractice.services;

import com.example.onixpractice.model.Log;
import com.example.onixpractice.model.LogType;
import com.example.onixpractice.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

public interface LogService {
    Log createLog(Long userId, LogType type);
    List<Log> getAllLogs();
    List<Log> getLogsByUserId(Long userId);
}



@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public Log createLog(Long userId, LogType type) {
        Log log = new Log();
        log.setUserId(userId);
        log.setType(type);
        log.setCreatedOn(LocalDateTime.now());
        return logRepository.save(log);
    }

    @Override
    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

    @Override
    public List<Log> getLogsByUserId(Long userId) {
        return logRepository.findByUserId(userId);
    }
}
