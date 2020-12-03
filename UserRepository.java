package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.usermodel.UserModel;

public interface UserRepository extends JpaRepository<UserModel,Integer> {

}


