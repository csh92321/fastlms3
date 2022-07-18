package com.zerobase.fastlms.member.dto;

import com.zerobase.fastlms.member.entity.LogInHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LogInHistoryDto {
    
    Long id;
    private String userId;
    private LocalDateTime logInDt;
    private String ip;
    private String userAgent;


    //추가컬럼
    long totalCount;
    long seq;

    
    public static LogInHistoryDto of(LogInHistory logInHistory) {
        return LogInHistoryDto.builder()
                .id(logInHistory.getId())
                .userId(logInHistory.getUserId())
                .logInDt(logInHistory.getLogInDt())
                .ip(logInHistory.getIp())
                .userAgent(logInHistory.getUserAgent())
                .build();
    }

    public static List<LogInHistoryDto> of (List<LogInHistory> logInHistories) {
        if (logInHistories != null) {
            List<LogInHistoryDto> logInHistoryList = new ArrayList<>();
            for(LogInHistory x : logInHistories) {
                logInHistoryList.add(of(x));
            }
            return logInHistoryList;
        }

        return null;
    }

    public String getLogInDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        return logInDt != null ? logInDt.format(formatter) : "";

    }
    
}

















