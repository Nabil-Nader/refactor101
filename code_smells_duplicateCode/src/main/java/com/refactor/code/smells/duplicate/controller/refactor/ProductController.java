package com.refactor.code.smells.duplicate.controller.refactor;

import com.refactor.code.smells.duplicate.dto.ProductDto;
import com.refactor.code.smells.duplicate.dto.Response;
import com.refactor.code.smells.duplicate.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.refactor.code.smells.duplicate.error.DuplicateProductErrorMessage;
import com.refactor.code.smells.duplicate.error.ErrorMessage;
import com.refactor.code.smells.duplicate.error.InvalidProductErrorMessage;
import com.refactor.code.smells.duplicate.error.InvalidProductPriceErrorMessage;
import com.refactor.code.smells.duplicate.model.Product;

@RestController
@RequiredArgsConstructor
public class ProductController { // NOPMD by ahmed on 5/25/23, 10:17 AM
	

	
	
	@Autowired
	private final ProductService productService; // NOPMD by ahmed on 5/25/23, 10:15 AM

	@PostMapping("/refactor/products")
	public Response createProduct(@RequestBody final ProductDto product) {

		return  productService.createProduct(product);

	}
	
	

}