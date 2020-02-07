import { Component, OnInit } from '@angular/core';
import { SiaAnswerDTO } from 'src/dto/siaanswerdto';
import { Router } from '@angular/router';
import { SiaService } from 'src/service/sia.service';
import { SiaQuestionDto } from 'src/dto/siaquestiondto';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-sia-search',
  templateUrl: './sia-search.component.html',
  styleUrls: ['./sia-search.component.css']
})
export class SiaSearchComponent implements OnInit {
  risposta: SiaAnswerDTO;

  questionDTO: SiaQuestionDto;

  constructor(private service: SiaService, private router: Router) {
    this.risposta = new SiaAnswerDTO();
    this.questionDTO = new SiaQuestionDto();
  }

  ngOnInit() {
    this.risposta = JSON.parse(localStorage.getItem('answer'));
    this.questionDTO.siaword = localStorage.getItem('question');
  }

  search() {
    localStorage.clear();
    this.service.search(this.questionDTO).subscribe(risposta => {
      this.risposta = new SiaAnswerDTO();
      this.risposta = risposta;
    })
  }

}
