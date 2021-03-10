package com.ghazitrader.ghazimart.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

import com.ghazitrader.ghazimart.model.BannerModel;
import com.ghazitrader.ghazimart.model.StandardRequest;
import com.ghazitrader.ghazimart.model.StandardResponse;
import com.ghazitrader.ghazimart.model.TempProduct;
import com.ghazitrader.ghazimart.service.FileStorageService;
import com.ghazitrader.ghazimart.service.ValidationUtil;
import com.ghazitrader.ghazimart.utils.ActionName;
import com.ghazitrader.ghazimart.utils.CommanUtil;
import com.ghazitrader.ghazimart.utils.ConvertorUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class AdminController {

    @Autowired
    public ValidationUtil validationUtil;

    @Autowired
    private FileStorageService fileStorageService;

    @RequestMapping("/")
    public String wellCome() {
        return "Welcome to Ghazi world";

    }

    @PostMapping("/admin")
    private StandardResponse getAdmin(@RequestBody StandardRequest standardRequest) {
        if (null != standardRequest) {
            if (CommanUtil.isTokenValid(standardRequest.getToken())) {
                if (CommanUtil.isNotEmptyOrNotNull(standardRequest.getActionName())) {
                    switch (standardRequest.getActionName()) {
                    case ActionName.ALL_ADMIN:
                        return validationUtil.getAllAdmin();
                    case ActionName.REGISTER_ADMIN:
                        return validationUtil.saveAdmin(standardRequest.getData());
                    case ActionName.PARENT_ADMIN:
                        return validationUtil.getParentAdmin(standardRequest.getData());
                    case ActionName.UPDATE_ADMIN:
                        return validationUtil.updateAdmin(standardRequest.getData());
                    case ActionName.ADMIN_LOGIN:
                        return validationUtil.adminLoginService(standardRequest.getData());
                    case ActionName.ADMIN_STATUS:
                        return validationUtil.AdminActiveDeActive(standardRequest.getData());
                    case ActionName.REGISTER_CATEGORY:
                        return validationUtil.saveCotegory(standardRequest.getData());
                    case ActionName.ALL_CATEGORY:
                        return validationUtil.getCategory();
                    case ActionName.CATEGORY_STATUS:
                        return validationUtil.categoryActiveDeActive(standardRequest.getData());
                    case ActionName.REGISTER_SUB_CATEGORY:
                        return validationUtil.savesubCotegory(standardRequest.getData());
                    case ActionName.ALL_SUB_CATEGORY:
                        return validationUtil.getSubCategory();
                    case ActionName.CATEGORY_SUB_CATEGORY:
                        return validationUtil.getCatSubCat(standardRequest.getData());
                    case ActionName.SUB_CATEGORY_STATUS:
                        return validationUtil.subCategoryActiveDeActive(standardRequest.getData());
                    case ActionName.CATEGORY_PRODUCT:
                        return validationUtil.getCategoryProducts(standardRequest.getData());
                    case ActionName.USER_PRODUCT:
                        return validationUtil.getUserProducts(standardRequest.getData());
                    case ActionName.SAVE_PRODUCT:
                        return validationUtil.saveProduct(standardRequest.getData());
                    case ActionName.SAVE_PRODUCT_VALUE:
                        return validationUtil.saveProductValue(standardRequest.getData());
                    case ActionName.PRODUCT_VALUE:
                        return validationUtil.getProductValue(standardRequest.getData());
                    case ActionName.ADD_FAVOURITE:
                        return validationUtil.addFavourite(standardRequest.getData());
                    case ActionName.CUSTOMER_FAVOURITE:
                        return validationUtil.customerFavItems(standardRequest.getData());
                    case ActionName.CUSTOMER_REGISTER:
                        return validationUtil.registerCustomer(standardRequest.getData());
                    case ActionName.SAVE_ORDER:
                        return validationUtil.saveOrder(standardRequest.getData());
                    case ActionName.SUB_CAT_IDS:
                        return validationUtil.getCatSubIds(standardRequest.getData());
                    case ActionName.UN_VERIFY_PRODUCTS:
                        return validationUtil.getUnVerifiedProduct();
                    case ActionName.VERIFY_PRODUCT:
                        return validationUtil.updateVerifiedProduct(standardRequest.getData());
                    case ActionName.OFFER_PRODUCTS:
                        return validationUtil.getOfferProducts(standardRequest.getData());
                    case ActionName.SAVE_OFFER_PRODUCT:
                        return validationUtil.saveOfferProducts(standardRequest.getData());
                    case ActionName.DELETE_OFFER_PRODUCT:
                        return validationUtil.deleteOfferProducts(standardRequest.getData());
                    case ActionName.SLIDE_OFFER:
                        return validationUtil.getSlideOffer();
                    case ActionName.DELETE_SLIDE_OFFER:
                        return validationUtil.removeSlideOfferBySubCategory(standardRequest.getData());
                    case ActionName.HOME_SCREEN:
                        return validationUtil.HomeScreenData();
                    case ActionName.SAVE_STORE_ADDRESS:
                        return validationUtil.saveCustAddress(standardRequest.getData());
                    case ActionName.STORE_ADDRESS_MOBILE:
                        return validationUtil.storeAddresByMobileNo(standardRequest.getData());
                    case ActionName.STORE_ADDRESS_NAME:
                        return validationUtil.storeAddresByCustName(standardRequest.getData());
                    case ActionName.SAVE_TEMP_PRODUCT:
                        return validationUtil.saveTempProduct(standardRequest.getData());
                    case ActionName.LIST_TEMP_PRODUCT:
                        return validationUtil.tempProdustList(standardRequest.getData());
                    case ActionName.SAVE_TEMP_ORDER:
                        return validationUtil.saveTempOrder(standardRequest.getData());
                    case ActionName.LIST_TEMP_ORDER:
                        return validationUtil.listOfTempOrder(standardRequest.getData());
                    case ActionName.CUSTOMER_ADDRESS_SAVE:
                        return validationUtil.saveCustomerAddress(standardRequest.getData());
                    case ActionName.GET_CUSTOMER_ADDRESS:
                        return validationUtil.customerAddress(standardRequest.getData());
                    case ActionName.CUSTOMER_ORDER:
                        return validationUtil.customerOders(standardRequest.getData());
                    case ActionName.PRICE_SAVE:
                        return validationUtil.savePrice(standardRequest.getData());
                    case ActionName.PRODUCT_PRICE_LIST:
                        return validationUtil.produstPriceList(standardRequest.getData());
                    case ActionName.SENT_OTP:
                        return validationUtil.customerRagistration(standardRequest.getData());
                    case ActionName.VERYFY_OTP:
                        return validationUtil.verifyOtp(standardRequest.getData());
                    default:
                        return CommanUtil.errorResponse("Action Not Match");
                    }

                } else {
                    return CommanUtil.errorResponse("Invalid Action Name");
                }

            } else {
                return CommanUtil.errorResponse("Invalid Token");
            }

        } else {
            return CommanUtil.errorResponse("Invalid Request");
        }
    }

    @PostMapping("/uploadFile")
    public BannerModel uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("productId") String productId,
            @RequestParam("catId") String catId, @RequestParam("subCatId") String subCatId) {
        String fileName = fileStorageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
                .path(fileName).toUriString();
        final BannerModel banner = new BannerModel(fileName, fileDownloadUri, file.getContentType(), file.getSize(),
                ConvertorUtil.stringToInt(productId), ConvertorUtil.stringToInt(catId),
                ConvertorUtil.stringToInt(subCatId));
        return validationUtil.uploadFileOnS3(fileName, file, banner);

    }

    @PostMapping("/uploadMultipleFiles")
    public List<BannerModel> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files,
            @RequestParam("productId") String productId) {
        return Arrays.asList(files).stream().map(file -> uploadFile(file, productId, "0", "0"))
                .collect(Collectors.toList());
    }

    @PostMapping("/uploadTempFile")
    public TempProduct uploadTempProductFile(@RequestParam("file") MultipartFile file,
            @RequestParam("productId") String productId) {
        String fileName = fileStorageService.storeFile(file);
        return validationUtil.updateTempProductBanner(fileName, file, ConvertorUtil.stringToInt(productId));
    }

}
