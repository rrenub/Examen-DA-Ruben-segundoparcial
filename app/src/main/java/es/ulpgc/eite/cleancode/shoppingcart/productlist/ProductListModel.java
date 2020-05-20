package es.ulpgc.eite.cleancode.shoppingcart.productlist;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.shoppingcart.data.OrderData;
import es.ulpgc.eite.cleancode.shoppingcart.data.ProductData;
import es.ulpgc.eite.cleancode.shoppingcart.data.RepositoryContract;

public class ProductListModel implements ProductListContract.Model {

    public static String TAG = ProductListModel.class.getSimpleName();
    private final String LETTER_LIST = "ABCDE";

    private OrderData data;
    private List<ProductData> datasource;

    public ProductListModel(RepositoryContract repository) {
        //TODO: falta implementacion
        datasource = repository.getProductList();
    }


    @Override
    public List<ProductData> getStoredDatasource() {
        // Log.e(TAG, "getStoredDatasource()");
        return datasource;
    }

    @Override
    public OrderData getStoredData() {
        // Log.e(TAG, "getStoredData()");
        return data;
    }

    @Override
    public void onRestartScreen(List<ProductData> datasource, OrderData data) {
        // Log.e(TAG, "onRestartScreen()");

        //TODO: falta implementacion
    }


    @Override
    public void onDataFromNextScreen(ProductData data) {
        Log.e(TAG, "onDataFromNextScreen()");

        //TODO: falta implementacion
    }

    @Override
    public void onDataFromPreviousScreen(OrderData data) {
        // Log.e(TAG, "onDataFromPreviousScreen()");
        this.data=data;
    }
}
