import { ViviendaService } from './../services/vivienda.service';
import { Component, OnInit } from '@angular/core';
import { Vivienda } from '../interfaces/vivienda-list.interface';
@Component({
  selector: 'app-vivienda-list',
  templateUrl: './vivienda-list.component.html',
  styleUrls: ['./vivienda-list.component.css']
})
export class ViviendaListComponent implements OnInit {

  viviendaList : Vivienda[] | undefined;
  viviendaNumberSelected = '50';

  constructor(private viviendaService: ViviendaService) {}

  ngOnInit(): void {
    this.getViviendaList();
  }


  getViviendaList() {
    this.viviendaService.getViviendaList().subscribe( resultado => {
      this.viviendaList = resultado;
      console.log(resultado);
    });
  }

}
