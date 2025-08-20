import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Book } from '../../model/book';
import { BookService } from '../../services/book.service';

@Component({
  selector: 'app-book-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './book-list.html'
})
export class BookListComponent implements OnInit {
  bookList: Book[] = [];

  constructor(private bookService: BookService) {}

  ngOnInit(): void {
    this.loadBooks();
  }

  loadBooks(): void {
    this.bookService.getAllBooks().subscribe({
      next: (data) => {
        this.bookList = data;
      },
      error: (err) => console.error('Error fetching books', err)
    });
  }

  borrowBook(book: Book): void {
    if (!book.bkid) return;
    this.bookService.borrowBook(book.bkid).subscribe({
      next: () => this.loadBooks(),
      error: (err) => console.error('Error borrowing book', err)
    });
  }

  returnBook(book: Book): void {
    if (!book.bkid) return;
    this.bookService.returnBook(book.bkid).subscribe({
      next: () => this.loadBooks(),
      error: (err) => console.error('Error returning book', err)
    });
  }
}
