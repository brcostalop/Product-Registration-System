import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {JsonPipe} from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HttpClientModule, JsonPipe],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('products');
  texto: any = '';
  message = signal<string>('');

  constructor(private http: HttpClient) {
  }

  funcaoAPI() {
    // this.http.get('http://localhost:8080/api/hello').subscribe({
    this.http.post('http://localhost:8080/api/hello',{name: 'Bruno'}).subscribe({
    // this.http.put('http://localhost:8080/api/hello/123',{name: 'Bruno'}).subscribe({
    // this.http.delete('http://localhost:8080/api/hello/123').subscribe({
      next: (data) => {
        this.texto = data;
        console.log(data);
      },
      error: (err) => {
        console.log(err);
      }
    })
  }
}
