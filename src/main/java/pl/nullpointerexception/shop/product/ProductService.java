package pl.nullpointerexception.shop.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Book> getProducts() {
        return productRepository.findAll();
    }
}
