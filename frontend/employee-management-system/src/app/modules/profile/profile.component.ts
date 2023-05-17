import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from 'src/app/services/auth/auth.service';
import { SoftwareEngineerService } from 'src/app/services/software-engineer/software-engineer.service';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  public user: any;
  public changedUser: any;
  public password: any;
  public name: any;
  public surname: any;
  public street: any;
  public state: any;
  public city: any;

  constructor(
    private toastr: ToastrService,
    private softwareEngineerService: SoftwareEngineerService,
    private authService: AuthService,
    private jwtHelper: JwtHelperService,
  ) {}

  ngOnInit(): void {
    var token = this.authService.getToken()
    if (token !== null) {
      var userID = this.jwtHelper.decodeToken(token).id;
      this.softwareEngineerService.getByID(userID).subscribe((res) =>
        {
          this.user = res;
          this.name = this.user.name;
          this.surname = this.user.surname;
          this.street = this.user.address.street;
          this.state = this.user.address.state;
          this.city = this.user.address.city;
                
        }
        
      )
    }
  }

  register() {
    if (this.validateForm()) {
      this.user.password = this.password;
      this.softwareEngineerService.update(this.user).subscribe(
        (res) => {
          this.toastr.success('Changed!', 'Success');
        },
        (error) => {
          if (error.status === 401) {
            this.toastr.error('Wrong password!')    
          } else {
            this.toastr.error('Wrong data');
          }
        }
      );
    }
  }

  validateForm(): boolean {     

      if (
      !this.user.name ||
      !this.user.surname ||
      !this.password
     ) {
      this.toastr.error('Please fill in all fields!');
      return false;
    }

    if(this.user.name === this.name && this.user.surname === this.surname && this.user.address.state === this.state && this.user.address.city === this.city && this.user.address.street === this.street) {
      this.toastr.error('You did not make change!');
      return false;
    }
    return true;
  }

}
