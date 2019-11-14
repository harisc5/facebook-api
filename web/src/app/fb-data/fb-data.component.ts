import {Component, OnInit} from '@angular/core';
import {UserData} from "../types/user-data/user-data";
import {HttpService} from "../service/http-service/http-service";
import {Uri} from "../types/uri/uri";
import {stringify} from "querystring";

@Component({
  selector: 'app-fb-data',
  templateUrl: './fb-data.component.html',
  styleUrls: ['./fb-data.component.css']
})
export class FbDataComponent implements OnInit {

  private columnsToDisplay = ['ID', 'NAME', 'GENDER', 'BIRTHDAY'];
  private displayData: boolean;
  private fbUserData: UserData[] = [];

  constructor(private httpService: HttpService) {
  }

  ngOnInit() {
  }

  getData(){
    this.displayData = true;
    return this.httpService
      .get("http://localhost:8080/getData")
      .subscribe(response =>{
        this.fbUserData = Object.values(response);
        console.log(this.fbUserData);
      }, error => {
        console.log(error.error);
      });
  }
}

