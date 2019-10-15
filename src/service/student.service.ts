import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { StudentDTO } from 'src/dto/studentdto';

/**
 * @author Spleynac
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
}
