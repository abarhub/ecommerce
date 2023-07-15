package org.ecommerce.order.services;

import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.ecommerce.order.dao.domain.Product;
import org.ecommerce.order.dao.repository.ProductRepository;
import org.ecommerce.orderdto.dto.ListProductDto;
import org.ecommerce.orderdto.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * get all products
     *
     * @return all products
     */
    @Transactional
    public ListProductDto getAllProducts() {
        ListProductDto listProductDto = new ListProductDto();
        listProductDto.setProductDtoList(new ArrayList<>());

        Iterable<Product> iterable = productRepository.findAll();
        if (iterable != null) {
            for (Product product : iterable) {

                ProductDto productDto = new ProductDto();
                productDto.setId(product.getId());
                productDto.setName(product.getName());
                productDto.setCode(product.getCode());
                productDto.setQuantite(product.getQuantite());

                listProductDto.getProductDtoList().add(productDto);
            }
        }

        return listProductDto;
    }

    @Transactional
    public void addProduct(ProductDto productDto) {
        if (productRepository.findByCode(productDto.getCode()).isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.PRECONDITION_FAILED,
                    "Product already exists");
        }
        Product product = new Product();
        product.setName(productDto.getName());
        product.setCode(productDto.getCode());
        product.setQuantite(productDto.getQuantite());
        productRepository.save(product);
    }

    @Transactional
    public void restock(String code, int amount) {
        if (StringUtils.isBlank(code)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Code is empty");
        }
        if (amount <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "amount must be positive");
        }
        var countUpdated = productRepository.updateQuantity(code, amount);
        if (countUpdated == 0) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Product '" + code + "' not found");
        }

    }

    @Transactional
    public void sell(String code, int amount) {
        if (StringUtils.isBlank(code)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Code is empty");
        }
        if (amount <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Amount must be positive (amount=" + amount + ")");
        }
        var productOpt = productRepository.findByCode(code);
        if (productOpt.isPresent()) {
            var product = productOpt.get();
            if (amount >= product.getQuantite()) {
                var countUpdated = productRepository.updateQuantity(code, -amount);
                if (countUpdated == 0) {
                    throw new ResponseStatusException(
                            HttpStatus.INTERNAL_SERVER_ERROR,
                            "Product '" + code + "' not updated");
                }
            } else {
                throw new ResponseStatusException(
                        HttpStatus.PRECONDITION_FAILED,
                        "Amount must be greater than stock (amount=" + amount + "> stock=" + product.getQuantite() + ")");
            }
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Product '" + code + "' not found");
        }
    }
}
