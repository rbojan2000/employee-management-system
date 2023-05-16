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
    address: null
  };

  constructor(
    private userService: UserService,
    private toastr: ToastrService,
    private router: Router,
    private authService: AuthService
  ) {}

  login() {
    this.userService.loginUser(this.user).subscribe((res) => {
        this.authService.setToken(res.accessToken);
        this.toastr.success('Logged in!', 'Success');
        this.router.navigate(['/']);
      },
      (error) => {
        if (error.status === 401) {
          this.toastr.error('Invalid credentials')    
        } else {
          this.toastr.error('An error occurred', 'Error');
        }
      }
      );
  }
}
