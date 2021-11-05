import { Component, OnInit, Input } from '@angular/core';
import { Vivienda } from '../interfaces/vivienda-list.interface';
@Component({
  selector: 'app-vivienda-item',
  templateUrl: './vivienda-item.component.html',
  styleUrls: ['./vivienda-item.component.css']
})
export class ViviendaItemComponent implements OnInit {

  @Input() viviendaInput: Vivienda | undefined;
  i: number = 0;

  constructor() { }

  ngOnInit(): void {
  }

}
