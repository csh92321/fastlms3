package com.zerobase.fastlms.member.repository;

import com.zerobase.fastlms.member.entity.LogInHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogInHistoryRepository extends JpaRepository<LogInHistory, Long> {

    List<LogInHistory> findByUserId(String userId);
}
