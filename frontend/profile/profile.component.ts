import { Component, OnInit } from '@angular/core';
import { FabfitServiceService } from '../fabfitService.service';
import { FormGroup } from '@angular/forms/src/model';
import { FormBuilder } from '@angular/forms/';
import { fabfit } from '../fabfit';
import { Validators } from '@angular/forms';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  
  name:string;
  email:string;
  password:string;
  updateForm : FormGroup;
  successmessage:String
  errormessage :String
  weight:Number
  height:Number;

  f2:fabfit;
  email1:String;
  contact : Number;
  constructor(private ts:FabfitServiceService,private fb:FormBuilder) { }

  ngOnInit() {
    this.updateForm = this.fb.group({
      email : [''],
      name : ['',[Validators.required]],
      password : ['',[Validators.required,Validators.pattern("(?=.*\\d)(?=.*[!@$%^&()#*+])(?=.*[a-z])(?=.*[A-Z]).{8,}")]],
      weight:['',[Validators.required,Validators.min(10),Validators.max(200)]],
      height:['',[Validators.required,Validators.min(130),Validators.max(250)]],
      contact:['',[Validators.required,Validators.pattern("[6-9][0-9]{9}")]],
      temail :['']
    })
     this.email=localStorage.getItem('data');
     this.updateForm.controls.email.setValue(this.email);
     this.email1=this.email.replace("@gmail.com","")
    // console.log(this.email)
    // this.name=localStorage.getItem('userDetail');
    // console.log(this.name)
    // this.password=localStorage.getItem('password');
    // this.weight = localStorage.getItem('weight');
    // this.height = localStorage.getItem('height');
    // this.updatedetails()
    this.ts.getdetails(this.email1)
    .then(response=>{this.email=response.email,this.name=response.name,
      this.height=response.height,
      this.password = response.password,
      this.contact = response.contact,
      this.weight = response.weight,
      console.log(response.temail)
      this.updateForm.controls.name.setValue(this.name);
      this.updateForm.controls.password.setValue(this.password);
      this.updateForm.controls.temail.setValue(response.temail);
      this.updateForm.controls.height.setValue(this.height);
     this.updateForm.controls.weight.setValue(this.weight);
     this.updateForm.controls.contact.setValue(this.contact);
     })
  }
  updatedetails() {
    this.successmessage = null;
    this.errormessage = null;
    console.log(this.updateForm.value)
    this.ts.updateprofile(this.updateForm.value)
    .then(response =>{this.successmessage = response.message;this.height=response.height,
      this.name=response.name,this.email=response.email,
      this.password = response.password,
      this.weight = response.weight,
      this.contact = response.contact,
      
      this.updateForm.controls.email.setValue(this.email);
      this.updateForm.controls.name.setValue(this.name);  
      this.updateForm.controls.password.setValue(this.password);
      this.updateForm.controls.height.setValue(this.height); 
      this.updateForm.controls.weight.setValue(this.weight);
      this.updateForm.controls.contact.setValue(this.contact);
    
    })
    .catch(response =>this.errormessage = response.message)
  }
}
