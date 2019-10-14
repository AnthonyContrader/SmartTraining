import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { TrainingDTO } from 'src/dto/trainingdto';


/**
 * @author Spleynac
 * 
 * @see AbstractService
 */

 @Injectable({
     providedIn: 'root'
 })

 export class TrainingService extends AbstractService<TrainingDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type = 'trainings';
        this.name = 'Micro2';
 }
}