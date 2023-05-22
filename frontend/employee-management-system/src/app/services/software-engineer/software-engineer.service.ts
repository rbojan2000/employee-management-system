import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from '../auth/auth.service';

@Injectable({
  providedIn: 'root'
})
export class SoftwareEngineerService {
  

  apiHost: string = 'https://localhost:8443/software-engineer';
  headers: HttpHeaders = new HttpHeaders({
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + this.auth.getToken()
  });

  constructor(private http: HttpClient, private auth: AuthService) {}

  getByID(id: string): Observable<any[]> {
    return this.http.get<any[]>(this.apiHost + "/"+ id, {
      headers: this.headers,
    });
  }

  update(user: any) {
    return this.http.put<any[]>(this.apiHost, JSON.stringify(user) , {
      headers: this.headers,
    });
  }
}
