import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { fabfit } from '../fabfit';
import { FabfitServiceService } from '../fabfitService.service';

@Component({
  selector: 'app-getraindetail',
  templateUrl: './getraindetail.component.html',
  styleUrls: ['./getraindetail.component.css']
})
export class GetraindetailComponent implements OnInit {

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
    // this.fab.email=this.email1
    this.ts.getTrainer()
    .then(response=>{this.trainerList = response,console.log(response)
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
    deletetrainer(data){
      console.log(data)
      this.successmessage=null
      this.errormessage=null
      this.ts.deletetrainer(data)
      .then(response=>{this.successmessage=response.message,this.ngOnInit()})
      .catch(response=>this.errormessage=response.message)
      }

}
