import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../model/book';

@Injectable({ providedIn: 'root' })
export class BookService {
  private baseUrl = "http://localhost:8080/book";

  constructor(private http: HttpClient) {}

  getAllBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(this.baseUrl);
  }

  addBook(book: Book): Observable<Book> {
    return this.http.post<Book>(this.baseUrl, book);
  }

 
  borrowBook(bkid: number, username = 'guest'): Observable<Book> {
    return this.http.put<Book>(`${this.baseUrl}/${bkid}/borrow?username=${encodeURIComponent(username)}`, {});
  }

  returnBook(bkid: number): Observable<Book> {
    return this.http.put<Book>(`${this.baseUrl}/${bkid}/return`, {});
  }
}
