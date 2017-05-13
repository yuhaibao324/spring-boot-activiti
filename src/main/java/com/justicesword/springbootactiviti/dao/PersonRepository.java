package com.justicesword.springbootactiviti.dao;

import com.justicesword.springbootactiviti.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by JusticeSword on 2017/05/14.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	public Person findByPersonName(String personName);
	
}

