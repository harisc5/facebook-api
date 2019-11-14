import {Component, OnInit} from '@angular/core';
import {HttpService} from "../service/http-service/http-service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-fb-login',
  templateUrl: './fb-login.component.html',
  styleUrls: ['./fb-login.component.css']
})
export class FbLoginComponent implements OnInit {

  constructor(private httpService: HttpService, private router: Router) {
  }

  ngOnInit() {
  }

  fbLogin() {
    window.open("http://localhost:8080/");
    this.router.navigateByUrl('fb/data');
  }
}
