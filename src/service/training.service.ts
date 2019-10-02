import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { GruppoDTO } from 'src/dto/gruppodto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';
import { TrainingDTO } from 'src/dto/trainingdto';

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

 export class TrainingService extends AbstractService<TrainingDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type = 'training';
 }
 getAllUser(gruppo: GruppoDTO): Observable<TrainingDTO[]>{
   
    return this.http.post<TrainingDTO[]>('http://localhost:' + this.port + '/' + this.type + '/getAllGruppo', gruppo);
 }
}