import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from '../auth/auth.service';

@Injectable({
  providedIn: 'root',
})
export class PermissionService {
  apiHost: string = 'https://localhost:8443/permission';
  headers: HttpHeaders = new HttpHeaders({
    Accept: 'application/json',
    'Content-Type': 'application/json',
    Authorization: 'Bearer ' + this.auth.getToken(),
  });

  constructor(private http: HttpClient, private auth: AuthService) {}

  getAll(): Observable<any[]> {
    return this.http.get<any[]>(this.apiHost, {
      headers: this.headers,
    });
  }

  changePermission(roleName: string, id: any) {

    const body = {
      'roleName': roleName,
      'permisionId': id,
    };

    return this.http.put<any[]>(this.apiHost, JSON.stringify(body), {
      headers: this.headers,
    });
  }
}
