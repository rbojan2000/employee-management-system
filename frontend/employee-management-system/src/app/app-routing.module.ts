import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './modules/register/register.component';
import { LoginComponent } from './modules/login/login.component';
import { ProfileComponent } from './modules/profile/profile.component';
import { ProjectsComponent } from './modules/projects/projects.component';
import { SkillsComponent } from './modules/skills/skills.component';
import { AuthGuard } from './guard/auth.guard';
import { PageNotFoundComponent } from './modules/page-not-found/page-not-found.component';
import { HelloPageComponent } from './modules/hello-page/hello-page.component';

const routes: Routes = [
  { path: '', component: HelloPageComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'profile', component: ProfileComponent, canActivate:[AuthGuard] },
  { path: 'projects', component: ProjectsComponent, canActivate:[AuthGuard] },
  { path: 'skills', component: SkillsComponent, canActivate:[AuthGuard] },
  { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
