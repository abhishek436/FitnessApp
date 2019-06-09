import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { FabfitServiceService } from '../fabfitService.service';
import { BaseResponseOptions } from '@angular/http/src/base_response_options';
import { Fitness } from './Fitness';
import { Diet } from './Diet';
import { fabfit } from '../fabfit';

@Component({
  selector: 'app-bmi',
  templateUrl: './bmi.component.html',
  styleUrls: ['./bmi.component.css']
})
export class BmiComponent implements OnInit {
 
  dietForm:FormGroup;
  dietdetails: Diet[];
  fitnessdetails: Fitness[];
  message:string;
  flag:boolean=false;
  flag1:boolean=false;
  flag2:boolean=false;
  flag3:Boolean = false; 
  email:string;
  suggestions1:string;
  suggestresponse:fabfit;
   constructor(private fb:FormBuilder,private serve:FabfitServiceService) { }

  ngOnInit() {this.flag2=false,
    this.flag=false,
    this.dietForm=this.fb.group({gender:[''],goals:[''],level1:['']})
    this.email=localStorage.getItem('data');
    this.suggestions1=" ";
    this.flag3=false;
  }
getDiet(){this.flag=true;
  this.flag1=false;
  this.suggestions1=" ";
  this.flag3=false;
    this.serve.getdiet(this.dietForm.value).
    then(response=>{this.dietdetails=response,
      this.flag2=!this.flag2;
    
    console.log(response)}
    ).catch(res=>this.message=res.message)
    this.serve.getsuggestions(this.email).then(response=>{this.suggestresponse=response,console.log(response),this.suggestions1=response.suggestions})
  
  }
  getdiet(){
    return this.dietdetails;
  }


  getfit(){
    this.flag=true;
    this.flag2=false;
    this.flag1=true;
   
    this.serve.getFit(this.dietForm.value).then(response=>{this.fitnessdetails=response})
    .catch(res=>this.message=res.message)
  }
  getfit1(){
    this.flag3=true;
    this.flag2=false;
    this.flag1=false;
    this.suggestions1=" ";
    this.flag=true;
    this.serve.getsuggestions(this.email).then(response=>{this.suggestresponse=response,console.log(response),this.suggestions1=response.suggestions})
    this.serve.getFit(this.dietForm.value).then(response=>{this.fitnessdetails=response})
    .catch(res=>this.message=res.message)
  }
  getFit(){
    return this.fitnessdetails;
  }
  }

