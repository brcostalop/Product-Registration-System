import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class Service {
  constructor(private http: HttpClient) {
  }

  getHello(): Observable<ApiResponse<msg[]>> {
    return this.http.get<ApiResponse<any>>('http://localhost:8080/api/hello');
  }
}

export interface ApiResponse<T> {
  code: number;
   message: string;
   data: T;
}

export interface msg{
  msg: string;
}
