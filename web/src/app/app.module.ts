import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {FbDataComponent} from './fb-data/fb-data.component';
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {HttpService} from "./service/http-service/http-service";
import {FbLoginComponent} from './fb-login/fb-login.component';

@NgModule({
  declarations: [
    AppComponent,
    FbDataComponent,
    FbLoginComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {
        path: '',
        component: FbLoginComponent
      },
      {
        path: 'fb/data',
        component: FbDataComponent
      }
    ]),
    HttpClientModule
  ],
  providers: [HttpService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
