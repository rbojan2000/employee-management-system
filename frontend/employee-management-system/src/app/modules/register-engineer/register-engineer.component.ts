import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin/admin.service';

@Component({
  selector: 'app-register-engineer',
  templateUrl: './register-engineer.component.html',
  styleUrls: ['./register-engineer.component.css']
})
export class RegisterEngineerComponent implements OnInit {
 
  
  constructor(private service: AdminService) { }
 
  ngOnInit(): void {
    this.service.get().subscribe()
  }

}
