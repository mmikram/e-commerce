package com.ghazitrader.ghazimart.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

import com.ghazitrader.ghazimart.dao.BannerRepository;
import com.ghazitrader.ghazimart.error.FileStorageException;
import com.ghazitrader.ghazimart.model.BannerModel;

@Service
public class FileStorageService {

    @Autowired
    public BannerRepository repository;

    public String storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        // Check if the file's name contains invalid characters
        if (fileName.contains("..")) {
            throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
        }

        return fileName;

    }

    public BannerModel saveBanner(final BannerModel bannerModel) {
       return repository.save(bannerModel);
    }

    public List<BannerModel> getProductBanner(final int productId) {
        final List<BannerModel> banners = repository.findByProductId(productId);
        return banners;
    }

    public BannerModel getCategoryBanner(final int catId) {
        final BannerModel banner = repository.findByCatId(catId);
        return banner;
    }

    public BannerModel getSubCategoryBanner(final int subCatId) {
        final BannerModel banner = repository.findBySubCatId(subCatId);
        return banner;
    }
}
