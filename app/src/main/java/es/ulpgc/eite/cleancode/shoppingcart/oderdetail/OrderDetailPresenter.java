package es.ulpgc.eite.cleancode.shoppingcart.oderdetail;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.shoppingcart.data.ProductData;

public class OrderDetailPresenter implements OrderDetailContract.Presenter {

  public static String TAG = OrderDetailPresenter.class.getSimpleName();

  private WeakReference<OrderDetailContract.View> view;
  private OrderDetailState state;
  private OrderDetailContract.Model model;
  private OrderDetailContract.Router router;

  public OrderDetailPresenter(OrderDetailState state) {
    this.state = state;
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    if (state == null) {
      state = new OrderDetailState();
    }

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
  public void onListTapped(ProductData data) {
    Log.e(TAG, "onListTapped()");

    //TODO: falta implementacion
  }

  @Override
  public void injectView(WeakReference<OrderDetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(OrderDetailContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(OrderDetailContract.Router router) {
    this.router = router;
  }
}
