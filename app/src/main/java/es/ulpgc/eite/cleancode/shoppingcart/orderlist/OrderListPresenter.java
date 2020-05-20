package es.ulpgc.eite.cleancode.shoppingcart.orderlist;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.shoppingcart.data.OrderData;

public class OrderListPresenter implements OrderListContract.Presenter {

  public static String TAG = OrderListPresenter.class.getSimpleName();

  private WeakReference<OrderListContract.View> view;
  private OrderListState state;
  private OrderListContract.Model model;
  private OrderListContract.Router router;

  public OrderListPresenter(OrderListState state) {
    this.state = state;
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    if (state == null) {
      state = new OrderListState();
    }

    model.onResetDatastore(); // for testing

    //TODO: falta implementacion
  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    //TODO: falta implementacion
  }

  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    //TODO: falta implementacion

  }

  @Override
  public void onBackPressed() {
    Log.e(TAG, "onBackPressed()");

    //TODO: falta implementacion
  }

  @Override
  public void onPause() {
    Log.e(TAG, "onPause()");
  }

  @Override
  public void onDestroy() {
    Log.e(TAG, "onDestroy()");
  }

  @Override
  public void onButtonTapped() {
    Log.e(TAG, "onButtonTapped()");

    //TODO: falta implementacion
  }

  @Override
  public void onListTapped(OrderData data) {
    Log.e(TAG, "onListTapped()");

    //TODO: falta implementacion
  }

  @Override
  public void injectView(WeakReference<OrderListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(OrderListContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(OrderListContract.Router router) {
    this.router = router;
  }
}
