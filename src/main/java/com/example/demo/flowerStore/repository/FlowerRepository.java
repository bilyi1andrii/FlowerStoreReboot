package com.example.demo.flowerstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.flowerstore.model.Flower;

@Repository
public interface FlowerRepository extends JpaRepository<Flower, Long> {
}