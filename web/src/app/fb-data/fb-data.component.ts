import {Component, OnInit} from '@angular/core';
import {UserData} from "../types/user-data/user-data";
import {HttpService} from "../service/http-service/http-service";
import {Uri} from "../types/uri/uri";

@Component({
  selector: 'app-fb-data',
  templateUrl: './fb-data.component.html',
  styleUrls: ['./fb-data.component.css']
})
export class FbDataComponent implements OnInit {

  private columnsToDisplay = ['ID', 'NAME', 'GENDER', 'BIRTHDAY', 'LOCATION'];
  private fbUserData: UserData[] = [];
  private authUri: string;


  constructor(private httpService: HttpService) {
  }

  ngOnInit() {
    this.getData();
  }

  authenticate() {
    window.open("http://localhost:8080");
    this.getData();
  }

  getData(){

  }
}

