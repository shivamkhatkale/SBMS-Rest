package com.app.raghu.dto;

import com.app.raghu.entity.Product;

public class ProductMapper {

	public static Product DtotoEntity(Product product, ProductDTO productDto) {

		product.setPId(productDto.getPId());
		product.setPName(productDto.getPName());
		product.setPAddress(productDto.getPMail());
		product.setPMail(productDto.getPMail());

		return product;
	}

}
