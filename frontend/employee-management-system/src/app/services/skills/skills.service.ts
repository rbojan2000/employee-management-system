import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from '../auth/auth.service';

@Injectable({
  providedIn: 'root'
})
export class SkillsService {
  
  apiHost: string = 'https://localhost:8443/skill';
  headers: HttpHeaders = new HttpHeaders({
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + this.auth.getToken()
  });

  constructor(private http: HttpClient, private auth: AuthService) {}

  getSkillsForUser(id: string): Observable<any[]> {
    return this.http.get<any[]>(this.apiHost + "/user/"+ id, {
      headers: this.headers,
    });
  }

  addNewSkill(newSkill: any) {
    window.alert(JSON.stringify(newSkill))
    return this.http.post<any[]>(this.apiHost, JSON.stringify(newSkill) , {
      headers: this.headers,
    });
  }

}
