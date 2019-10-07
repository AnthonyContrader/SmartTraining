import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { UserDTO } from 'src/dto/userdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StudentDTO } from 'src/dto/studentdto';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author
 * 
 * @see AbstractService
 */

 @Injectable({
     providedIn: 'root'
 })

 export class StudentService extends AbstractService<StudentDTO>{

    constructor(http: HttpClient){
        super(http);
        this.name = 'Micro1';
        this.type = 'students';
 }
 auth() {
    const user = JSON.parse(localStorage.getItem('currentUser')) as UserDTO;

    console.log(user.authorities + 'user');
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
 getAllUser(user: UserDTO): Observable<StudentDTO[]>{
   
    return this.http.post<StudentDTO[]>('http://localhost:' + this.port + '/' + this.type + '/getAllUser', user);
 }
}
