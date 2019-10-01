package com.t1708m.ejb.service;

import com.t1708m.ejb.entity.Product;
import com.t1708m.ejb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Page<Product> getList(int page, int limit) {
        return productRepository.findAll(PageRequest.of(page - 1, limit));
    }

    public Product getDetail(long prodID) {
        return productRepository.findById(prodID).orElse(null);
    }

    public Product update(long prodID, Product product) {
        Product existProduct = productRepository.findById(prodID).orElse(null);
        if (existProduct == null) {
            return null;
        }
        existProduct.setProdName(product.getProdName());
        existProduct.setDescription(product.getDescription());
        existProduct.setPrice(product.getPrice());
        return productRepository.save(product);
    }
}
