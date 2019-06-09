import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FabfitServiceService } from '../fabfitService.service';
import { fabfit } from '../fabfit';
import { FormGroup,FormBuilder } from '@angular/forms';


@Component({
  selector: 'app-trainerdetail',
  templateUrl: './trainerdetail.component.html',
  styleUrls: ['./trainerdetail.component.css']
})
export class TrainerdetailComponent implements OnInit {

  constructor(private ts : FabfitServiceService,private fb:FormBuilder) { }
  trainerform : FormGroup
  trainerList : any[];
  successmessage:string;
  fab:fabfit;
  email1:string;
  temail1:string;
  errormessage:string
  ngOnInit() {
    this.trainerform = this.fb.group({
    })
    this.email1=localStorage.getItem('data')
    console.log(this.email1);
    // this.fab.email=this.email1
    this.ts.getTrainer()
    .then(response=>{this.trainerList = response
     })
     .catch(error => this.trainerList = null)
  }
booktrainer(data){
this.successmessage=null
this.errormessage=null
this.ts.booktrainer(data,this.email1)
.then(response=>this.successmessage=response.message)
.catch(response=>this.errormessage=response.message)
}
removetrainer(data){
  this.successmessage=null;
  this.errormessage=null;
  this.ts.removetrainer(data).then(response=>this.successmessage=response.message)
}
}
