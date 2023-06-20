package com.refactor.code.smells.duplicate.controller.refactor;

import com.refactor.code.smells.duplicate.dto.ProductDto;
import com.refactor.code.smells.duplicate.dto.Response;
import com.refactor.code.smells.duplicate.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
public class ProductController {
	

	private final ProductService productService;

	@PostMapping("/refactor/products")
	public Response createProduct(@RequestBody final ProductDto product) {

		return  productService.createProduct(product);

	}
	
	

}