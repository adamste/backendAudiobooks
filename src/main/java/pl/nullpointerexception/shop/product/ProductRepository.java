package pl.nullpointerexception.shop.product;

import org.springframework.data.jpa.repository.JpaRepository;

interface ProductRepository extends JpaRepository<Book, Long> {
}
