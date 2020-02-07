import { Component, OnInit } from '@angular/core';
import { SiaService } from 'src/service/sia.service';
import { NgForm } from '@angular/forms';
import { SiaQuestionDto } from 'src/dto/siaquestiondto';
import { SiaAnswerDTO } from 'src/dto/siaanswerdto';
import { Router } from '@angular/router';
import { routerNgProbeToken } from '@angular/router/src/router_module';

@Component({
  selector: 'app-sia-home',
  templateUrl: './sia-home.component.html',
  styleUrls: ['./sia-home.component.css']
})
export class SiaHomeComponent implements OnInit {
  answer: SiaAnswerDTO;
  question: SiaQuestionDto;
  constructor(private service: SiaService, private router: Router) { }

  

  ngOnInit() {
    this.question = new SiaQuestionDto();
    this.answer = new SiaAnswerDTO();
  }

  search(){
    this.service.search(this.question).subscribe(risposta => {
      this.answer = risposta;
      localStorage.setItem('answer', JSON.stringify(this.answer));
      this.router.navigateByUrl('sia/sia-search');
      localStorage.setItem('question', this.question.siaword);
    });
  }

}
