import { Component } from '@angular/core';
import { NavController, NavParams, ToastController } from 'ionic-angular';

@Component({
  selector: 'page-signup',
  templateUrl: 'signup.html',
})
export class Signup {

  newUser: any = {};
  address_shipping_same: boolean;

  constructor(public navCtrl: NavController, public navParams: NavParams, public toastCtrl: ToastController) {
    this.newUser.address = {};
    this.newUser.shipping_address = {};
    this.address_shipping_same = false;
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad SignupPage');
  }

  setAdressToShipping(){
    this.address_shipping_same = !this.address_shipping_same;
  }

  checkEmail(){
    let validEMail = false;

    let reg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    if(reg.test(this.newUser.email)){
      validEMail = true;

      this.toastCtrl.create({
        message: "Congratulations. Email is valid",
        duration: 3000
      }).present();

      console.log(validEMail);
    } else {
      validEMail = false;

      this.toastCtrl.create({
        message: "Invalid email",
        showCloseButton: true
      }).present();
    }

  }

}
