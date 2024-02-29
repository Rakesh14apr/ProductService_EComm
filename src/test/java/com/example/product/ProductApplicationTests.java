package com.example.product;

import com.example.product.models.Product;
import com.example.product.repositories.ProductRespository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductApplicationTests {

	@Autowired
	ProductRespository productRespository;
	@Test
	void contextLoads() {
	}
	@Test
	public void getSomeData(){
		/*Product product = productRespository.findByName("Mac Book Pro");
		System.out.println(product.getId()+" "+product.getName()+" "+product.getPrice());*/

		Optional<Product> optionalProduct = productRespository.findById(2L);
		if(optionalProduct.isEmpty()){
			return;
		}
		Product product=optionalProduct.get();
		System.out.println(product.getName()+"  "+product.getPrice());
	}
	@Test
	public void getListOfData(){
		List<Product> productByPriceLessThan = productRespository.findProductByPriceLessThan(255000);
		System.out.println("**********Results**********");
		for(Product product: productByPriceLessThan){
			System.out.println(product.getName()+" || "+ product.getPrice());

		}
		System.out.println("***********END**********");
	}

	@Test
	public void deleteData(){

		productRespository.deleteById(3L);
	}
}
