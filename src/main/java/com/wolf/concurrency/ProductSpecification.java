package com.wolf.concurrency;

import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {
    public static Specification<Product> hasPrice(Long price) {
        if (price != null && price != 0) {
            return (root, query, cb) -> cb.equal(root.get("price"), price);
        }
        return (root, query, cb) -> cb.conjunction();
    }

    public static Specification<Product> hasName(String name) {
        if (name != null && !name.isEmpty()) {
            return (root, query, cb) -> cb.like(root.get("name"), "%" + name + "%");
        }
        return (root, query, cb) -> cb.conjunction();
    }

    public static Specification<Product> hasRank(int rank) {
        if (rank != 0) {
            return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("rank"), rank);
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
    }

    public static Specification<Product> hasCode(String code) {
        if (code != null && !code.isEmpty()) {
            return (root, query, cb) -> cb.like(root.get("code"), "%" + code + "%");
        }
        return (root, query, cb) -> cb.conjunction();
    }

    private ProductSpecification() {
    }
}


