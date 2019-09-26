import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { TrainingDTO } from 'src/dto/trainingdto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';
import { ContentDTO } from 'src/dto/contentdto';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */

 @Injectable({
     providedIn: 'root'
 })

 export class ContentService extends AbstractService<ContentDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type = 'content';
 }
 getAllUser(training: TrainingDTO): Observable<ContentDTO[]>{
   
    return this.http.post<ContentDTO[]>('http://localhost:' + this.port + '/' + this.type + '/getAllTraining', training);
 }
}
