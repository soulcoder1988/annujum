import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { Menu } from '../pages/menu/menu';
import { ProduitService } from '../providers/data/produit-service';
import { ProductsByCategory } from '../pages/products-by-category/products-by-category';
import { ProductDetails } from '../pages/product-details/product-details';
import { Signup } from '../pages/signup/signup';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { UserServiceProvider } from '../providers/data/user-service';

@NgModule({
  declarations: [
    MyApp,
    HomePage,
    Menu,
    ProductsByCategory,
    ProductDetails,
    Signup
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    IonicModule.forRoot(MyApp),
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    Menu,
    ProductsByCategory,
    ProductDetails,
    Signup
  ],
  providers: [
    StatusBar,
    SplashScreen,
    ProduitService,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    UserServiceProvider,
  ]
})
export class AppModule {}
