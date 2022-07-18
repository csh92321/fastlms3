package com.zerobase.fastlms.member.service;

import com.zerobase.fastlms.member.dto.LogInHistoryDto;
import com.zerobase.fastlms.member.entity.LogInHistory;
import com.zerobase.fastlms.member.repository.LogInHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LogInHistoryImpl implements LogInHistoryService {
    
    private final LogInHistoryRepository logInHistoryRepository;

    private Sort getSortBySortValueDesc() {
        return Sort.by(Sort.Direction.DESC, "sortValue");
    }
    
    @Override
    public List<LogInHistoryDto> list(String userId) {
        List<LogInHistory> logInHistories = logInHistoryRepository.findByUserId(userId);
        return LogInHistoryDto.of(logInHistories);
    }

    @Override
    public boolean add(String userId, String clientIp, String userAgent) {
        System.out.println("ip" + clientIp);
        System.out.println("agent" + userAgent);

        LogInHistory logInHistory = LogInHistory.builder()
                .userId(userId)
                .logInDt(LocalDateTime.now())
                .ip(clientIp)
                .userAgent(userAgent)
                .build();
        logInHistoryRepository.save(logInHistory);
        
        return true;
    }

}
