import { Component, ViewChild } from '@angular/core';
import { NavController, NavParams,ToastController } from 'ionic-angular';
import { HomePage } from '../home/home';
import { ProduitService } from '../../providers/data/produit-service';
import { ProductsByCategory } from '../../pages/products-by-category/products-by-category';

@Component({
  selector: 'page-menu',
  templateUrl: 'menu.html',
})
export class Menu {

  homePage: any;
  categories: Array<any>;
  products: Array<any>;
  @ViewChild('content') childNavCtrl: NavController;

  constructor(public navCtrl: NavController, public navParams: NavParams, public produitService: ProduitService, public toastCtrl : ToastController) {
    //this.homePage =  new HomePage(navCtrl, produitService, toastCtrl);
    this.homePage = HomePage;
    this.produitService.getAllCategories().subscribe(categories => {this.categories = categories; });
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad MenuPage');
  }

  openCategoryPage(category){
    this.childNavCtrl.setRoot(ProductsByCategory, { "category": category })
  }
  
}
