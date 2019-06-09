import { Component, OnInit } from '@angular/core';
import { FabfitServiceService } from '../fabfitService.service';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Requests } from './Requests';

@Component({
  selector: 'app-trainerreg',
  templateUrl: './trainerreg.component.html',
  styleUrls: ['./trainerreg.component.css']
})
export class TrainerregComponent implements OnInit {
  sendrequestform:FormGroup
  viewStatusForm:FormGroup
  successmessage:String
  errormessage :String
  status:Requests;
  id1:number;
  requestid : number;
  statusmessage:String;
  constructor(private fb:FormBuilder,private serve:FabfitServiceService) { }

  ngOnInit() {
    this.sendrequestform=this.fb.group({
      name:['',[Validators.required,Validators.pattern("[A-Za-z ]+")]],
      specialization:['',[Validators.required,Validators.pattern("[A-Za-z ]+")]],
      gender:['',[Validators.required]],
      email:['',[Validators.required,Validators.pattern("[a-z0-9]+@(gmail||hotmail||yahoo).(com||in||co.in)")]],
      contact:['',[Validators.required,Validators.pattern("[7-9][0-9]{9}")]],
      password:['',[Validators.required,Validators.pattern("(?=.*\\d)(?=.*[!@$%^&()#*+])(?=.*[a-z])(?=.*[A-Z]).{8,}")]]
  })
  this.viewStatusForm=this.fb.group({id:['']})

}
    sendrequest()
    {console.log(this.sendrequestform.value)
      this.serve.sendrequest(this.sendrequestform.value)
      .then(response=>{this.successmessage=response.message,
        this.requestid = response.reqId,
      console.log(response.reqId)})
    }
    viewStatus(){
      this.statusmessage=null;
      this.id1=this.viewStatusForm.controls.id.value;
this.serve.viewStatus(this.id1).then(response=>{this.status=response,this.statusmessage=this.status.status})
    }
}
