import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AppRoutingModule } from './app-routing.module';
import { LoginComponent } from './login/login.component';
import { AboutComponent } from './about/about.component';
import { FabfitServiceService } from './fabfitService.service';
import { HttpModule } from '@angular/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MainComponent } from './main/main.component';
import { AddetailsComponent } from './addetails/addetails.component';

import { TermsComponent } from './terms/terms.component';
import { BmiComponent } from './bmi/bmi.component';
import { DairyComponent } from './dairy/dairy.component';
import { FruitComponent } from './fruit/fruit.component';
import { GrainComponent } from './grain/grain.component';
import { ProteinFoodComponent } from './protein-food/protein-food.component';
import { VegetableComponent } from './vegetable/vegetable.component';
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


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    AboutComponent,
    MainComponent,
    AddetailsComponent,
   
    TermsComponent,

    BmiComponent,
    DairyComponent,
    FruitComponent,
    GrainComponent,
    ProteinFoodComponent,
    VegetableComponent,
    TrainerComponent,
    ProfileComponent,
    AddtrainerComponent,
    AdminregComponent,
    AdminComponent,
    TrainerdetailComponent,
    UpdatedietComponent,
    DietchartComponent,
    UpdatefitnessComponent,
    GetraindetailComponent,
    AdmininstructionComponent,
    FitnessgalleryComponent,
    TrainerregComponent,
    ViewreqComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [FabfitServiceService, HomeComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
