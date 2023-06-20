package com.refactor.code.smells.duplicate.service;

import com.refactor.code.smells.duplicate.core.Translator;
import com.refactor.code.smells.duplicate.dto.ProductDto;
import com.refactor.code.smells.duplicate.dto.Response;
import com.refactor.code.smells.duplicate.model.Product;
import com.refactor.code.smells.duplicate.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class ProductServiceImpl  implements  ProductService{

	private final ProductRepository productRepository;
	private final ModelMapper modelMapper;

	@Override
	public Response createProduct(ProductDto dto) {
		Optional<Product> optional = productRepository.findById(dto.getId());

		if(optional.isEmpty()){
			throw new RuntimeException(Translator.getMessage("invalid_product",1L));
		}else {
			Product product = optional.get();

			// we will have our business here,

			return new Response<>(modelMapper.map(product,ProductDto.class));
		}


	}

}
