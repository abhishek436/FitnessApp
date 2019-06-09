export class fabfit{
    email: string;
    name:string;
    gender:string;
    password:string;
    height:Number;
    weight:Number;
    temail:string;
    trainerid:string;
    contact:Number;
    suggestions:string;
    message:string;
    getTemail():string{
        return this.temail;
    }
    setTemail(temail:string){
        this.temail=temail;
    }
}