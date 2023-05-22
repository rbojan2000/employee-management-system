import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from './services/auth/auth.service';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {


  apiHost: string = 'https://localhost:8443/project';
  headers: HttpHeaders = new HttpHeaders({
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + this.auth.getToken()
  });

  constructor(private http: HttpClient, private auth: AuthService) {}

  getProjectsForUser(id: string): Observable<any[]> {
    return this.http.get<any[]>(this.apiHost + "/user/"+ id, {
      headers: this.headers,
    });
  }

  update(projectDetails: any) {
    return this.http.put<any[]>(this.apiHost, JSON.stringify(projectDetails) , {
      headers: this.headers,
    });
  }

  
}
