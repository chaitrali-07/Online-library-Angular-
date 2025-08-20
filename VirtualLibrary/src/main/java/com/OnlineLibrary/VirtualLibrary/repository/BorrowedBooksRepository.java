package com.OnlineLibrary.VirtualLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.OnlineLibrary.VirtualLibrary.BorrowedBooks;

public interface BorrowedBooksRepository extends JpaRepository<BorrowedBooks, Long> {
}