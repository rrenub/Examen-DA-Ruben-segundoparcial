package es.ulpgc.eite.cleancode.shoppingcart.productdetail;

import es.ulpgc.eite.cleancode.shoppingcart.data.ProductData;

public class ProductDetailModel implements ProductDetailContract.Model {

  public static String TAG = ProductDetailModel.class.getSimpleName();

  private ProductData data;


  @Override
  public ProductData getStoredData() {
    // Log.e(TAG, "getStoredDatasource()");
    return data;
  }

  @Override
  public void onRestartScreen(ProductData data) {
    // Log.e(TAG, "onRestartScreen()");

    this.data=data;
  }

  @Override
  public void onDataFromPreviousScreen(ProductData data) {
    // Log.e(TAG, "onDataFromPreviousScreen()");

    this.data=data;
  }

  @Override
  public void onDataUpdated() {
    //TODO: falta implementacion
  }

}
