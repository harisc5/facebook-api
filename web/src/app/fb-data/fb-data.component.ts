import { Component, OnInit } from '@angular/core';
import {UserData} from "../types/user-data/user-data";
import {HttpService} from "../service/http-service/http-service";
import {Uri} from "../types/uri/uri";

@Component({
  selector: 'app-fb-data',
  templateUrl: './fb-data.component.html',
  styleUrls: ['./fb-data.component.css']
})
export class FbDataComponent implements OnInit {

  private columnsToDisplay = ['ID', 'NAME', 'GENDER','BIRTHDAY','LOCATION'];
  private fbUserData: UserData[] = [];
  private authUri: Uri;


  constructor(private httpService: HttpService) { }

  ngOnInit() {
    this.authenticate();
  }

  authenticate() {
    console.log("usao u metodu");
    return this.httpService
      .get("http://localhost:8080")
      .subscribe(response => {
        const results = Array.isArray(response) ? Array.from(response) : [];
        this.authUri = results[0];
      })
  }
}


//$scope.tmp = angular.fromJson($scope.text);
