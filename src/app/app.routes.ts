
import { Routes } from '@angular/router';
import { BookListComponent } from './components/book-list/book-list';  
import { AddBookComponent } from './components/add-book/add-book';  

export const routes: Routes = [
  { path: '', component: BookListComponent },   
  { path: 'add-book', component: AddBookComponent } 
];
