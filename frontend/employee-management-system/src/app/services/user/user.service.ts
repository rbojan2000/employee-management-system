import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'src/app/model/user';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  apiHost: string = 'https://localhost:8443/auth/';
  headers: HttpHeaders = new HttpHeaders({
    'Accept': 'application/json',
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) {}

  register(newUser: User): Observable<any> {
    
    return this.http.post<User>(this.apiHost + 'register', JSON.stringify(newUser), {
      headers: this.headers,
    });
  }

  loginUser(user: User): Observable<any> {
    const body = {
      'username': user.email,
      'password': user.password
    };

    return this.http.post<User>(this.apiHost + 'login', JSON.stringify(body), {
      headers: this.headers,
    });
  }
}
