import { Component, OnInit } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { ToastrService } from 'ngx-toastr';
import { ProjectService } from 'src/app/project.service';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css'],
})
export class ProjectsComponent implements OnInit {
  constructor(
    private projectService: ProjectService,
    private authService: AuthService,
    private jwtHelper: JwtHelperService,
    private toastr: ToastrService
  ) {}

  public projects: any[] = [];

  ngOnInit(): void {
    var token = this.authService.getToken();
    if (token !== null) {
      var userID = this.jwtHelper.decodeToken(token).id;
      this.projectService.getProjectsForUser(userID).subscribe(
        (res) => {
          this.projects = res;
        },
        (error) => {
          this.toastr.error(error.error);
        }
      );
    }
  }

  onDescriptionChange(project: any) {
    project.isDirty = true;
  }

  saveChanges(project: any) {
    if (project.description === '') {
      this.toastr.error('Description can not be blank!');
      return;
    }

    project.isDirty = false;

    this.projectService.update(project).subscribe(
      (res) => {
        this.toastr.success('Changed description', 'Success');
      },
      (error) => {
        this.toastr.error(error.error);
      }
    );
  }
}
