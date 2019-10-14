import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { ContentDTO } from 'src/dto/contentdto';


/**
 * @author Spleynac
 * 
 * @see AbstractService
 */

 @Injectable({
     providedIn: 'root'
 })

 export class ContentService extends AbstractService<ContentDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type = 'contents';
        this.name = 'Micro2';
 }
}
