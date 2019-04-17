package com.example.StudentMan.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.StudentMan.data.entity.Admin;
@Repository
public interface AdminDao extends JpaRepository<Admin,Integer> {
}