import { Component, OnInit } from '@angular/core';
import { LibriDTO } from 'src/dto/libridto';
import { AbstractCrudComponent } from 'src/utils/abstractcomponent';
import { LibriService } from 'src/service/libri.service';
import Swiper from 'node_modules/swiper/js/swiper.js';
import { UserDTO } from 'src/dto/userdto';
/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */

function hello() {
  
  
  var swiper = new Swiper('.swiper-container', {
    effect: 'coverflow',
    grabCursor: true,
    centeredSlides: true,
    slidesPerView: 'auto',
    coverflowEffect: {
      rotate: 50,
      stretch: 0,
      depth: 100,
      modifier: 1,
      slideShadows : true,
    },
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
    pagination: {
      el: '.swiper-pagination',
    },
  });
}

@Component({
  selector: 'app-scroll',
  templateUrl: './scroll.component.html',
  styleUrls: ['./scroll.component.css']
})
export class ScrollComponent extends AbstractCrudComponent<LibriDTO> implements OnInit {

  user: UserDTO;
  angular:boolean=false;
  spring:boolean=false;
  html:boolean=false;
  java:boolean=false;
  js:boolean=false;
  jsp:boolean=false;
  python:boolean=false;
  mvc:boolean=false;
  eclipse:boolean=false;
  mysql:boolean=false;


  constructor(service: LibriService, private libriService: LibriService) {
    super(service);
  }

  ngOnInit() {
    hello();
    this.getAll();
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    hello();
  }

  findByCategoria(cat: number){
    console.log("prima: " + this.dtolist.length);
    this.dtolist = [];
    console.log("dopo: " + this.dtolist.length);
    this.libriService.findByCategoria(cat).subscribe(nuova => this.dtolist = nuova);
    console.log("lista: " + this.dtolist);
    hello();
    hello();
  }

  inversione(inv:string){
    switch (inv){
      case "eclipse":
        this.eclipse = !this.eclipse;
        if(this.eclipse){
          this.findByCategoria(8);
        }
        else{
          this.getAll();
          this.getAll();
        }
        break;

        case "angular":
        this.angular = !this.angular;
        if(this.angular) this.findByCategoria(0);
        else this.getAll();
        break;

        case "spring":
        this.spring = !this.spring;
        if(this.spring) this.findByCategoria(1);
        else this.getAll();
        break;

        case "html":
        this.html = !this.html;
        if(this.html) this.findByCategoria(2);
        else this.getAll();
        break;

        case "java":
        this.java = !this.java;
        if(this.java) this.findByCategoria(3);
        else this.getAll();
        break;

        case "js":
        this.js = !this.js;
        if(this.js) this.findByCategoria(4);
        else this.getAll();
        break;
        
        case "jsp":
        this.jsp = !this.jsp;
        if(this.jsp) this.findByCategoria(5);
        else this.getAll();
        break;

        case "python":
        this.python = !this.python;
        if(this.python) this.findByCategoria(6);
        else this.getAll();
        break;
        
        case "mvc":
        this.mvc = !this.mvc;
        if(this.mvc) this.findByCategoria(7);
        else this.getAll();
        break;
        
        case "mysql":
        this.mysql = !this.mysql;
        if(this.mysql) this.findByCategoria(9);
        else this.getAll();
        break;


    }
  }

}
