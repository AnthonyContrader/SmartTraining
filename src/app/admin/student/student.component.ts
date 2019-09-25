import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/service/user.service';
import { StudentService } from 'src/service/student.service';
import { UserDTO } from 'src/dto/userdto';
import { StudentDTO } from 'src/dto/studentdto';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent extends AbstractCrudComponent<StudentDTO> implements OnInit {
  students: StudentDTO[];
  studenttoinsert: StudentDTO = new StudentDTO();
  users: UserDTO[];

  constructor(service: StudentService, private uService: UserService) {
    super(service);
  }

  ngOnInit() {
    this.clear();
    this.getUser();
    this.getAll();
  }
  getUser(){
    this.uService.getAll().subscribe(users=>users=users);
  }
  /*
  delete(student: StudentDTO){
    this.service.delete(student.id).subscribe(() => this.getStudent());
  }

  update(student: StudentDTO){
    this.service.update(student).subscribe(() => this.getStudent());
  }

  insert(student: StudentDTO){
    this.service.insert(student).subscribe(() => this.getStudent());
  }*/

  clear(){
    this.studenttoinsert = new StudentDTO();
  }

  close(){
    this.selected = null;
  }

}
