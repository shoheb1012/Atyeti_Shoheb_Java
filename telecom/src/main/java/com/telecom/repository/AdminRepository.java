package com.telecom.repository;

import com.telecom.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
   Optional <Admin> findByPhoneNumber(String phoneNumber);

   //sfasd
}


