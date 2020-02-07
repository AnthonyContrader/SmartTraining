import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { LibriDTO } from 'src/dto/libridto';
import { HttpClient } from '@angular/common/http';
import { Categoria } from 'src/dto/categoria';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LibriService extends AbstractService<LibriDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = "libri"
  }


  findByCategoria(categoria: Categoria): Observable<LibriDTO[]> {
    let cat = Categoria[categoria.valueOf()];
    console.log(cat);
    return this.http.get<any[]>('http://localhost:8080/' + this.type + '/findByCategoria?categoria=' + cat.toString());
  }
}
