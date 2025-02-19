package com.app.raghu.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.raghu.dto.ProductDTO;
import com.app.raghu.dto.ProductMapper;
import com.app.raghu.entity.Product;
import com.app.raghu.repository.ProductRepository;
import com.app.raghu.service.IProductService;

@Service
public class ProdcutImpl implements IProductService {

	@Autowired
	private ProductRepository repo;

	@Override
	public Integer saveProduct(ProductDTO product) {
		Product prod = ProductMapper.DtotoEntity(new Product(), product);
		Product save = repo.save(prod);
		return save.getPId();
	}

	@Override
	public Product getOneProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOneProduct(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateOneProduct(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> getAllProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
