package com.examplechallengebinarc4.challengebinarc4.Repository;

import com.examplechallengebinarc4.challengebinarc4.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Procedure(name = "add_product")
    void addProduct(@Param("productName") String productName, @Param("price") BigDecimal price, @Param("merchantId") UUID merchantId);

    @Procedure(name = "update_product")
    void updateProduct(@Param("productId") UUID productId, @Param("productName") String productName, @Param("price") BigDecimal price, @Param("merchantId") UUID merchantId);

    @Procedure(name = "delete_product")
    void deleteProduct(@Param("productId") UUID productId);

    @Procedure(name = "get_available_products")
    Iterable<Product> getAvailableProducts();
}
