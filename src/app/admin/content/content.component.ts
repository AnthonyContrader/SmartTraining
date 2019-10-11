import { Component, OnInit } from '@angular/core';
import { TrainingService } from 'src/service/training.service';
import { ContentService } from 'src/service/content.service';
import { TrainingDTO } from 'src/dto/trainingdto';
import { ContentDTO } from 'src/dto/contentdto';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {
 
  contents: ContentDTO[];
  contenttoinsert: ContentDTO = new ContentDTO();
  trainings: TrainingDTO[];

  constructor(private service: ContentService, private tService: TrainingService) {   }

  ngOnInit() {
    this.getContent();
  }

  getContent(){
    this.service.getAll().subscribe(contents=>this.contents=contents);
  }

  getTraining(){
    this.tService.getAll().subscribe(trainings=> this.trainings=trainings);
  }

  delete(content:ContentDTO){
    this.service.delete(content.id).subscribe(()=> this.getContent());
  }

  update(content:ContentDTO){
    this.service.update(content).subscribe(()=> this.getContent());
  }

  insert(content:ContentDTO){
    this.service.insert(content).subscribe(()=> this.getContent());
  }

  clear(){
    this.contenttoinsert = new ContentDTO();
  }

}
