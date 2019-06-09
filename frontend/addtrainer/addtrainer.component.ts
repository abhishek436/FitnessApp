import { Component, OnInit } from '@angular/core';
import { FormGroup,FormBuilder, Validators } from '@angular/forms';
import { FabfitServiceService } from '../fabfitService.service';

@Component({
  selector: 'app-addtrainer',
  templateUrl: './addtrainer.component.html',
  styleUrls: ['./addtrainer.component.css']
})
export class AddtrainerComponent implements OnInit {
  addtrainerform:FormGroup
  successmessage:String
  errormessage :String

  mailtext :string="";
  constructor(private fb:FormBuilder,private as:FabfitServiceService) { }
  addtrainer()
  {
    this.successmessage = null;
    this.errormessage = null;
    this.as.addtrainer(this.addtrainerform.value)
    .then(response =>{
      this.successmessage = response.message
     
    })
    .catch(response =>this.errormessage = response.message)
    
  }


  ngOnInit() {
    this.addtrainerform=this.fb.group({
      name:['',[Validators.required,Validators.pattern("[A-Za-z ]+")]],
      specialization:['',[Validators.required,Validators.pattern("[A-Za-z ]+")]],
      gender:['',[Validators.required]],
      email:['',[Validators.required,Validators.pattern("[a-z0-9]+@(gmail||hotmail||yahoo).(com||in||co.in)")]],
      contact:['',[Validators.required,Validators.pattern("[7-9][0-9]{9}")]],
      password:['',[Validators.required,Validators.pattern("(?=.*\\d)(?=.*[!@$%^&()#*+])(?=.*[a-z])(?=.*[A-Z]).{8,}")]]
      // password:['',[Validators.required,Validators.pattern("(?=.*\\d)(?=.*[!@$%^&()#*+])(?=.*[a-z])(?=.*[A-Z]).{8,}")]],
    });

  
  }

}
