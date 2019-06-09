import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms/';
import { FormBuilder } from '@angular/forms/';
import { FabfitServiceService } from '../fabfitService.service';
import { Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { fabfit } from '../fabfit';
import { HomeComponent } from '../home/home.component';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  verifyform:FormGroup
  successmessage:String
  errormessage :String
  data : fabfit=new fabfit();
  
  //valid:Boolean = true
  constructor(private fb:FormBuilder,private as:FabfitServiceService,private router:Router, private hc: HomeComponent) { }

  ngOnInit() {
    this.verifyform = this.fb.group({
      email : ['',Validators.required],
      password : ['',Validators.required]
    })

  }
  
  

  verifydetails() {
    this.successmessage = null;
    this.errormessage = null;
    console.log(this.verifyform.value)
    this.as.verifydetails(this.verifyform.value)
    .then(response =>{this.data = response,this.successmessage = response.message;
      console.log(response)
      localStorage.setItem("data", response.email);
      localStorage.setItem('userDetail', response.name);
      localStorage.setItem('password', response.password);
      localStorage.setItem('height',response.height);
      localStorage.setItem('weight',response.weight);
      localStorage.setItem('suggestions',response.suggestions)
      this.router.navigate(['/addetails'])
      this.as.navShow=false})
    .catch(response =>this.errormessage = response.message)
  }
  //  click() {
  //    if(this.verifydetails()) {
  //     this.valid = true;
  //   }
  //  }
  
}
