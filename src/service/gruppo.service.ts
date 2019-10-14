import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { GruppoDTO } from 'src/dto/gruppodto';


/**
 * @author Spleynac
 * 
 * @see AbstractService
 */

 @Injectable({
     providedIn: 'root'
 })

 export class GruppoService extends AbstractService<GruppoDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type = 'groups';
        this.name = 'Micro1';
 }
}