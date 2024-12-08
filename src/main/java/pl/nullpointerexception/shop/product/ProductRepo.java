package pl.nullpointerexception.shop.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Book, Long> {
}
