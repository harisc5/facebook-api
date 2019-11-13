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
    this.authenticate();
    this.getData();
  }

  authenticate() {
    console.log("usao u metodu");
    return this.httpService
      .get("http://localhost:8080")
      .subscribe(response => {
        this.authUri = response.toString();
      }, error => {
        console.log(error.error);
      });
  }

  getData(){
    return this.httpService
      .get("http://localhost:8080/getData")
      .subscribe(response=>{
        this.fbUserData = [];
        const results = Array.isArray(response) ? Array.from(response) : [];
        console.log(results);
        if (results.length > 0) {
          for (const obj of results) {
            this.fbUserData.push(obj);
          }
        }
      }, error => {
        console.log(error.error);
      });
  }
}

