import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { UserDTO } from 'src/dto/userdto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';
import { StudentDTO } from 'src/dto/studentdto';

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

 export class StudentService extends AbstractService<StudentDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type = 'student';
        
    }
    getAllUser(user: UserDTO): Observable<StudentDTO[]>{
        return this.http.post<StudentDTO[]>('http://localhost:' + this.port + '/' + this.type + '/getAllUser', user);
    }
 }