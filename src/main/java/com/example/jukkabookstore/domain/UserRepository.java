package com.example.jukkabookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Userr, Long> {
	Userr findByUsername(String username);
}
