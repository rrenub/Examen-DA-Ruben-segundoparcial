package es.ulpgc.eite.cleancode.shoppingcart.productdetail;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.shoppingcart.app.ProductDetailToListState;
import es.ulpgc.eite.cleancode.shoppingcart.app.ProductListToDetailState;
import es.ulpgc.eite.cleancode.shoppingcart.data.ProductData;

public interface ProductDetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(ProductDetailViewModel viewModel);
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

    void onProductButtonTapped();
  }

  interface Model {
    ProductData getStoredData();

    void onRestartScreen(ProductData data);

    void onDataFromPreviousScreen(ProductData data);

    void onDataUpdated();
  }

  interface Router {

    ProductListToDetailState getStateFromPreviousScreen();

    void passStateToPreviousScreen(ProductDetailToListState state);
  }
}
