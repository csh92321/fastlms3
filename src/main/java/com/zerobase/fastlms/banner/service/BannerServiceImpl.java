package com.zerobase.fastlms.banner.service;

import com.zerobase.fastlms.banner.dto.BannerDto;
import com.zerobase.fastlms.banner.entity.Banner;
import com.zerobase.fastlms.banner.mapper.BannerMapper;
import com.zerobase.fastlms.banner.model.BannerParam;
import com.zerobase.fastlms.banner.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;
    private final BannerMapper bannerMapper;

    private Sort getSortBySortValueDesc() {
        return Sort.by(Sort.Direction.DESC, "sortValue");
    }

    @Override
    public List<BannerDto> list(BannerParam parameter) {
        List<Banner> banners = bannerRepository.findAll(getSortBySortValueDesc());
        return BannerDto.of(banners);
    }

    @Override
    public boolean add(BannerParam parameter) {

        //카테고리명이 중복인거 체크

        Banner banner = Banner.builder()
                .bannerName(parameter.getBannerName())
                .link(parameter.getLink())
                .way(parameter.getWay())
                .open(parameter.isOpen())
                .sortValue(parameter.getSortValue())
                .regDt(LocalDateTime.now())
                .filename(parameter.getFilename())
                .urlFilename(parameter.getUrlFilename())
                .build();


        bannerRepository.save(banner);

        return true;
    }

    @Override
    public BannerDto getById(long id) {
        return bannerRepository.findById(id).map(BannerDto::of).orElse(null);
    }

    @Override
    public boolean set(BannerParam parameter) {

        Optional<Banner> optionalCourse = bannerRepository.findById(parameter.getId());
        if (!optionalCourse.isPresent()) {
            //수정할 데이터가 없음
            return false;
        }

        Banner banner = optionalCourse.get();
        banner.setBannerName(parameter.getBannerName());
        banner.setLink(parameter.getLink());
        banner.setWay(parameter.getWay());
        banner.setOpen(parameter.isOpen());
        banner.setSortValue(parameter.getSortValue());
        banner.setRegDt(LocalDateTime.now());
        banner.setFilename(parameter.getFilename());
        banner.setUrlFilename(parameter.getUrlFilename());

        bannerRepository.save(banner);

        return true;
    }


    @Override
    public boolean del(String idList) {

        if (idList != null && idList.length() > 0) {
            String[] ids = idList.split(",");
            for (String x : ids) {
                long id = 0L;
                try {
                    id = Long.parseLong(x);
                } catch (Exception e) {

                }
                if (id > 0) {
                    bannerRepository.deleteById(id);
                }
            }
        }

        return true;
    }

    @Override
    public List<BannerDto> mainList(BannerParam parameter) {
        List<Banner> banners = bannerRepository.findByOpen(true, getSortBySortValueDesc());
        return BannerDto.of(banners);
    }
}
