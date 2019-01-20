import { Component, ViewChild } from '@angular/core';
import { NavController, Slides, ToastController } from 'ionic-angular';
//import * as WC from 'woocommerce-api';
import { ProduitService } from '../../providers/data/produit-service';
import { ProductDetails } from '../product-details/product-details';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
  
  products: Array<any>;
  moreProducts: Array<any>;
  page: number;
  sizeMoreProducts: number;
  category: any;
  
  // @ViewChild('productSlides') productSlides: Slides;

  constructor(public navCtrl: NavController, public produitService: ProduitService, public toastCtrl : ToastController){
    this.page = 1;
    this.loadMoreProducts(null);
    
  }

  ionViewDidLoad() {
    this.produitService.getProduits().subscribe(products => { this.products = products; });
    // setInterval(() => {
    //   if(this.productSlides.getActiveIndex() == this.productSlides.length() - 1){
    //     this.productSlides.slideTo(0);
    //   }

    //   this.productSlides.slideNext();
    // }, 3000);
  }

  loadMoreProducts(event){
    //this.produitService.getProduits().subscribe(products => { this.products = products; });
    if(event == null){
      this.page = 0;
      this.moreProducts = [];
    }else{
      this.page ++;
    }
   
   this.moreProducts.concat(this.produitService.getPaginedProducts(this.page).subscribe(products => { this.moreProducts = this.moreProducts.concat(products); this.sizeMoreProducts = products.length; }));
   if(event != null){
     event.complete();
   }

   if(this.sizeMoreProducts < 10){
     event.enable(false);

     this.toastCtrl.create({
       message: "Pas plus de produits !!",
       duration: 5000
     }).present();
   }
  }

  openProductPage(product){
    this.navCtrl.push(ProductDetails, {"product": product});
  }

}
