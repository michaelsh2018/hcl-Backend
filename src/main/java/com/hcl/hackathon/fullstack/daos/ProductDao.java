package com.hcl.hackathon.fullstack.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.hackathon.fullstack.beans.Product;

public interface ProductDao extends JpaRepository <Product, Integer>{

}
