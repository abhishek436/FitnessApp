import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import "rxjs/add/operator/toPromise";
import {Admin} from './admin';
import { Trainer } from './trainer/Trainer';
import { Fitness } from './bmi/Fitness';
import { Diet } from './bmi/Diet';
import { fabfit } from './fabfit';
import { Request } from '@angular/http/src/static_request';
import { Requests } from './trainerreg/Requests';

@Injectable()
export class FabfitServiceService {
  data2:string;
  navShow : boolean = true
  navShowadmin : boolean = true
  navTrainershow : boolean = true
  constructor(private http:Http) { 
     if(localStorage.getItem('data') != null){
       this.navShow=false;
     }
     if(localStorage.getItem('adminId')!=null){
      this.navShowadmin=false
    }
    if(localStorage.getItem('trainerid')!=null) {
      this.navTrainershow=false;
    }
  }
  updatedetails(data) : Promise<any>{
    return this.http.post('http://localhost:3333/tempProj/FABFITapi/updatedetails',data)
    .toPromise()
    .then(response=>response.json())
    .catch(this.errorHandler);
  }
  addtrainer(data) : Promise<any>{
    return this.http.post('http://localhost:3333/tempProj/FABFITapi/addtrainer',data)
    .toPromise()
    .then(response=>response.json())
    .catch(this.errorHandler);
  }
  
  verifydetails(data) : Promise<any> {
    return this.http.post('http://localhost:3333/tempProj/FABFITapi/login',data)
    .toPromise()
    .then(response=>response.json())
    .catch(this.errorHandler);
  }
 
  addetails(data) : Promise<any> {
    return this.http.post('http://localhost:3333/tempProj/FABFITapi/addetails',data)
    .toPromise()
    .then(response=>response.json())
    .catch(this.errorHandler)
  }
  trainerlogin(data) : Promise<any> {
    return this.http.post('http://localhost:3333/tempProj/FABFITapi/trainerlogin',data)
    .toPromise()
    .then(response=>response.json())
    .catch(this.errorHandler)
  }
  adminLogin(data):Promise<Admin>{
    return this.http.post('http://localhost:3333/tempProj/FABFITapi/adminlogin', data)
      .toPromise()
      .then(response => response.json())
      .catch(this.errorHandler);
  }
  getTrainer() : Promise<any> {
    return this.http.get('http://localhost:3333/tempProj/FABFITapi/receive')
    .toPromise()
    .then(response=>response.json())
    .catch(this.errorHandler)
  }
  updateprofile(data) : Promise<any> {
    return this.http.post('http://localhost:3333/tempProj/FABFITapi/profileupdate',data)
    .toPromise()
    .then(response=>response.json())
    .catch(this.errorHandler)
  }
  getdiet(data) : Promise<Diet[]> {
    console.log(data)
    return this.http.post("http://localhost:3333/tempProj/FABFITapi/getDiet",data)
    .toPromise().then(response=>response.json()as Diet[]).catch(this.errorHandler)

  }
  fetch(data) : Promise<Diet> {
    console.log(data)
    return this.http.post("http://localhost:3333/tempProj/FABFITapi/fetchdiet",data)
    .toPromise().then(response=>response.json()as Diet).catch(this.errorHandler)

  }
  fetchFitness(data) : Promise<Fitness> {
    console.log(data)
    return this.http.post("http://localhost:3333/tempProj/FABFITapi/fetchfitness",data)
    .toPromise().then(response=>response.json()as Fitness).catch(this.errorHandler)

  }
  updatediet(data) : Promise<any> {
    console.log(data)
    return this.http.post("http://localhost:3333/tempProj/FABFITapi/updatediet",data)
    .toPromise().then(response=>response.json()).catch(this.errorHandler)

  }
  getdetails(data): Promise<any>{
    return this.http.get("http://localhost:3333/tempProj/FABFITapi/getdetails/"+data)
    .toPromise().then(response=>response.json()).catch(this.errorHandler)
  }
  booktrainer(data,data1):Promise<any>{
    this.data2=data+"-"+data1;
    console.log(this.data2)
    return this.http.post("http://localhost:3333/tempProj/FABFITapi/booktrainer",this.data2)
    .toPromise().then(response=>response.json()).catch(this.errorHandler)
  }
  getinfo(data):Promise<any>{
    return this.http.post("http://localhost:3333/tempProj/FABFITapi/getinfo",data)
    .toPromise().then(response=>response.json() as Trainer).catch(this.errorHandler)
  }
  setsuggestion(data):Promise<any> {
    return this.http.post("http://localhost:3333/tempProj/FABFITapi/suggestion",data)
    .toPromise()
    .then(response=>response.json())
    .catch(this.errorHandler)
  }

  getFit(data) : Promise<Fitness[]> {
    console.log(data)
    return this.http.post("http://localhost:3333/tempProj/FABFITapi/getFit",data)
    .toPromise().then(response=>response.json()as Fitness[]).catch(this.errorHandler)
  }

  
updateFitness(data) : Promise<any> {
    console.log(data)
    return this.http.post("http://localhost:3333/tempProj/FABFITapi/updateFitness",data)
    .toPromise().then(response=>response.json()as Fitness[]).catch(this.errorHandler)

  }
  errorHandler(error){
    console.log(error)
    return Promise.reject(error.json())
  }
  deletetrainer(data):Promise<any>{
    return this.http.post("http://localhost:3333/tempProj/FABFITapi/deletetrainer",data)
    .toPromise().then(response=>response.json()).catch(this.errorHandler)
  }
  getsuggestions(data):Promise<fabfit>{
    return this.http.post("http://localhost:3333/tempProj/FABFITapi/getsuggestion",data)
    .toPromise().then(response=>response.json()as fabfit).catch(this.errorHandler)

  }
  removetrainer(data):Promise<fabfit>{
    return this.http.post("http://localhost:3333/tempProj/FABFITapi/removetrainer",data)
    .toPromise().then(response=>response.json()as fabfit).catch(this.errorHandler)

  }
  sendrequest(data):Promise<Requests>{
    return this.http.post("http://localhost:3333/tempProj/FABFITapi/sendrequest",data)
    .toPromise().then(response=>response.json()as Requests).catch(this.errorHandler)

  }
  getrequest():Promise<Requests[]>{
    return this.http.get("http://localhost:3333/tempProj/FABFITapi/getrequest")
    .toPromise().then(response=>response.json()as Requests[]).catch(this.errorHandler)

  }
  acceptreq(data):Promise<Requests>{
    return this.http.post("http://localhost:3333/tempProj/FABFITapi/acceptrequest",data)
    .toPromise().then(response=>response.json()as Requests).catch(this.errorHandler)
  }
  rejectreq(data):Promise<Requests>{
    return this.http.post("http://localhost:3333/tempProj/FABFITapi/rejectrequest",data)
    .toPromise().then(response=>response.json()as Requests).catch(this.errorHandler)
  }

  viewStatus(data):Promise<Requests>{
    return this.http.get("http://localhost:3333/tempProj/FABFITapi/getrequest/"+data)
    .toPromise().then(response=>response.json()as Requests).catch(this.errorHandler)
  }
}
