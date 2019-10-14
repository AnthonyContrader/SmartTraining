import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { StudentDTO } from 'src/dto/studentdto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';
import { GruppoDTO } from 'src/dto/gruppodto';
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

 export class GruppoService extends AbstractService<GruppoDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type = 'gruppos';
        this.name = 'micro1';
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
 getAllUser(student: StudentDTO): Observable<GruppoDTO[]>{
   
    return this.http.post<GruppoDTO[]>('http://localhost:' + this.port + '/' + this.type + '/getAllStudent', student);
 }
}
