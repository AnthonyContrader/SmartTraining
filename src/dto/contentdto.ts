import {TrainingDTO} from './trainingdto';
import { LoginComponent } from 'src/app/login/login.component';

export class ContentDTO{
    id:number;

    tag:string;
    text:string;
    title:string;
    idTraining:number;

    training: TrainingDTO;

    
}