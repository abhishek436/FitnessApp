import { Component, OnInit } from '@angular/core';
import { FabfitServiceService } from '../fabfitService.service';
import { Trainer } from './Trainer';
import { fabfit } from '../fabfit';
import { FormGroup } from '@angular/forms/src/model';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-trainer',
  templateUrl: './trainer.component.html',
  styleUrls: ['./trainer.component.css']
})
export class TrainerComponent implements OnInit {
emailid:string;
suggestForm:FormGroup
suggest1:string
success:string
error:string
t1:Trainer;
users1:fabfit[];
  constructor(private fb:FormBuilder,private ts:FabfitServiceService) { }

  ngOnInit() {
    this.emailid=localStorage.getItem('trainerid');
    this.ts.getinfo(this.emailid).
    then(response=>{this.t1=response,console.log(response),this.users1=response.fabfitusers1})
    this.suggestForm=this.fb.group({
      suggestions:[''],
      email:['']
    })
  }
  suggest(data) {
    this.success=null;
    this.error=null;
    this.suggestForm.controls.email.setValue(data)
    console.log(data)
    console.log(this.suggestForm.controls.email.value)
    this.ts.setsuggestion(this.suggestForm.value)
    .then(response=>{this.suggest1=response,this.success=response.message,
    console.log(response)}
    ).catch(res=>this.error=res.message)
  }

}
