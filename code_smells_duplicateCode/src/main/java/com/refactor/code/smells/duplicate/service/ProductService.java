package com.refactor.code.smells.duplicate.service;

import com.refactor.code.smells.duplicate.dto.ProductDto;
import com.refactor.code.smells.duplicate.dto.Response;

public interface ProductService {

    Response createProduct(ProductDto product);
}
