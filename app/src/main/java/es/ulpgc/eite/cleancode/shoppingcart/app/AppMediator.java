package es.ulpgc.eite.cleancode.shoppingcart.app;

import es.ulpgc.eite.cleancode.shoppingcart.oderdetail.OrderDetailState;
import es.ulpgc.eite.cleancode.shoppingcart.orderlist.OrderListState;
import es.ulpgc.eite.cleancode.shoppingcart.productdetail.ProductDetailState;
import es.ulpgc.eite.cleancode.shoppingcart.productlist.ProductListState;

public class AppMediator  {

    private static AppMediator instance;

    private OrderListState orderListState;
    private ProductDetailState productDetailState;
    private ProductListState productListState;
    private OrderDetailState orderDetailState;

    private OrderToProductListState orderToProductListState;
    private ProductListToDetailState productListToDetailState;
    private ProductDetailToListState productDetailToListState;

    private AppMediator() {
        orderListState= new OrderListState();
        productDetailState= new ProductDetailState();
        productListState= new ProductListState();
        orderDetailState= new OrderDetailState();
    }

    public static void resetInstance() {
        AppMediator.instance = null;
    }

    public static AppMediator getInstance() {
        if(instance==null) {
            instance = new AppMediator();
        }

        return instance;
    }


    public void setProductListState(ProductListState state) {
        this.productListState = state;
    }

    public OrderListState getOrderListState() {
        return orderListState;
    }

    public OrderDetailState getOrderDetailState() {
        return orderDetailState;
    }

    public ProductDetailState getProductDetailState() {
        return productDetailState;
    }

    public ProductListState getProductListState() {
        return productListState;
    }


    public void setOrderToProductListState(OrderToProductListState state) {
        orderToProductListState = state;
    }

    public OrderToProductListState getOrderToProductListState() {
        OrderToProductListState temp = orderToProductListState;
        orderToProductListState = null;
        return temp;
    }

    public void setProductListToDetailtState(ProductListToDetailState state) {
        productListToDetailState = state;
    }

    public ProductListToDetailState getProductListToDetailState() {
        ProductListToDetailState temp = productListToDetailState;
        productListToDetailState = null;
        return temp;
    }

    public ProductDetailToListState getProductDetailToListState() {
        ProductDetailToListState temp = productDetailToListState;
        productDetailState = null;
        return temp;
    }

    public void setProductDetailToListState(ProductDetailToListState productDetailToListState) {
        this.productDetailToListState = productDetailToListState;
    }
}
