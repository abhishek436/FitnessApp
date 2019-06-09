import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import {HomeComponent} from './home/home.component';
import {AboutComponent} from './about/about.component';
import {MainComponent} from './main/main.component';
import { AddetailsComponent } from './addetails/addetails.component';
import { TermsComponent } from './terms/terms.component';

import { BmiComponent } from './bmi/bmi.component';
import { FruitComponent } from './fruit/fruit.component';
import { VegetableComponent } from './vegetable/vegetable.component';
import { GrainComponent } from './grain/grain.component';
import { ProteinFoodComponent } from './protein-food/protein-food.component';
import { DairyComponent } from './dairy/dairy.component';
import { TrainerComponent } from './trainer/trainer.component';
import { ProfileComponent } from './profile/profile.component';
import { AddtrainerComponent } from './addtrainer/addtrainer.component';
import { AdminregComponent } from './adminreg/adminreg.component';
import { AdminComponent } from './admin/admin.component';
import { TrainerdetailComponent } from './trainerdetail/trainerdetail.component';
import { UpdatedietComponent } from './updatediet/updatediet.component';
import { DietchartComponent } from './dietchart/dietchart.component';
import { UpdatefitnessComponent } from './updatefitness/updatefitness.component';
import { GetraindetailComponent } from './getraindetail/getraindetail.component';
import { AdmininstructionComponent } from './admininstruction/admininstruction.component';
import { FitnessgalleryComponent } from './fitnessgallery/fitnessgallery.component';
import { TrainerregComponent } from './trainerreg/trainerreg.component';
import { ViewreqComponent } from './viewreq/viewreq.component';


const routes : Routes = [
  {
    path: '', component:MainComponent
  },
  {
       path :'login', component : LoginComponent
  },
  {
    path:'home',component:HomeComponent
  },
  {
    path:'about',component:AboutComponent
  },
  {
    path:'main',component:MainComponent
  },
  {
    path:'addetails',component:AddetailsComponent
  }, 
  {
    path:'terms',component:TermsComponent
  },
  {
    path:'bmi' , component : BmiComponent
  },
  {
    path:'trainer',component:TrainerComponent
  },
  {
    path:'profile', component:ProfileComponent
  },
  {
    path:'addtrainer' , component : AddtrainerComponent
  },
  {
      path:'adminreg' , component : AdminregComponent
  },
  {
    path : 'admin' ,component : AdminComponent
  },
  {
    path : 'trainerdetail',component : TrainerdetailComponent
  },
  {
    path : 'updatediet',component : UpdatedietComponent
  },
  {
    path:'updatefitness',component:UpdatefitnessComponent
  },
  {
    path:'dietchart',component:DietchartComponent
  },
  {
    path:'fruit',component:FruitComponent
  },
  {
    path:'vegetable',component:VegetableComponent
  },
  {
    path:'protein-food',component:ProteinFoodComponent
  },
  {
    path:'grain',component:GrainComponent
  },
  {
    path:'dairy',component:DairyComponent
  },
  {
  path : 'gettrainerdetail',component : GetraindetailComponent
  },
  {
    path:'admininstruction',component:AdmininstructionComponent
  },
  {
    path:'fgallery',component:FitnessgalleryComponent
  },
  {
    path:'trainerreg',component:TrainerregComponent
  },
  {
    path:'viewreq',component:ViewreqComponent
  }

];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
