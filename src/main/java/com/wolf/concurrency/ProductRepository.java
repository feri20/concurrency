package com.wolf.concurrency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {
     Optional<Product> findByName(String name);
     Optional<Product> findByRank(int rank);
     Optional<Product> findByCode(String code);
     List<Product> findByNameIsLikeIgnoreCase(String name);

}
