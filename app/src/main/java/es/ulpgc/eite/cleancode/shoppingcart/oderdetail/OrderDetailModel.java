package es.ulpgc.eite.cleancode.shoppingcart.oderdetail;

import es.ulpgc.eite.cleancode.shoppingcart.data.OrderData;

public class OrderDetailModel implements OrderDetailContract.Model {

  public static String TAG = OrderDetailModel.class.getSimpleName();

  private OrderData data;

  @Override
  public OrderData getStoredData() {
    // Log.e(TAG, "getStoredNewData()");
    return data;
  }

  @Override
  public void onRestartScreen(OrderData data) {
    // Log.e(TAG, "onRestartScreen()");

    this.data=data;
  }

  @Override
  public void onDataFromPreviousScreen(OrderData data) {
    // Log.e(TAG, "onDataFromPreviousScreen()");

    this.data=data;
  }
}
