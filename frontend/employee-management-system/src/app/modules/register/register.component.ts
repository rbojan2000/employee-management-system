import { Component } from '@angular/core';
import { UserService } from 'src/app/services/user/user.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { Address } from 'src/app/model/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  user: User = {
    id: null,
    name: '',
    surname: '',
    email: '',
    password: '',
    address: null,
  };

  public street: any = '';
  public city: any = '';
  public state: any = '';
  public rePassword: any = '';
  public passwordStrength: number = 0;

  constructor(
    private userService: UserService,
    private toastr: ToastrService,
    private router: Router
  ) {}

  register() {
    if (this.validateForm()) {
      var address = { 
        city: this.city,
        state: this.state,
        street: this.street,
      }
      this.user.address = address; 
      this.userService.register(this.user)      
    }
  }

  validateForm(): boolean {
      if (
      !this.user.name ||
      !this.user.surname ||
      !this.street ||
      !this.city ||
      !this.state ||
      !this.user.email ||
      !this.user.password ||
      !this.rePassword
    ) {
      this.toastr.error('Please fill in all fields');
      return false;
    }

    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!emailPattern.test(this.user.email)) {
      this.toastr.error('Please enter a valid email address');
      return false;
    }

    const passwordPattern = /^(?=.*[A-Z])(?=.*[@$!%*?&])(?=.*[a-z]).{8,}$/;
    if (!passwordPattern.test(this.user.password)) {
      this.toastr.error(
        'Password must contain at least one uppercase letter, one special character, and be at least 8 characters long'
      );
      return false;
    }

    if (this.user.password !== this.rePassword) {
      this.toastr.error('Passwords do not match');
      return false;
    }


    return true;
  }

  calculatePasswordStrength(password: string): number {
    let strength = 0;

    if (/[A-Z]/.test(password)) {
      strength += 25;
    }
    if (/[!@#$%^&*(),.?":{}|<>]/.test(password)) {
      strength += 25;
    }
    if (/[a-z]/.test(password)) {
      strength += 25;
    }
    if (password.length >= 8) {
      strength += 25;
    }

    return strength;
  }

  checkPasswordStrength() {
    const password = this.user.password;
    const passwordStrength = this.calculatePasswordStrength(password);
    this.passwordStrength = passwordStrength;
  }
}
