import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable()
export class UserService {
  public API = 'http://192.168.227.1:8080/';
  public USER_API = this.API + '/user';

  constructor(public http: HttpClient) {
    console.log('Hello UserServiceProvider Provider');
  }

  getUsers(){
    this.http.get("this.API + '/user/list'");
  }

}
