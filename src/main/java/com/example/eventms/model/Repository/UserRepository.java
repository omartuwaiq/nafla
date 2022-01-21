package com.example.eventms.model.Repository;

import com.example.eventms.model.Entities.Admins;
import com.example.eventms.model.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<Users,String>{

    @Query("SELECT password FROM Users WHERE username = :username")
    String findByUsername(@Param("username") String username);

    }
