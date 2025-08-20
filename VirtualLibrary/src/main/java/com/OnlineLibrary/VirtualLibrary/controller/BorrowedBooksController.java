package com.OnlineLibrary.VirtualLibrary.controller;

import com.OnlineLibrary.VirtualLibrary.Book;
import com.OnlineLibrary.VirtualLibrary.BorrowedBooks;
import com.OnlineLibrary.VirtualLibrary.repository.BookRepository;
import com.OnlineLibrary.VirtualLibrary.repository.BorrowedBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/borrowed")
@CrossOrigin(origins = "http://localhost:4200")
public class BorrowedBooksController {

    @Autowired
    private BorrowedBooksRepository borrowedBooksRepository;

    @Autowired
    private BookRepository bookRepository;

    
    @GetMapping
    public List<BorrowedBooks> getAllBorrowed() {
        return borrowedBooksRepository.findAll();
    }

    
    @PostMapping
    public ResponseEntity<?> borrowBook(@RequestBody BorrowedBooks borrowRequest) {
        Book book = bookRepository.findById(borrowRequest.getBook().getBkid()).orElse(null);
        if (book == null || book.getQuantity() <= 0) {
            return ResponseEntity.badRequest().body("Book not available");
        }

        
        book.setQuantity(book.getQuantity() - 1);
        book.setAvailable(book.getQuantity() > 0);
        bookRepository.save(book);

        
        borrowRequest.setBorrowDate(java.time.LocalDate.now());

        BorrowedBooks saved = borrowedBooksRepository.save(borrowRequest);
        return ResponseEntity.ok(saved);
    }

    
    @PutMapping("/{id}/return")
    public ResponseEntity<?> returnBook(@PathVariable Long id) {
        BorrowedBooks record = borrowedBooksRepository.findById(id).orElse(null);
        if (record == null) {
            return ResponseEntity.notFound().build();
        }

        
        if (record.getReturnDate() != null) {
            return ResponseEntity.badRequest().body("Book already returned");
        }

        Book book = record.getBook();

        if (book.getQuantity() < book.getTotalQuantity()) {
            book.setQuantity(book.getQuantity() + 1);
        }

        book.setAvailable(book.getQuantity() > 0);
        bookRepository.save(book);

       
        record.setReturnDate(java.time.LocalDate.now());
        borrowedBooksRepository.save(record);

        return ResponseEntity.ok(record);
    }
}
