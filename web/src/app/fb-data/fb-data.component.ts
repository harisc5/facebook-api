import {Component, OnInit} from '@angular/core';
import {UserData} from "../types/user-data/user-data";
import {HttpService} from "../service/http-service/http-service";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-fb-data',
  templateUrl: './fb-data.component.html',
  styleUrls: ['./fb-data.component.css']
})
export class FbDataComponent implements OnInit {

  private columnsToDisplay = ['ID', 'NAME', 'GENDER', 'BIRTHDAY'];
  private displayData: boolean;
  private displayEditModal: boolean;
  private fbUserData: UserData[] = [];
  private editData: UserData = new UserData();
  private fbDataForm = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    gender: new FormControl(),
    birthday: new FormControl()
  });

  constructor(private httpService: HttpService) {
  }

  ngOnInit() {
  }

  getData() {
    this.displayData = true;
    return this.httpService
      .get("/getData")
      .subscribe(response => {
        this.fbUserData = [];
        const results = Array.isArray(response) ? Array.from(response) : [];
        if (results.length > 0) {
          for (const obj of results) {
            this.fbUserData.push(obj);
          }
        }
        console.log(this.fbUserData);
      }, error => {
        console.log(error.error);
      });
  }

  openModal(data) {
    this.displayEditModal = true;
    this.editData = JSON.parse(JSON.stringify(data));
  }

  closeModal() {
    this.displayEditModal = false;
  }

  writeFile() {
    return this.httpService
      .post("/write", this.fbDataForm.value)
      .subscribe(response => {
        alert("File written to disk");
        this.displayEditModal = false;
        this.fbUserData[0] = this.fbDataForm.value;
      });
  }

}

