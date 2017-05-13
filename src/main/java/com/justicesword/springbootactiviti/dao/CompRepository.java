package com.justicesword.springbootactiviti.dao;

import com.justicesword.springbootactiviti.model.Comp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompRepository extends JpaRepository<Comp, Long> {
	
}
