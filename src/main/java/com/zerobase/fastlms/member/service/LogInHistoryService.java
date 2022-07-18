package com.zerobase.fastlms.member.service;

import com.zerobase.fastlms.member.dto.LogInHistoryDto;

import java.util.List;

public interface LogInHistoryService {


    List<LogInHistoryDto> list(String userId);

    boolean add(String userId, String clientIp, String userAgent);


}
