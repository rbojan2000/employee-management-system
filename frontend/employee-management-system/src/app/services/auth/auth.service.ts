import { EventEmitter, Injectable } from '@angular/core';
import jwtDecode from 'jwt-decode';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor() {}

  private readonly tokenAccessKey = 'jwt-access-token';
  private readonly tokenRefreshKey = 'jwt-refresh-token';

  onLogout: EventEmitter<void> = new EventEmitter<void>();
  onLogin: EventEmitter<void> = new EventEmitter<void>();

  setToken(accessToken: string, refreshToken: string): void {
    localStorage.setItem(this.tokenAccessKey, accessToken);
    localStorage.setItem(this.tokenRefreshKey, refreshToken);
    
    this.onLogin.emit();
  }

  getUserRole() {
    var jwt;
    if (this.getToken()) {
      jwt = jwtDecode(this.getToken()!) as any;
    } else {
      return '';
    }
    return jwt.role;
  }

  getToken(): string | null {
    return localStorage.getItem(this.tokenAccessKey);
  }

  removeToken(): void {
    localStorage.removeItem(this.tokenAccessKey);
    localStorage.removeItem(this.tokenRefreshKey)
    this.onLogout.emit();
  }

  isLoggedIn(): boolean {
    const token = this.getToken();
    return !!token;
  }
}
