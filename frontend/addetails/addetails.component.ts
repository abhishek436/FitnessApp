import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FabfitServiceService } from '../fabfitService.service';
import { FormGroup } from '@angular/forms/src/model';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';


@Component({
  selector: 'app-addetails',
  templateUrl: './addetails.component.html',
  styleUrls: ['./addetails.component.css']
})
export class AddetailsComponent implements OnInit {
addform : FormGroup
data1 : any
message : String;
sum : Number
status:Boolean = false;
status1:Boolean = false;
status2:Boolean = false;
username : String;
  constructor(private router:Router,private as:FabfitServiceService,private fb:FormBuilder) { 
    if(localStorage.getItem('data') != null) {
      this.username = localStorage.getItem('data');
    }
  }
  
  
  adetails() {
    this.as.addetails(this.addform.value)
    .then(response=>{this.data1 = response
    localStorage.setItem("bmi",response.sum)
    localStorage.setItem("info",response.message)
    this.router.navigateByUrl('/bmi')})
  }

  ngOnInit() {
    this.addform = this.fb.group({
      height : ['',[Validators.required,Validators.min(130),Validators.max(250)]],
      weight : ['',[Validators.required,Validators.min(10),Validators.max(200)]],
      dob : ['',[Validators.required]]
    })
  }

  change() {
    this.status = !this.status;
  }
first()
{
this.status1=!this.status1;
}
calculate(weight:number,height:number) {
  
  this.sum = +weight / ((+height/100) * (+height/100));
  if(this.sum < 18.5) {
    alert("Your BMI index is : "+this.sum.toFixed()+"                                                                             BMI Status: Underweight. Please Select accordingly ")
  }
  else if(this.sum >= 18.5 && this.sum <= 24.9) {
    alert("Your BMI index is : " + this.sum.toFixed() + "                                                                            BMI Status: Fit & Healthy. Please Select accordingly ")
  }
  else if(this.sum >=25.0 && this.sum <=29.9) {
    alert("Your BMI index is : " + this.sum.toFixed() + "                                                                           BMI Status: Overweight. Please Select accordingly ")
  } 
  else if(this.sum>=30){
    alert("Your BMI index is : " + this.sum.toFixed() + "                                                                           BMI Status: Obese.  Please Select accordingly ")
  }
}
  }

