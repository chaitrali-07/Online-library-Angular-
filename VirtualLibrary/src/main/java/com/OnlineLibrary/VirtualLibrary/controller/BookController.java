package com.OnlineLibrary.VirtualLibrary.controller;

import com.OnlineLibrary.VirtualLibrary.Book;
import com.OnlineLibrary.VirtualLibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        if (book.getTotalQuantity() == 0) {
            book.setTotalQuantity(book.getQuantity());
        }
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
            book.setQuantity(updatedBook.getQuantity());
            book.setGenre(updatedBook.getGenre());
            return bookRepository.save(book);
        }).orElse(null);
    }

    @PutMapping("/{id}/borrow")
    public ResponseEntity<Book> borrowBook(@PathVariable Long id, @RequestParam String username) {
        return bookRepository.findById(id).map(book -> {
            if (book.getQuantity() > 0 && book.isAvailable()) {
                book.setQuantity(book.getQuantity() - 1);
                book.setBorrowedBy(username);
                book.setBorrowDate(LocalDate.now());

                if (book.getQuantity() == 0) {
                    book.setAvailable(false);
                }

                Book savedBook = bookRepository.save(book);
                return ResponseEntity.ok(savedBook);
            } else {
                return ResponseEntity.badRequest().body((Book) null);
            }
        }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<Book> returnBook(@PathVariable Long id) {
        return bookRepository.findById(id).map(book -> {
            if (book.getQuantity() < book.getTotalQuantity()) {
                book.setQuantity(book.getQuantity() + 1);
            }

            book.setReturnDate(LocalDate.now());
            book.setBorrowedBy(null);
            book.setBorrowDate(null);
            book.setAvailable(true);

            return ResponseEntity.ok(bookRepository.save(book));
        }).orElse(ResponseEntity.notFound().build());
    }
}
