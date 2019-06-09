import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FabfitServiceService } from '../fabfitService.service';
import {train} from '../Trainer/train';
import { Requests } from '../trainerreg/Requests';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  errorMessage:string
  successMessage:string
  addAdminForm: FormGroup;
  req1:Requests[];
  trainerid : train = new train();
  constructor(private fb: FormBuilder,private router:Router,private as:FabfitServiceService) { }

  adminRegister(){
    this.successMessage=null
    this.errorMessage=null
    console.log(this.addAdminForm.value)
    this.as.trainerlogin(this.addAdminForm.value)
    .then(response => {this.successMessage=response.message
      localStorage.setItem('trainerid',response.email)
      this.as.navTrainershow = false
      this.router.navigateByUrl('trainer')
      })
      // this.router.navigateByUrl('adminreg')
    .catch(error =>{this.errorMessage=error.message
   })
  }
  ngOnInit() {
    this.addAdminForm = this.fb.group({
      email:['',[Validators.required,Validators.pattern("[a-z0-9]+@(gmail||hotmail||yahoo).(com||in||co.in)")]],
      password :['',[Validators.required,Validators.pattern("(?=.*\\d)(?=.*[!@$%^&()#*+])(?=.*[a-z])(?=.*[A-Z]).{8,}"),Validators.minLength(6)]],
    });
    this.as.getrequest().then(response=>this.req1=response)
  }

}
