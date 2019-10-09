import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { GruppoDTO } from 'src/dto/gruppodto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';
import { TrainingDTO } from 'src/dto/trainingdto';
import { UserDTO } from 'src/dto/userdto';

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
        this.type = 'trainings';
        this.name = 'micro2';
 }
 auth() {
    const user = JSON.parse(localStorage.getItem('currentUser')) as UserDTO;
    if (user) {
      return 'Bearer ' + user.authorities;
    } else {
      return '';
    }
  }

  userLogged(username: string) {
    // console.log('qua: ', this.auth());
     console.log(this.auth());
     return this.http.get('http://localhost:8080/api/users/' + username, {
       headers: {
         Authorization: this.auth()
       }
     });
    }
 getAllUser(gruppo: GruppoDTO): Observable<TrainingDTO[]>{
   
    return this.http.post<TrainingDTO[]>('http://localhost:' + this.port + '/' + this.type + '/getAllGruppo', gruppo);
 }
}