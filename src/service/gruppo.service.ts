import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { StudentDTO } from 'src/dto/studentdto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';
import { GruppoDTO } from 'src/dto/gruppodto';

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

 export class GruppoService extends AbstractService<GruppoDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type = 'gruppo';
 }
 getAllUser(student: StudentDTO): Observable<GruppoDTO[]>{
   
    return this.http.post<GruppoDTO[]>('http://localhost:' + this.port + '/' + this.type + '/getAllStudent', student);
 }
}
