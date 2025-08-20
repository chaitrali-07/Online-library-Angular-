import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Book } from '../../model/book';
import { BookService } from '../../services/book.service';

@Component({
  selector: 'app-add-book',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './add-book.html',
  styleUrls: ['./add-book.css']
})
export class AddBookComponent {
  newBook: Book = {
    bkname: '',
    bkauth: '',
    genre: '',
    quantity: 0,
    available: true,
    totalQuantity: 0   
  };

  constructor(private bookService: BookService) {}

  onSubmit(): void {
    if (this.newBook.bkname && this.newBook.bkauth && this.newBook.genre) {
         this.newBook.totalQuantity = this.newBook.quantity;

      this.bookService.addBook(this.newBook).subscribe({
        next: (book) => {
          alert(`Book "${book.bkname}" added successfully!`);

          this.newBook = { bkname: '', bkauth: '', genre: '', quantity: 0, available: true, totalQuantity: 0 };
        },
        error: (err) => {
          console.error('Error adding book', err);
          alert('Failed to add book. Check backend console for details.');
        }
      });
    } else {
      alert('Please fill in all fields.');
    }
  }
}
