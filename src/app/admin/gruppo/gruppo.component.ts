import { Component, OnInit } from '@angular/core';
import { StudentService } from 'src/service/student.service';
import { GruppoService } from 'src/service/gruppo.service';
import { StudentDTO } from 'src/dto/studentdto';
import { GruppoDTO } from 'src/dto/gruppodto';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';

@Component({
  selector: 'app-gruppo',
  templateUrl: './gruppo.component.html',
  styleUrls: ['./gruppo.component.css']
})
export class GruppoComponent implements OnInit {
 
  gruppi: GruppoDTO[];
  gruppotoinsert: GruppoDTO = new GruppoDTO();
  students: StudentDTO[];

  constructor(private service: GruppoService, private sService: StudentService) { }

  ngOnInit() {
    this.getGruppo();
    this.getStudent();
  }

  getGruppo(){
    this.service.getAll().subscribe(gruppi=>this.gruppi=gruppi);
  }

  getStudent(){
    this.sService.getAll().subscribe(students=> this.students=students);
  }

  delete(gruppo:GruppoDTO){
    this.service.delete(gruppo.id).subscribe(()=> this.getGruppo());
  }

  update(gruppo:GruppoDTO){
    this.service.update(gruppo).subscribe(()=> this.getGruppo());
  }

  insert(gruppo:GruppoDTO){
    this.service.insert(gruppo).subscribe(()=> this.getGruppo());
  }

  clear(){
    this.gruppotoinsert = new GruppoDTO();
  }

}
