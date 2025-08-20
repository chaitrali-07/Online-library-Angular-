import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';   
import { HttpClientModule } from '@angular/common/http';
import { BookListComponent } from "./components/book-list/book-list";
import { AddBookComponent } from "./components/add-book/add-book";  

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    FormsModule,
    HttpClientModule,
    BookListComponent,
    AddBookComponent,
   // RouterOutlet
  ],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class App {
  protected readonly title = signal('online-library-frontend');
}
