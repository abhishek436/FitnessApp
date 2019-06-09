import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { FabfitServiceService } from '../fabfitService.service';
import { Diet } from '../bmi/Diet';

@Component({
  selector: 'app-updatediet',
  templateUrl: './updatediet.component.html',
  styleUrls: ['./updatediet.component.css']
})
export class UpdatedietComponent implements OnInit {
  
  dietUpdateForm:FormGroup;
  fetchDiet:String;
  diet1:Diet;
  element:String;
  dietdetails:Diet = new Diet();
  message:string;
  flag:boolean=false;
  success:String;
   constructor(private fb:FormBuilder,private serve:FabfitServiceService) { }

  ngOnInit() {this.flag=false,
    this.dietUpdateForm=this.fb.group({gender:[''],goals:[''],level1:[''],updateColumns:[''],calories:[''],updateValue:['']})
  }
updatediet(){
    this.serve.updatediet(this.dietUpdateForm.value)
    .then(response=>{this.dietdetails=response,this.success=response.message,
      this.flag=true;
    console.log(response)}
    ).catch(res=>this.message=res.message)
    
  
  }
  fetchdiet(){
    this.element=this.dietUpdateForm.controls.updateColumns.value;
    this.serve.fetch(this.dietUpdateForm.value).then(response=>{this.diet1=response,
    console.log(response),this.dietUpdateForm.controls.updateValue.setValue(this.diet1.updateValue)})}
  
}
