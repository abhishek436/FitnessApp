import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FabfitServiceService } from '../fabfitService.service';
import {Admin} from '../admin';

@Component({
  selector: 'app-adminreg',
  templateUrl: './adminreg.component.html',
  styleUrls: ['./adminreg.component.css']
})
export class AdminregComponent implements OnInit {

  adminForm: FormGroup;
  errorMessage: string;
  successMessage: string;
  adminId : Admin = new Admin();
  constructor(private fb: FormBuilder, private fs: FabfitServiceService, private router:Router) { }

  login(){
    this.successMessage=null
    this.errorMessage=null
    this.fs.adminLogin(this.adminForm.value)
    .then(res =>{this.successMessage=res.message
      localStorage.setItem('adminId',res.adminId)
      this.fs.navShowadmin=false
      this.router.navigateByUrl('admininstruction')})
    .catch(error =>this.errorMessage=error.message)

  }

  ngOnInit() {
    this.adminForm = this.fb.group({
      adminId: ['',[Validators.required]],
      password: ['',[Validators.required]],
    });
  }

}
