package com.scaler.capstoneproject.service.implementation;


import com.scaler.capstoneproject.dto.FakeStoreProductDto;
import com.scaler.capstoneproject.dto.request.CategoryRequest;
import com.scaler.capstoneproject.dto.request.ProductRequest;
import com.scaler.capstoneproject.dto.request.SellerRequest;
import com.scaler.capstoneproject.dto.response.ProductResponse;
import com.scaler.capstoneproject.dto.response.Rating;
import com.scaler.capstoneproject.models.Category;
import com.scaler.capstoneproject.models.Product;
import com.scaler.capstoneproject.models.Seller;
import com.scaler.capstoneproject.models.SellerProduct;
import com.scaler.capstoneproject.repository.CategoryRepository;
import com.scaler.capstoneproject.repository.ProductRepository;
import com.scaler.capstoneproject.repository.SellerProductRepository;
import com.scaler.capstoneproject.repository.SellerRepository;
import com.scaler.capstoneproject.service.FakeStoreService;
import com.scaler.capstoneproject.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.webjars.NotFoundException;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final CategoryRepository categoryRepository;
    private final FakeStoreService fakeStoreService;
    private final SellerRepository sellerRepository;
    private final ProductRepository productRepository;
    private final SellerProductRepository sellerProductRepository;

    @Autowired
    ProductServiceImpl(FakeStoreService fakeStoreService, SellerRepository sellerRepository,
                       CategoryRepository categoryRepository,
                       ProductRepository productRepository,
                       SellerProductRepository sellerProductRepository) {
        this.fakeStoreService = fakeStoreService;
        this.categoryRepository = categoryRepository;
        this.sellerRepository = sellerRepository;
        this.productRepository = productRepository;
        this.sellerProductRepository = sellerProductRepository;
    }


    @Override
    public ProductResponse findById(long id) {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreService.getProductById(id);
        return buildProductResponse(fakeStoreProductDto);
    }

    @Override
    public Product findById(UUID id) {
        return null;
    }

    @Override
    public void addOrUpdateProduct(Product product) {

    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public void createOrUpdateCategory(CategoryRequest request) {
        Category category = new Category(request.getName());
        categoryRepository.save(category);

    }

    @Override
    public void createOrUpdateSeller(SellerRequest request) {
        if (request.getUuid() == null) {
            createNewSeller(request);
        } else {
            uppadeSellerDetails(request);
        }


    }

    @Override
    public void createOrUpdateProduct(ProductRequest request) {
        Seller seller = sellerRepository.findByUuid(String.valueOf(request.getSellerUuid()));
        if (seller == null) {
            throw new NotFoundException("Seller not found");
        }
        Category category = categoryRepository.findByName(request.getCategoryName());
        if (category == null) {
            throw new NotFoundException("category not found");
        }
        Product product = createProduct(request, category);
        SellerProduct sellerProduct = createSellerProduct(seller, product, request);
        productRepository.save(product);
        sellerProductRepository.save(sellerProduct);
    }

    private SellerProduct createSellerProduct(Seller seller, Product product, ProductRequest request) {
        SellerProduct sellerProduct = new SellerProduct();
        sellerProduct.setProduct(product);
        sellerProduct.setSeller(seller);
        sellerProduct.setStockQuantity(request.getStockQuantity());
        sellerProduct.setPrice(request.getPrice());
        sellerProduct.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        return sellerProduct;

    }

    private Product createProduct(ProductRequest request, Category category) {
        Product product = new Product();
        product.setCreatedBy("system");
        product.setCreatedDate(LocalDateTime.now());
        product.setCategory(category);
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setImageUrl(request.getImageUrl());
        product.setPrice(request.getPrice());
        product.setUuid(UUID.randomUUID());
        return product;
    }

    private void createNewSeller(SellerRequest request) {
        Seller seller = new Seller(request);
        sellerRepository.save(seller);

    }

    private void uppadeSellerDetails(SellerRequest request) {
    }

    private ProductResponse buildProductResponse(FakeStoreProductDto fakeStoreProductDto) {
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(fakeStoreProductDto, productResponse);
        buildRatings(productResponse, fakeStoreProductDto);
        return productResponse;
    }

    private void buildRatings(ProductResponse productResponse, FakeStoreProductDto fakeStoreProductDto) {
        Rating rating = new Rating();
        rating.setRate(fakeStoreProductDto.getRating().getRate());
        rating.setCount(fakeStoreProductDto.getRating().getCount());
        productResponse.setRating(rating);
    }


}
