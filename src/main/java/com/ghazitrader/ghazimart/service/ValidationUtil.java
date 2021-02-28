package com.ghazitrader.ghazimart.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.cloudfront.model.PriceClass;
import com.amazonaws.services.s3.AmazonS3;
import com.ghazitrader.ghazimart.model.AddressDetails;
import com.ghazitrader.ghazimart.model.AddressStore;
import com.ghazitrader.ghazimart.model.AdminModel;
import com.ghazitrader.ghazimart.model.BannerModel;
import com.ghazitrader.ghazimart.model.Customer;
import com.ghazitrader.ghazimart.model.Favourite;
import com.ghazitrader.ghazimart.model.HomeDisplayItem;
import com.ghazitrader.ghazimart.model.HomeScreen;
import com.ghazitrader.ghazimart.model.OfferMappingModel;
import com.ghazitrader.ghazimart.model.OrderDetails;
import com.ghazitrader.ghazimart.model.PriceDetails;
import com.ghazitrader.ghazimart.model.ProductCategory;
import com.ghazitrader.ghazimart.model.ProductModel;
import com.ghazitrader.ghazimart.model.ProductValue;
import com.ghazitrader.ghazimart.model.StandardResponse;
import com.ghazitrader.ghazimart.model.SubCategory;
import com.ghazitrader.ghazimart.model.TempOrder;
import com.ghazitrader.ghazimart.model.TempProduct;
import com.ghazitrader.ghazimart.utils.CommanUtil;
import com.ghazitrader.ghazimart.utils.Constants;
import com.ghazitrader.ghazimart.utils.ConvertorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ValidationUtil {
    private Logger logger = LoggerFactory.getLogger(ValidationUtil.class);
    @Autowired
    public AdminService adminService;

    @Autowired
    public ProductCategoryService categoryService;

    @Autowired
    public ProductService productService;

    @Autowired
    public RatingService ratingService;

    @Autowired
    public CustomerService customerService;

    @Autowired
    public OrderService orderService;

    @Autowired
    private AmazonS3 s3client;

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private AddressService addressService;

    @Value("${jsa.s3.bucket}")
    private String bucketName;

    /** Start Admin Service */
    public StandardResponse saveAdmin(final String data) {
        AdminModel adminModel = ConvertorUtil.convertStringToObject(data, AdminModel.class);

        if (null != adminModel) {
            if (!CommanUtil.isNotEmptyOrNotNull(adminModel.getMobleNo())
                    && !isNumberValide(10, 10, adminModel.getMobleNo())) {
                return CommanUtil.errorResponse(Constants.MOBILE_NO_ERROR);
            } else if (!CommanUtil.isNotEmptyOrNotNull(adminModel.getEmail())
                    && !isNumberValide(5, 50, adminModel.getEmail())) {
                return CommanUtil.errorResponse(Constants.MOBILE_NO_ERROR);
            } else if (!CommanUtil.isNotEmptyOrNotNull(adminModel.getFullName())
                    && !isNumberValide(1, 100, adminModel.getFullName())) {
                return CommanUtil.errorResponse(Constants.INVALID_NAME);
            } else if (!CommanUtil.isNotEmptyOrNotNull(adminModel.getFullName())
                    && !isNumberValide(1, 100, adminModel.getFullName())) {
                return CommanUtil.errorResponse(Constants.MOBILE_NO_ERROR);
            } else if (adminService.isEmailExist(adminModel.getEmail())) {
                return CommanUtil.errorResponse(Constants.EMAIL_ID_EXIST);
            } else {
                adminService.saveOrUpdateAdmin(adminModel);
                return CommanUtil.getResponse(Constants.SUCCESSFULLY);
            }
        } else {
            return CommanUtil.errorResponse("");
        }
    }

    public StandardResponse getAllAdmin() {
        return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(adminService.getAllAdmin()));
    }

    public StandardResponse getParentAdmin(final String data) {
        String parentId = ConvertorUtil.getJsonValue(data, "parentId");
        final List<AdminModel> parentAdmins = adminService.getParentAdmin(ConvertorUtil.stringToInt(parentId));
        return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(parentAdmins));
    }

    public StandardResponse updateAdmin(final String data) {
        AdminModel adminModel = ConvertorUtil.convertStringToObject(data, AdminModel.class);
        final AdminModel updatedAdmin = adminService.saveOrUpdateAdmin(adminModel);
        return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(updatedAdmin));
    }

    public StandardResponse AdminActiveDeActive(final String data) {
        String userId = ConvertorUtil.getJsonValue(data, "userId");
        String status = ConvertorUtil.getJsonValue(data, "status");
        adminService.adminStatus(ConvertorUtil.stringToInt(userId), ConvertorUtil.stringToInt(status));
        return CommanUtil.getResponse(Constants.SUCCESSFULLY);
    }

    /** Start Category Service */
    public StandardResponse saveCotegory(final String jsonString) {
        final ProductCategory category = ConvertorUtil.convertStringToObject(jsonString, ProductCategory.class);
        if (null != category) {
            if (!CommanUtil.isNotEmptyOrNotNull(category.getName()) && !isNumberValide(1, 100, category.getName())) {
                return CommanUtil.errorResponse(Constants.BANNER_ERROR);
            } else {
                return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(categoryService.save(category)));
            }
        } else {
            return CommanUtil.errorResponse("Please Add Category");
        }
    }

    public StandardResponse getCategory() {
        return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(categoryService.getAllCatergory()));
    }

    public StandardResponse categoryActiveDeActive(final String data) {
        String cateId = ConvertorUtil.getJsonValue(data, "cateId");
        String status = ConvertorUtil.getJsonValue(data, "status");
        categoryService.categoryStatus(ConvertorUtil.stringToInt(cateId), ConvertorUtil.stringToInt(status));
        return CommanUtil.getResponse(Constants.SUCCESSFULLY);
    }

    /** Start Category Service */
    public StandardResponse savesubCotegory(final String jsonString) {
        final SubCategory category = ConvertorUtil.convertStringToObject(jsonString, SubCategory.class);
        if (null != category) {
            if (!CommanUtil.isNotEmptyOrNotNull(category.getName()) && !isNumberValide(1, 100, category.getName())) {
                return CommanUtil.errorResponse(Constants.BANNER_ERROR);
            } else {
                categoryService.saveSubCategory(category);
                return CommanUtil
                        .getResponse(ConvertorUtil.convertObjectToString(categoryService.saveSubCategory(category)));
            }
        } else {
            return CommanUtil.errorResponse("Please Add Category");
        }
    }

    public StandardResponse getSubCategory() {
        return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(categoryService.getAllSubCategory()));
    }

    public StandardResponse getCatSubCat(final String data) {
        String cateId = ConvertorUtil.getJsonValue(data, "cateId");
        return CommanUtil.getResponse(ConvertorUtil
                .convertObjectToString(categoryService.getSubCatByCatId(ConvertorUtil.stringToInt(cateId))));
    }

    /**
     * Get Product for Offer
     * 
     * @param data category Id
     * @return return Product list
     */
    public StandardResponse getCatSubIds(final String data) {
        String cateId = ConvertorUtil.getJsonValue(data, "catId");
        final List<Integer> subCatIds = categoryService.getSubCatIds(ConvertorUtil.stringToInt(cateId));
        return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(productService.getOfferProducts(subCatIds)));
    }

    /**
     * Find All UnVerify Product
     * 
     * @return UnVerify product
     */
    public StandardResponse getUnVerifiedProduct() {
        return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(productService.getUnVerifiedProduct()));
    }

    /**
     * Verified Product
     * 
     * @param data Product Id
     * @return Success response
     */
    public StandardResponse updateVerifiedProduct(final String data) {
        String productId = ConvertorUtil.getJsonValue(data, "productId");
        productService.verifiedProduct(ConvertorUtil.stringToInt(productId));
        return CommanUtil.getResponse(Constants.SUCCESSFULLY);
    }

    /**
     * get Offer Products
     * 
     * @param data request data
     * @return offer products dertails
     */
    public StandardResponse getOfferProducts(final String data) {
        String slideOfferId = ConvertorUtil.getJsonValue(data, "slideOfferId");
        return CommanUtil.getResponse(ConvertorUtil
                .convertObjectToString(productService.getOfferProsucts(ConvertorUtil.stringToInt(slideOfferId))));
    }

    /**
     * Save Offer Product
     * 
     * @param data
     * @return
     */
    public StandardResponse saveOfferProducts(final String data) {
        final OfferMappingModel mappingModel = ConvertorUtil.convertStringToObject(data, OfferMappingModel.class);
        productService.saveOfferProduct(mappingModel);
        return CommanUtil.getResponse(Constants.SUCCESSFULLY);
    }

    /**
     * Save Offer Product
     * 
     * @param data
     * @return
     */
    public StandardResponse deleteOfferProducts(final String data) {
        final OfferMappingModel mappingModel = ConvertorUtil.convertStringToObject(data, OfferMappingModel.class);
        productService.removeOfferProduct(mappingModel);
        return CommanUtil.getResponse(Constants.SUCCESSFULLY);
    }

    /**
     * get All Slide Offer
     * 
     * @return return offer
     */
    public StandardResponse getSlideOffer() {
        return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(categoryService.getSlidItem()));
    }

    public StandardResponse removeSlideOfferBySubCategory(final String data) {
        String slideOfferId = ConvertorUtil.getJsonValue(data, "slideOfferId");
        categoryService.removeOfferProductBySubCat(ConvertorUtil.stringToInt(slideOfferId));
        productService.removeOfferProductBySubCat(ConvertorUtil.stringToInt(slideOfferId));
        return CommanUtil.getResponse(Constants.SUCCESSFULLY);
    }

    public StandardResponse subCategoryActiveDeActive(final String data) {
        String cateId = ConvertorUtil.getJsonValue(data, "subCatId");
        String status = ConvertorUtil.getJsonValue(data, "status");
        categoryService.subCategoryStatus(ConvertorUtil.stringToInt(cateId), ConvertorUtil.stringToInt(status));
        return CommanUtil.getResponse(Constants.SUCCESSFULLY);
    }

    public StandardResponse saveProduct(final String jsonString) {
        final ProductModel product = ConvertorUtil.convertStringToObject(jsonString, ProductModel.class);
        if (!CommanUtil.isNotEmptyOrNotNull(product.getProductName())
                && !isNumberValide(1, 100, product.getProductName())) {
            return CommanUtil.errorResponse(Constants.INVALID_NAME);
        } else if (product.getUserId() == 0) {
            return CommanUtil.errorResponse(Constants.INVALID_NAME);
        } else if (product.getSubCatId() == 0) {
            return CommanUtil.errorResponse(Constants.INVALID_NAME);
        } else {
            final ProductModel products = productService.saveProduct(product);
            if (null != products) {
                return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(products));
            } else {
                return CommanUtil.errorResponse("Product not Added");
            }

        }
    }

    public StandardResponse getUserProducts(final String data) {
        String userId = ConvertorUtil.getJsonValue(data, "userId");
        final List<ProductModel> products = productService.getUserProduct(ConvertorUtil.stringToInt(userId));
        return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(products));
    }

    public StandardResponse getCategoryProducts(final String data) {
        String subCatId = ConvertorUtil.getJsonValue(data, "subCatId");
        final List<ProductModel> products = productService.getCatProduct(ConvertorUtil.stringToInt(subCatId));
        return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(products));
    }

    public StandardResponse productActiveDeActive(final String data) {
        String productId = ConvertorUtil.getJsonValue(data, "productId");
        String status = ConvertorUtil.getJsonValue(data, "status");
        productService.productStatus(ConvertorUtil.stringToInt(productId), ConvertorUtil.stringToInt(status));
        return CommanUtil.getResponse(Constants.SUCCESSFULLY);
    }

    public StandardResponse saveProductValue(final String data) {
        final ProductValue value = ConvertorUtil.convertStringToObject(data, ProductValue.class);
        if (value.getPrice() <= 0) {
            return CommanUtil.errorResponse(Constants.INVALID_PRICE);
        } else if (!CommanUtil.isNotEmptyOrNotNull(value.getUnitType())) {
            return CommanUtil.errorResponse(Constants.UNIT_TYPE_ERROR);
        } else if (!CommanUtil.isNotEmptyOrNotNull(value.getWeight())) {
            return CommanUtil.errorResponse(Constants.WEIGTH_ERROR);
        } else if (value.getQuanties() <= 0) {
            return CommanUtil.errorResponse(Constants.INVALID_QUANTITY);
        } else {
            productService.saveProductValue(value);
            return CommanUtil.getResponse(Constants.SUCCESSFULLY);
        }
    }

    public StandardResponse getProductValue(final String data) {
        String productId = ConvertorUtil.getJsonValue(data, "productId");
        final List<ProductValue> productValue = productService.getProductValue(ConvertorUtil.stringToInt(productId));
        return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(productValue));
    }

    public StandardResponse adminLoginService(final String data) {
        String password = ConvertorUtil.getJsonValue(data, "password");
        String mobileNo = ConvertorUtil.getJsonValue(data, "mobileNo");

        if (CommanUtil.isNotEmptyOrNotNull(password) && CommanUtil.isNotEmptyOrNotNull(mobileNo)) {
            final AdminModel adminModel = adminService.adminLogin(mobileNo, password);
            if (null != adminModel) {
                return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(adminModel));
            } else {
                return CommanUtil.errorResponse(Constants.UNAUTHOURIZED);
            }
        } else {
            return CommanUtil.errorResponse(Constants.EMPTY);
        }
    }

    /**
     * 
     * @param data
     * @return
     */
    public StandardResponse addFavourite(final String data) {
        final Favourite favourite = ConvertorUtil.convertStringToObject(data, Favourite.class);
        ratingService.addFavourite(favourite);
        return CommanUtil.getResponse(Constants.SUCCESSFULLY);
    }

    public StandardResponse customerFavItems(final String data) {
        final List<ProductModel> favProducts = new ArrayList<>();// productService.customerFavourities(ratingService.getFavProductIds(ConvertorUtil.stringToInt(custId)));
        return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(favProducts));
    }

    public StandardResponse registerCustomer(final String data) {
        final Customer customer = ConvertorUtil.convertStringToObject(data, Customer.class);
        customerService.registerCustomer(customer);
        return CommanUtil.getResponse(Constants.SUCCESSFULLY);
    }

    public StandardResponse saveOrder(final String data) {
        final OrderDetails orderDetails = ConvertorUtil.convertStringToObject(data, OrderDetails.class);
        orderService.saveOrder(orderDetails);
        return CommanUtil.getResponse(Constants.SUCCESSFULLY);
    }

    public StandardResponse getCustOreder(final String data) {
        String custId = ConvertorUtil.getJsonValue(data, "custId");
        final List<OrderDetails> orderDetails = orderService.custOrder(ConvertorUtil.stringToInt(custId));
        return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(orderDetails));
    }

    /**
     * home screen data return
     * 
     * @return
     */
    public StandardResponse HomeScreenData() {

        final HomeScreen homeScree = new HomeScreen();
        // final List<HomeDisplayItem> homeDisplayItems = new ArrayList<>();
        final List<ProductCategory> categories = categoryService.getRandomCategory();

        // homeScree.setCategories(categories);
        homeScree.setSlidingItems(categoryService.getSlidItem());

        homeScree.setHomeDisplayItem(categories);
        return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(homeScree));
    }

    // public StandardResponse HomeScreenProductList() {
    // final List<ProductCategory> categories = categoryService.getRandomCategory();
    // for (ProductCategory pc : categories) {
    // final HomeDisplayItem displayItem = new HomeDisplayItem();
    // displayItem.setCatId(pc.getCatId());
    // displayItem.setCatName(pc.getName());
    // final List<SubCategory> subCategories =
    // categoryService.getSubCatByCatId(pc.getCatId());
    // displayItem.setCategories(subCategories);
    // homeDisplayItems.add(displayItem);
    // }
    // }

    public void putCatBanner(final int catId, final String banner) {
        categoryService.updatCatBanner(catId, banner);
    }

    public void putSubCatBanner(final int subCatId, final String banner) {
        categoryService.updatSubCatBanner(subCatId, banner);
    }

    public BannerModel uploadFileOnS3(final String fileKey, final MultipartFile file, final BannerModel bannerModel) {
        try {
            final File multipartFile = convertMultiPartToFile(file);
            s3client.putObject(bucketName, fileKey, multipartFile);
            if (null != bannerModel) {
                if (bannerModel.getCatId() > 0) {
                    putCatBanner(bannerModel.getCatId(), fileKey);
                } else if (bannerModel.getSubCatId() > 0) {
                    putSubCatBanner(bannerModel.getSubCatId(), fileKey);
                } else if (bannerModel.getProductId() > 0) {
                    bannerModel.setFileDownloadUri(fileKey);
                    return fileStorageService.saveBanner(bannerModel);
                }
            }

            // s3client.getUrl(bucketName, key)
        } catch (AmazonServiceException ase) {
            logger.info("Caught an AmazonServiceException from GET requests, rejected reasons:");
            logger.info("Error Message:    " + ase.getMessage());
            logger.info("HTTP Status Code: " + ase.getStatusCode());
            logger.info("AWS Error Code:   " + ase.getErrorCode());
            logger.info("Error Type:       " + ase.getErrorType());
            logger.info("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            logger.info("Caught an AmazonClientException: ");
            logger.info("Error Message: " + ace.getMessage());
        } catch (Exception ioe) {
            logger.info("IOE Error Message: " + ioe.getMessage());
        }
        return new BannerModel();
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    public boolean isNumberValide(final int min, int max, final String value) {
        if (min <= value.length() && max >= value.length()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Address Management
     * 
     */

    public StandardResponse saveCustomerAddress(final String data) {
        final AddressDetails addressDetails = ConvertorUtil.convertStringToObject(data, AddressDetails.class);
        return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(addressService.saveAddress(addressDetails)));
    }

    public StandardResponse customerAddress(final String data) {
        String mobile = ConvertorUtil.getJsonValue(data, "mobile");
        return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(addressService.custAddressByMobile(mobile)));
    }

    /**
     * Temp Address Management
     * 
     */

    public StandardResponse saveCustAddress(final String data) {
        final AddressStore addressStore = ConvertorUtil.convertStringToObject(data, AddressStore.class);
        return CommanUtil
                .getResponse(ConvertorUtil.convertObjectToString(addressService.saveStoreAddress(addressStore)));
    }

    public StandardResponse storeAddresByMobileNo(final String data) {
        String mobileNo = ConvertorUtil.getJsonValue(data, "mobileNo");
        return CommanUtil
                .getResponse(ConvertorUtil.convertObjectToString(addressService.storeAddressByMobileNo(mobileNo)));
    }

    public StandardResponse storeAddresByCustName(final String data) {
        String custName = ConvertorUtil.getJsonValue(data, "custName");
        return CommanUtil
                .getResponse(ConvertorUtil.convertObjectToString(addressService.storeAddressByCustName(custName)));
    }

    /**
     * Temp App
     */

    public StandardResponse saveTempProduct(final String data) {
        final TempProduct tempProduct = ConvertorUtil.convertStringToObject(data, TempProduct.class);
        return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(productService.addTempProduct(tempProduct)));
    }

    public StandardResponse tempProdustList(final String data) {
        String page = ConvertorUtil.getJsonValue(data, "page");
        String size = ConvertorUtil.getJsonValue(data, "size");

        return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(
                productService.listOfTempProduct(ConvertorUtil.stringToInt(page), ConvertorUtil.stringToInt(size))));
    }

    public StandardResponse saveTempOrder(final String data) {
        final TempOrder tempOrder = ConvertorUtil.convertStringToObject(data, TempOrder.class);
        orderService.saveTempOrder(tempOrder);
        return CommanUtil.getResponse("Your Order Placed Successfully");
    }

    public StandardResponse listOfTempOrder(final String data) {
        String page = ConvertorUtil.getJsonValue(data, "page");
        String size = ConvertorUtil.getJsonValue(data, "size");
        String status = ConvertorUtil.getJsonValue(data, "status");
        return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(orderService.activeTempOrder(
                ConvertorUtil.stringToInt(status), ConvertorUtil.stringToInt(page), ConvertorUtil.stringToInt(size))));
    }

    public StandardResponse customerOders(final String data) {
        String page = ConvertorUtil.getJsonValue(data, "page");
        String size = ConvertorUtil.getJsonValue(data, "size");
        String mobile = ConvertorUtil.getJsonValue(data, "mobile");
        return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(orderService.customerTempOrders(mobile,
                ConvertorUtil.stringToInt(page), ConvertorUtil.stringToInt(size))));

    }

    public TempProduct updateTempProductBanner(final String fileKey, final MultipartFile file, final int productId) {
        File multipartFile;
        try {
            multipartFile = convertMultiPartToFile(file);
            s3client.putObject(bucketName, fileKey, multipartFile);
            return productService.updatTempProductBanner(productId, fileKey);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public StandardResponse savePrice(final String data) {
        final PriceDetails priceDetails = ConvertorUtil.convertStringToObject(data, PriceDetails.class);
        return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(productService.savePrice(priceDetails)));

    }

    public StandardResponse produstPriceList(final String data) {
        String page = ConvertorUtil.getJsonValue(data, "page");
        String size = ConvertorUtil.getJsonValue(data, "size");
        return CommanUtil.getResponse(ConvertorUtil.convertObjectToString(
                productService.listOfProductPrice(ConvertorUtil.stringToInt(page), ConvertorUtil.stringToInt(size))));
    }

}
