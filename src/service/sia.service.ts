import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { SiaQuestionDto } from 'src/dto/siaquestiondto';
import { SiaAnswerDTO } from 'src/dto/siaanswerdto';
import { map, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SiaService {

  constructor(protected http: HttpClient) { }

  search(siaword: SiaQuestionDto): Observable<SiaAnswerDTO>{
    return this.http.post<SiaAnswerDTO>('http://localhost:5000/sia', siaword);
  }
}
