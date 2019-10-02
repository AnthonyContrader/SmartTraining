import {GruppoDTO} from './gruppodto';
import { LoginComponent } from 'src/app/login/login.component';

export class TrainingDTO{
    id:number;

    nameTraining:string;
    gruppoId:number;

    gruppo: GruppoDTO;

    
}