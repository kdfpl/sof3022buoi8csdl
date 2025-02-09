package com.example.buoi8.repository;

import com.example.buoi8.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    //C1: Query creation (nen xai)
    Optional<Category> findCategoryByIdAndCategoryCode(Long id, String categoryCode);

    //C2: Raw SQL
    //C2.1: JPQL
    @Query("SELECT c FROM Category c WHERE c.id = ?1 AND c.categoryName = ?2")
    Optional<Category> search(Long id, String name);

    //C2.2: Native query (kho vai ca chuong)
    @Query(value = "SELECT * FROM category WHERE id = ?1 AND category_name = ?2", nativeQuery = true)
    Optional<Category> search1(Long id, String name);
}