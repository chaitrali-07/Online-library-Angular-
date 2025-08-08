package com.OnlineLibrary.VirtualLibrary.repository;

import com.OnlineLibrary.VirtualLibrary.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}