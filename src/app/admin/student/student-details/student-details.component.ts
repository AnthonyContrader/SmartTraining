import { Component, OnInit, Input } from '@angular/core';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { StudentService } from 'src/service/student.service';
import { StudentDTO } from 'src/dto/studentdto';

/**
 * Questa component si occupa di mostrare i dettagli di un utente (in questo caso aggiunge solo l'ID
 * alle informazioni già mostrate nella tabella generale). L'annotation "@Input()" prende il valore di dto
 * dalla UsersComponent ( usando il binding [dto]) e nel template ne mostra i dettagli. Questa component 
 * non viene chiamata mediante routing ma viene mostrata solo quando dto non è nullo (usando la direttiva
 * *ngIf ).
 * 
 * @author Vittorio Valent
 * 
 * @see StudentComponent
 */
@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['../student.component.css']
})
export class StudentDetailsComponent extends AbstractCrudComponent<StudentDTO> implements OnInit {

  /**
   * Qui prende in input il valore di dto
   */
  @Input() dto: StudentDTO;

  constructor(service: StudentService) {
    super(service);
  }

  ngOnInit() {
  }

}
