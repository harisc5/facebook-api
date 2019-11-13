import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FbDataComponent } from './fb-data/fb-data.component';
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {HttpService} from "./service/http-service/http-service";

@NgModule({
  declarations: [
    AppComponent,
    FbDataComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {
        path: '',
        component:FbDataComponent
      }
    ]),
    HttpClientModule
  ],
  providers: [HttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
