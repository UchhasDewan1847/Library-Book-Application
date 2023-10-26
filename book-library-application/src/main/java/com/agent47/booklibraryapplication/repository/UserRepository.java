package com.agent47.booklibraryapplication.repository;

import com.agent47.booklibraryapplication.entity.BookUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<BookUser, UUID> {
    public BookUser findByEmail(String email);
}
