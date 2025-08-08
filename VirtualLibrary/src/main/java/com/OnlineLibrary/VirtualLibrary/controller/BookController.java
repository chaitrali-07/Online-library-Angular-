package com.OnlineLibrary.VirtualLibrary.controller;

import com.OnlineLibrary.VirtualLibrary.Book;
import com.OnlineLibrary.VirtualLibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

    
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return bookRepository.findById(id).map(book -> {
            book.setBkname(updatedBook.getBkname());
            book.setBkauth(updatedBook.getBkauth());
            book.setAvailable(updatedBook.isAvailable());
            return bookRepository.save(book);
        }).orElse(null);
    }

    @PutMapping("/{id}/borrow")
    public ResponseEntity<Book> borrowBook(@PathVariable Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            if (book.getQuantity() > 0) {
                book.setQuantity(book.getQuantity() - 1);
                book.setAvailable(book.getQuantity() > 0);
                bookRepository.save(book);
                return ResponseEntity.ok(book);
            } else {
                return ResponseEntity.badRequest().build(); 
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<Book> returnBook(@PathVariable Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setQuantity(book.getQuantity() + 1);
            book.setAvailable(true);
            bookRepository.save(book);
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.notFound().build();
    }
}
