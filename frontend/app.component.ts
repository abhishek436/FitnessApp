
import { Component } from '@angular/core';
import {Router} from "@angular/router";
import { FabfitServiceService } from './fabfitService.service';
import { HomeComponent } from './home/home.component';
import { fabfit } from './fabfit';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  mail:string;

  constructor(private as:FabfitServiceService, private hc: HomeComponent ){}


  ngOnInit(){
    this.mail=localStorage.getItem('userDetail')
    console.log(this.mail);
  }

  logOut(){
    localStorage.clear();
    this.as.navShow=true;   
  }
  adminout() {
    localStorage.clear();
    this.as.navShowadmin = true;
  }
  trainerout() {
    localStorage.clear();
    this.as.navTrainershow = true;
  }
}
