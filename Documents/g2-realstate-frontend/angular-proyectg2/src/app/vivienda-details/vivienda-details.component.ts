import { Component, Input, OnInit } from '@angular/core';
import { ViviendaResponse } from '../interfaces/vivienda.interface';
import { ViviendaService } from '../services/vivienda.service';

@Component({
  selector: 'app-vivienda-details',
  templateUrl: './vivienda-details.component.html',
  styleUrls: ['./vivienda-details.component.css']
})
export class ViviendaDetailsComponent implements OnInit {

  @Input()  viviendaResponse!: ViviendaResponse

  constructor(private viviendaService: ViviendaService) { }

  ngOnInit(): void {

    console.log(this.viviendaResponse?.id)
      this.viviendaService.getVivienda(this.viviendaResponse?.id).subscribe(viviendaResult=> {
        this.viviendaResponse = viviendaResult
      })

  }

}
