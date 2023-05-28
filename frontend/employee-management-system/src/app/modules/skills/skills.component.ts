import { Component, OnInit } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from 'src/app/services/auth/auth.service';
import { SkillsService } from 'src/app/services/skills/skills.service';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css'],
})
export class SkillsComponent implements OnInit {
  constructor(
    private skillService: SkillsService,
    private authService: AuthService,
    private jwtHelper: JwtHelperService,
    private toastr: ToastrService
  ) {}

  public skills: any[] = [];
  public userID: any = '';

  ngOnInit(): void {
    var token = this.authService.getToken();
    if (token !== null) {
      this.userID = this.jwtHelper.decodeToken(token).id;
      this.skillService.getSkillsForUser(this.userID).subscribe(
        (res) => {
          this.skills = res;
        },
        (error) => {
          this.toastr.error(error.error);
        }
      );
    }
  }

  newSkill = {
    name: '',
    grade: null,
  };

  addSkill() {
    if (
      this.newSkill.name.trim() !== '' &&
      this.newSkill.grade !== null &&
      this.newSkill.grade >= 1 &&
      this.newSkill.grade <= 5
    ) {
      const existingSkillIndex = this.skills.findIndex(
        (skill) => skill.name.toLowerCase() === this.newSkill.name.toLowerCase()
      );

      if (existingSkillIndex !== -1) {
        if (this.skills[existingSkillIndex].grade !== this.newSkill.grade) {
          this.skills.splice(existingSkillIndex, 1);
        } else {
          this.toastr.error(
            'Skill with same name and grade already exists, no need to add again!'
          );

          return;
        }
      }

      const newId = this.skills.length + 1;
      const newSkill: any = {
        id: newId,
        name: this.newSkill.name.trim(),
        grade: this.newSkill.grade,
        userId: this.userID,
      };
      this.skillService.addNewSkill(newSkill).subscribe(
        (res) => {
          this.skills.push(newSkill);
        },
        (error) => {
          this.toastr.error(error.error);
        }
      );

      this.newSkill = {
        name: '',
        grade: null,
      };
    } else {
      this.toastr.error('Wrong data!');
    }
  }
}
