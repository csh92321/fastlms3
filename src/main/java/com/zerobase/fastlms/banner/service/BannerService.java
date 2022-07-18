package com.zerobase.fastlms.banner.service;

import com.zerobase.fastlms.banner.dto.BannerDto;
import com.zerobase.fastlms.banner.model.BannerParam;

import java.util.List;

public interface BannerService {

    List<BannerDto> list(BannerParam parameter);

    boolean add(BannerParam parameter);

    BannerDto getById(long id);

    boolean set(BannerParam parameter);

    boolean del(String idList);

    List<BannerDto> mainList(BannerParam parameter);
    

}
