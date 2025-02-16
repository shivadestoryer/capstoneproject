package com.scaler.capstoneproject.service.implementation;

import com.scaler.capstoneproject.dto.FakeStoreProductDto;
import com.scaler.capstoneproject.service.FakeStoreService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreServiceImpl implements FakeStoreService {

    private static final Logger log = LoggerFactory.getLogger(FakeStoreServiceImpl.class);
    @Value("fakeStoreBaseUrl")
    String fakeStoreBaseUrl;

    private final String fakeStoreBaseUrlBkp="https://fakestoreapi.com/products";

    private final RestTemplate restTemplate;
    FakeStoreServiceImpl(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;
    }


    @Override
    public FakeStoreProductDto getProductById(long id) {
        log.info(fakeStoreBaseUrl);
        return restTemplate.getForObject(fakeStoreBaseUrlBkp+"/"+id, FakeStoreProductDto.class);
    }
}
