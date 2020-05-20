package es.ulpgc.eite.cleancode.shoppingcart.oderdetail;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.shoppingcart.app.OrderListToDetailState;
import es.ulpgc.eite.cleancode.shoppingcart.data.OrderData;
import es.ulpgc.eite.cleancode.shoppingcart.data.ProductData;

public interface OrderDetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(OrderDetailViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void onResume();

    void onStart();

    void onRestart();

    void onBackPressed();

    void onPause();

    void onDestroy();

    void onListTapped(ProductData data);
  }

  interface Model {
    OrderData getStoredData();

    void onRestartScreen(OrderData data);

    void onDataFromPreviousScreen(OrderData data);
  }

  interface Router {

    OrderListToDetailState getStateFromPreviousScreen();
  }
}
