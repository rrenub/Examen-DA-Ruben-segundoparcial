package es.ulpgc.eite.cleancode.shoppingcart.productdetail;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.shoppingcart.app.ProductDetailToListState;
import es.ulpgc.eite.cleancode.shoppingcart.app.ProductListToDetailState;

public class ProductDetailPresenter implements ProductDetailContract.Presenter {

    public static String TAG = ProductDetailPresenter.class.getSimpleName();

    private WeakReference<ProductDetailContract.View> view;
    private ProductDetailState state;
    private ProductDetailContract.Model model;
    private ProductDetailContract.Router router;

    public ProductDetailPresenter(ProductDetailState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        Log.e(TAG, "onStart()");

        if (state == null) {
            state = new ProductDetailState();
        }

        //TODO: falta implementacion
    }

    @Override
    public void onRestart() {
        Log.e(TAG, "onRestart()");

        //TODO: falta implementacion
        model.onRestartScreen(state.data);
        if(state.data == null) {
            Log.d(TAG, "Es igual al null");
        } else {
            Log.d(TAG, "Es distinto de null");
        }
    }

    @Override
    public void onResume() {
        Log.e(TAG, "onResume()");

        ProductListToDetailState savedState = router.getStateFromPreviousScreen();
        if(savedState != null) {
            Log.d(TAG, "El producto escogido es: " + savedState.product.label);
            model.onDataFromPreviousScreen(savedState.product);
        }

        state.data = model.getStoredData();
        view.get().onDataUpdated(state);
        //TODO: falta implementacion

    }

    @Override
    public void onBackPressed() {
        Log.e(TAG, "onBackPressed()");


        ProductDetailToListState passedState = new ProductDetailToListState();
        passedState.product = state.data;
        passedState.cartsAdded = state.cartAdded;
        router.passStateToPreviousScreen(passedState);
        view.get().navigateToPreviousScreen();
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
    public void onProductButtonTapped() {
        Log.e(TAG, "onProductButtonTapped()");
        model.addProductToCart();
        state.data = model.getStoredData();
        state.cartAdded = model.getCartsAdded();
        view.get().onDataUpdated(state);
        //TODO: falta implementacion
    }

    @Override
    public void injectView(WeakReference<ProductDetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ProductDetailContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(ProductDetailContract.Router router) {
        this.router = router;
    }
}
