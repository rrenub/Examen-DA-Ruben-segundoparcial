package es.ulpgc.eite.cleancode.shoppingcart.orderlist;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.shoppingcart.app.OrderListToDetailState;
import es.ulpgc.eite.cleancode.shoppingcart.app.OrderToProductListState;
import es.ulpgc.eite.cleancode.shoppingcart.app.ProductToOrderListState;
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

        model.onRestartScreen(state.datasource);
        model.setCurrentOrder(state.currentOrder);
    }

    @Override
    public void onResume() {
        Log.e(TAG, "onResume()");
        state.datasource = model.getStoredOrderList();
        state.currentOrder = model.getCurrentOrder();
        view.get().onDataUpdated(state);

        ProductToOrderListState savedState = router.getStateFromNextScreen();
        if(savedState != null) {
            model.updateOrder(savedState.order);
            Log.d(TAG, "El order es: " + savedState.order.content.size() +
                                " y el primero es " + savedState.order.content.get(0).label + " que tiene " + savedState.order.content.get(0).value);
        }

        state.datasource = model.getStoredOrderList();
        view.get().onDataUpdated(state);
    }

    @Override
    public void onBackPressed() {
        Log.e(TAG, "onBackPressed()");

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
        model.addOrder();
        state.datasource = model.getStoredOrderList();
        state.currentOrder = model.getCurrentOrder();

        OrderToProductListState passedState = new OrderToProductListState();
        passedState.orderData = model.getStoredNewData();
        router.passStateToNextScreen(passedState);
        view.get().navigateToNextScreen();
    }


    @Override
    public void onListTapped(OrderData data) {
        Log.e(TAG, "onListTapped()");

        OrderListToDetailState passedState = new OrderListToDetailState();
        passedState.orderData = model.getStoredNewData();
        router.passStateToDetailScreen(passedState);
        view.get().navigateToDetailScreen();
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
