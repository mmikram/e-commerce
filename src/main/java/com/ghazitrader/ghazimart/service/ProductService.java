package com.ghazitrader.ghazimart.service;

import java.util.ArrayList;
import java.util.List;

import com.ghazitrader.ghazimart.dao.OfferMappingRepository;
import com.ghazitrader.ghazimart.dao.ProductRepository;
import com.ghazitrader.ghazimart.dao.ProductValueRepository;
import com.ghazitrader.ghazimart.dao.TempProductRepository;
import com.ghazitrader.ghazimart.model.OfferMappingModel;
import com.ghazitrader.ghazimart.model.ProductModel;
import com.ghazitrader.ghazimart.model.ProductValue;
import com.ghazitrader.ghazimart.model.TempProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public OfferMappingRepository offerMappingRepository;

    @Autowired
    public ProductValueRepository valueRepository;

    @Autowired
    private TempProductRepository tempProductRepository;

    public ProductModel saveProduct(final ProductModel product) {
        return productRepository.save(product);
    }

    /**
     * get All product
     * 
     * @return
     */
    public List<ProductModel> getAllProduct() {
        final List<ProductModel> products = new ArrayList<ProductModel>();
        productRepository.findAll().forEach(product -> products.add(product));
        return products;
    }

    public List<ProductModel> getUserProduct(final int userId) {
        List<ProductModel> productResponse = (List<ProductModel>) productRepository.findByUserId(userId);
        return productResponse;
    }

    public List<ProductModel> getCatProduct(final int subCatId) {
        List<ProductModel> productResponse = (List<ProductModel>) productRepository.findBySubCatId(subCatId);
        return productResponse;
    }

    public List<ProductModel> getProductForVerify(final boolean isVerified) {
        List<ProductModel> productResponse = (List<ProductModel>) productRepository.findByIsVerified(isVerified);
        return productResponse;
    }

    public void productStatus(final int productId, final int status) {
        final ProductModel product = productRepository.findById(productId).get();
        product.setStatus(status);
        productRepository.save(product);
    }

    public void saveProductValue(final ProductValue productValue) {
        valueRepository.save(productValue);
    }

    public List<ProductValue> getProductValue(final int productId) {
        return valueRepository.findByProductId(productId);
    }

    public List<ProductModel> getProductDetails(final List<Integer> productIds) {
        final List<ProductModel> favourities = (List<ProductModel>) productRepository.findAllById(productIds);
        return favourities;
    }

    public List<ProductModel> getOfferProducts(final List<Integer> subCatIds) {
        return productRepository.findOfferProduct(subCatIds);
    }

    public List<ProductModel> getUnVerifiedProduct() {
        return productRepository.findUnVerifiedProduct();
    }

    public void verifiedProduct(final int productId) {
        productRepository.verifyProduct(productId);
    }

    public List<ProductModel> getOfferProsucts(final int offerId) {
        final List<Integer> productIds = offerMappingRepository.findProductId(offerId);
        return getProductDetails(productIds);
    }

    public OfferMappingModel saveOfferProduct(final OfferMappingModel mappingModel) {
        return offerMappingRepository.save(mappingModel);
    }

    public void removeOfferProduct(final OfferMappingModel mappingModels) {
        offerMappingRepository.delete(mappingModels);
    }

    public void removeOfferProductBySubCat(final int subCatId) {
        offerMappingRepository.deleteOfferItemBySlideOfferId(subCatId);
    }

    /**
     * Temp Product
     */
    public TempProduct addTempProduct(final TempProduct entity) {
        return tempProductRepository.save(entity);
    }

    public List<TempProduct> listOfTempProduct(final int page, final int size) {
        Pageable firstPageWithTwoElements = PageRequest.of(page, size);
        final List<TempProduct> tempProducts = new ArrayList<>();
        tempProductRepository.findAll(firstPageWithTwoElements).forEach(action -> tempProducts.add(action));
        return tempProducts;
    }

    public TempProduct updatTempProductBanner(final int productId, final String banner) {
        final TempProduct tempProduct = tempProductRepository.findById(productId).get();
        tempProduct.setBanner(banner);
        return tempProductRepository.save(tempProduct);
    }
}
