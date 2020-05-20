package es.ulpgc.eite.cleancode.shoppingcart.orderlist;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.shoppingcart.app.OrderListToDetailState;
import es.ulpgc.eite.cleancode.shoppingcart.app.OrderToProductListState;
import es.ulpgc.eite.cleancode.shoppingcart.app.ProductToOrderListState;
import es.ulpgc.eite.cleancode.shoppingcart.data.OrderData;

public interface OrderListContract {

  interface View {
    void injectPresenter(Presenter presenter);
    void navigateToNextScreen();
    void navigateToDetailScreen();
    void onDataUpdated(OrderListViewModel viewModel);
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

    void onButtonTapped();

    void onListTapped(OrderData data);
  }

  interface Model {
    List<OrderData> getStoredDatasource();
    OrderData getStoredNewData();


    void onRestartScreen(List<OrderData> datasource);

    void onNewDataAdded();

    void onDataFromNextScreen(OrderData data);

    void onResetDatastore();
  }

  interface Router {

    void passStateToNextScreen(OrderToProductListState state);
    void passStateToDetailScreen(OrderListToDetailState state);

    ProductToOrderListState getStateFromNextScreen();

  }
}
