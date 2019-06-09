import { Component, OnInit } from '@angular/core';
import { FabfitServiceService } from '../fabfitService.service';
import { FormBuilder,FormGroup, Validators } from '@angular/forms';
import {AddetailsComponent} from '../addetails/addetails.component' ;
import { fabfit } from '../fabfit';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  updateform:FormGroup;
  addetailsForm:FormGroup;
  verifyform:FormGroup;
  successmessage:String
  errormessage :String
  static userDetails: fabfit=new fabfit();
  

  constructor(private fb:FormBuilder,private as:FabfitServiceService) { }

  updatedetails(){
    this.successmessage = null;
    this.errormessage = null;
    
    this.as.updatedetails(this.updateform.value)
    .then(response =>{
      this.successmessage = response.message; 
      HomeComponent.userDetails=response;
    
      })
    .catch(response =>this.errormessage = response.message)
    
  }
  ngOnInit() {
   
    this.updateform=this.fb.group({
      name:['',[Validators.required,Validators.pattern("[A-Za-z ]+")]],
      email:['',[Validators.required,Validators.pattern("[a-z0-9]+@(gmail||hotmail||yahoo).(com||in||co.in)")]],
      password:['',[Validators.required,Validators.pattern("(?=.*\\d)(?=.*[!@$%^&()#*+])(?=.*[a-z])(?=.*[A-Z]).{8,}")]],
    });

  }
  
  
}
