package es.ulpgc.eite.cleancode.shoppingcart.productlist;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.shoppingcart.app.OrderToProductListState;
import es.ulpgc.eite.cleancode.shoppingcart.app.ProductListToDetailState;
import es.ulpgc.eite.cleancode.shoppingcart.data.ProductData;

public class ProductListPresenter implements ProductListContract.Presenter {

    public static String TAG = ProductListPresenter.class.getSimpleName();

    private WeakReference<ProductListContract.View> view;
    private ProductListState state;
    private ProductListContract.Model model;
    private ProductListContract.Router router;

    public ProductListPresenter(ProductListState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        Log.e(TAG, "onStart()");

        if (state == null) {
            state = new ProductListState();
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

        OrderToProductListState savedState = router.getStateFromPreviousScreen();
        if(savedState != null) {
            Log.d(TAG, "Es el pedido: " + savedState.orderData.label);
        }

        state.datasource = model.getStoredDatasource();
        view.get().onDataUpdated(state);
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
        ProductListToDetailState passedState = new ProductListToDetailState();
        passedState.product = data;
        router.passStateToNextScreen(passedState);
        view.get().navigateToNextScreen();
        //TODO: falta implementacion
    }

    @Override
    public void injectView(WeakReference<ProductListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ProductListContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(ProductListContract.Router router) {
        this.router = router;
    }
}
