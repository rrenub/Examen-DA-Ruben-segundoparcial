package es.ulpgc.eite.cleancode.shoppingcart.productlist;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.shoppingcart.app.OrderToProductListState;
import es.ulpgc.eite.cleancode.shoppingcart.app.ProductDetailToListState;
import es.ulpgc.eite.cleancode.shoppingcart.app.ProductListToDetailState;
import es.ulpgc.eite.cleancode.shoppingcart.app.ProductToOrderListState;
import es.ulpgc.eite.cleancode.shoppingcart.data.OrderData;
import es.ulpgc.eite.cleancode.shoppingcart.data.ProductData;

public interface ProductListContract {

  interface View {
    void injectPresenter(Presenter presenter);
    void navigateToNextScreen();

    void onDataUpdated(ProductListViewModel viewModel);
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


    List<ProductData> getStoredDatasource();

    void onDataFromNextScreen(ProductData data);

    void onDataFromPreviousScreen(OrderData data);

    void onRestartScreen(List<ProductData> datasource, OrderData data);

  }

  interface Router {

    void passStateToNextScreen(ProductListToDetailState state);

    OrderToProductListState getStateFromPreviousScreen();

    ProductDetailToListState getStateFromNextScreen();

    void passStateToPreviousScreen(ProductToOrderListState state);
  }
}
