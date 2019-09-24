import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/service/user.service';
import { StudentService } from 'src/service/student.service';
import { UserDTO } from 'src/dto/userdto';
import { StudentDTO } from 'src/dto/studentdto';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  students: StudentDTO[];
  studentinsert: StudentDTO = new StudentDTO();
  users: UserDTO[];

  constructor(private service: StudentService, private uService: UserService) {}

  ngOnInit() {
    this.getUser();
    this.getStudent();
  }

  getStudent(){
    this.service.getAll().subscribe(students=>this.students=students);
  }

  getUser(){
    this.uService.getAll().subscribe(users=>users=users);
  }

  delete(student: StudentDTO){
    this.service.delete(student.id).subscribe(() => this.getStudent());
  }

  update(student: StudentDTO){
    this.service.update(student).subscribe(() => this.getStudent());
  }

  insert(student: StudentDTO){
    this.service.insert(student).subscribe(() => this.getStudent());
  }

  clear(){
    this.studentinsert = new StudentDTO();
  }

}
