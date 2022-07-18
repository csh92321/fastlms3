package com.zerobase.fastlms.banner.dto;

import com.zerobase.fastlms.banner.entity.Banner;
import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.course.entity.Course;
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
public class BannerDto {

    Long id;
    private String bannerName;
    private String link;
    private String way;
    private int sortValue;
    private boolean open;
    private LocalDateTime regDt;

    private String filename;
    private String urlFilename;


    //추가컬럼
    long totalCount;
    long seq;


    public static BannerDto of(Banner banner) {
        return BannerDto.builder()
                .id(banner.getId())
                .bannerName(banner.getBannerName())
                .way(banner.getWay())
                .link(banner.getLink())
                .sortValue(banner.getSortValue())
                .open(banner.isOpen())
                .regDt(banner.getRegDt())
                .filename(banner.getFilename())
                .urlFilename(banner.getUrlFilename())
                .build();
    }

    public static List<BannerDto> of(List<Banner> banner) {

        if (banner == null) {
            return null;
        }

        List<BannerDto> bannerList = new ArrayList<>();
        for (Banner x : banner) {
            bannerList.add(BannerDto.of(x));
        }
        return bannerList;

    }

    public String getRegDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        return regDt != null ? regDt.format(formatter) : "";

    }
}

















