import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { FabfitServiceService } from '../fabfitService.service';
import { Fitness } from '../bmi/Fitness';

@Component({
  selector: 'app-updatefitness',
  templateUrl: './updatefitness.component.html',
  styleUrls: ['./updatefitness.component.css']
})
export class UpdatefitnessComponent implements OnInit {
  fitnessUpdateForm:FormGroup;
  fitnessdetails:Fitness = new Fitness();
  message:string;
  fitness1:Fitness;
  element:String;
  flag:boolean=false;
  success:String;
   constructor(private fb:FormBuilder,private serve:FabfitServiceService) { }

  ngOnInit() {this.flag=false,
    this.fitnessUpdateForm=this.fb.group({gender:[''],goals:[''],level1:[''],updateColumns:[''],updateValue:['']})
  }
updateFitness(){
    this.serve.updateFitness(this.fitnessUpdateForm.value)
    .then(response=>{this.fitnessdetails=response,this.success=response.message,
      this.flag=true;
    console.log(response)}
    ).catch(res=>this.message=res.message)
  }

  fetchFitness(){
    this.element=this.fitnessUpdateForm.controls.updateColumns.value;
    this.serve.fetchFitness(this.fitnessUpdateForm.value).then(response=>{this.fitness1=response,
    console.log(response),this.fitnessUpdateForm.controls.updateValue.setValue(this.fitness1.updateValue)})}
}
