import { Component } from '@angular/core';
import { NavController, NavParams, ToastController } from 'ionic-angular';
import { ProduitService } from '../../providers/data/produit-service';
import { ProductDetails } from '../product-details/product-details';

@Component({
  selector: 'page-products-by-category',
  templateUrl: 'products-by-category.html',
})
export class ProductsByCategory {

  products: any[];
  page: number;
  category: number;
  sizeMoreProducts: number;

  constructor(public navCtrl: NavController, public navParams: NavParams, public produitService: ProduitService,  public toastCtrl : ToastController) {
    this.page = 0;
    this.category = this.navParams.get("category");

    this.loadMoreProducts(null);
    this.produitService.getProduitsByCategory(this.category).subscribe(products => { this.products = products; });
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ProductsByCategory');
  }

  loadMoreProducts(event){
    //this.produitService.getProduits().subscribe(products => { this.products = products; });
    if(event == null){
      this.page = 0;
      this.products = [];
    }else{
      this.page++;
    }
   
   this.products.concat(this.produitService.getProductsByCategoryPagined(this.category, this.page).subscribe(products => { this.products = this.products.concat(products); this.sizeMoreProducts = products.length; }));
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
