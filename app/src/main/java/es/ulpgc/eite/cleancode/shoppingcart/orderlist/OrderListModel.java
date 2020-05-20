package es.ulpgc.eite.cleancode.shoppingcart.orderlist;

import android.util.Log;

import java.util.List;

import es.ulpgc.eite.cleancode.shoppingcart.data.OrderData;
import es.ulpgc.eite.cleancode.shoppingcart.data.ProductStore;

public class OrderListModel implements OrderListContract.Model {

  public static String TAG = OrderListModel.class.getSimpleName();

  private OrderData data;
  private List<OrderData> datasource;

  public OrderListModel() {
    //TODO: falta implementacion
  }

  @Override
  public List<OrderData> getStoredDatasource() {
    // Log.e(TAG, "getStoredDatasource()");
    return datasource;
  }

  @Override
  public OrderData getStoredNewData() {
    // Log.e(TAG, "getStoredNewData()");
    return data;
  }

  @Override
  public void onRestartScreen(List<OrderData> datasource) {
    // Log.e(TAG, "onRestartScreen()");
    this.datasource=datasource;
  }

  @Override
  public void onDataFromNextScreen(OrderData data) {
    // Log.e(TAG, "onDataFromNextScreen()");

    this.data=data;
  }

  @Override
  public void onResetDatastore() {
    Log.e(TAG, "onResetDatastore()");

    ProductStore.reinstance(); // for testing
  }

  @Override
  public void onNewDataAdded() {
    //TODO: falta implementacion

  }
}
