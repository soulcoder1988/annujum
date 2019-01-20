import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
export class ProduitService {

  public API = 'http://192.168.227.1:8080/';
  public PRODUIT_API = this.API + '/products';

  constructor(public http: HttpClient) {
    console.log('Hello DataProvider Provider');
  }

  getProduits(): Observable<any> {
    return this.http.get(this.API + '/products/list');
  }

  getProduitsByCategory(idCategory: number): Observable<any> {
    return this.http.get(this.API + '/products/listByCategory/' + idCategory);
  }

  getProductsByCategoryPagined(idCategory: number, page: number): Observable<any> {
    return this.http.get(this.API + '/products/listByCategoryPagined/' + idCategory + '/' + page);
  }

  getPaginedProducts(page: number):Observable<any>{
    return this.http.get(this.API + '/products/list/' + page);
  }

  getAllCategories(): Observable<any> {
    return this.http.get(this.API + '/products/allCategories');
  }
}
