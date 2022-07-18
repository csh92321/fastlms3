package com.zerobase.fastlms.banner.entity;

import com.zerobase.fastlms.member.entity.MemberCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Banner implements BannerCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    String bannerName;
    String link;
    String way;
    int sortValue;
    boolean open;
    LocalDateTime regDt;


    String filename;
    String urlFilename;

    

    
}
