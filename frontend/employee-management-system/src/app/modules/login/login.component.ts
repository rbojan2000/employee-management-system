import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { User } from 'src/app/model/user';
import { AuthService } from 'src/app/services/auth/auth.service';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  user: User = {
    id: null,
    name: '',
    surname: '',
    re_password: '',
    email: '',
    password: '',
    address: null,
  };

  constructor(
    private userService: UserService,
    private toastr: ToastrService,
    private router: Router,
    private authService: AuthService
  ) {}

  login() {
    if (!this.isValidInputs()) {
      return;
    }
    this.userService.loginUser(this.user).subscribe(
      (res) => {
        this.authService.setToken(res.accessToken, res.refreshToken);
        this.toastr.success('Logged in!', 'Success');

        if (this.authService.getUserRole() === 'ROLE_SOFTWARE_ENGINEER') {
          this.router.navigate(['/profile']);
        }

        if (this.authService.getUserRole() === 'ROLE_ADMIN') {
          this.router.navigate(['/permissions']);
        }
      },
      (error) => {
        if (error.status === 401) {
          this.toastr.error('Invalid credentials');
        } else {
          this.toastr.error('An error occurred');
        }
      }
    );
  }

  isValidInputs(): boolean {
    if (!this.user.password || !this.user.email) {
      this.toastr.error('Please fill in all fields');
      return false;
    }
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    if (!emailPattern.test(this.user.email)) {
      this.toastr.error('Please enter a valid email address');
      return false;
    }
    return true;
  }
}
