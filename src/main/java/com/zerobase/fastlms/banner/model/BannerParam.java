package com.zerobase.fastlms.banner.model;

import com.zerobase.fastlms.admin.model.CommonParam;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BannerParam extends CommonParam {

    long id;
    String bannerName;

    String link;
    String way;
    int sortValue;
    boolean open;
    LocalDateTime regDt;

    //추가컬럼
    long totalCount;
    long seq;

    String idList;

    String filename;
    String urlFilename;

}
