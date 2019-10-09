import { Component, OnInit } from '@angular/core';
import { GruppoService } from 'src/service/gruppo.service';
import { TrainingService } from 'src/service/training.service';
import { GruppoDTO } from 'src/dto/gruppodto';
import { TrainingDTO } from 'src/dto/trainingdto';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';

@Component({
  selector: 'app-training',
  templateUrl: './training.component.html',
  styleUrls: ['./training.component.css']
})
export class TrainingComponent implements OnInit {
 
  trainings: TrainingDTO[];
  trainingtoinsert: TrainingDTO = new TrainingDTO();
  gruppi: GruppoDTO[];

  constructor(private service: TrainingService, private gService: GruppoService) { }

  ngOnInit() {
    this.getTraining();
  }

  getTraining(){
    this.service.getAll().subscribe(trainings=>this.trainings=trainings);
  }

  getGruppo(){
    this.gService.getAll().subscribe(gruppi=> this.gruppi=gruppi);
  }

  delete(training:TrainingDTO){
    this.service.delete(training.id).subscribe(()=> this.getTraining());
  }

  update(training:TrainingDTO){
    this.service.update(training).subscribe(()=> this.getTraining());
  }

  insert(training:TrainingDTO){
    this.service.insert(training).subscribe(()=> this.getTraining());
  }

  clear(){
    this.trainingtoinsert = new TrainingDTO();
  }

}