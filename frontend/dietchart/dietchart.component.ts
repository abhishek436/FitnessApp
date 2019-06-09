import { Component, OnInit } from '@angular/core';
import { BmiComponent } from '../bmi/bmi.component';
import { Diet } from '../bmi/Diet';

@Component({
  selector: 'app-dietchart',
  templateUrl: './dietchart.component.html',
  styleUrls: ['./dietchart.component.css']
})
export class DietchartComponent implements OnInit {
  bmi:BmiComponent;
  diet1:Diet[];
  constructor() { }

  ngOnInit() {
  }

}
