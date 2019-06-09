import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Requests } from '../trainerreg/Requests';
import { FabfitServiceService } from '../fabfitService.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-viewreq',
  templateUrl: './viewreq.component.html',
  styleUrls: ['./viewreq.component.css']
})
export class ViewreqComponent implements OnInit {
  req1:Requests[];
  req2:Requests;
  constructor(private fb: FormBuilder,private router:Router,private as:FabfitServiceService) { }

  ngOnInit() {
    this.as.getrequest().then(response=>{this.req1=response})

  }
  acceptreq(re){
   
    this.as.acceptreq(re).then(response=>{this.req2=response,this.ngOnInit()})
  }
  rejectreq(re){
   
    this.as.rejectreq(re).then(response=>{this.req2=response,this.ngOnInit()})
  }

}
