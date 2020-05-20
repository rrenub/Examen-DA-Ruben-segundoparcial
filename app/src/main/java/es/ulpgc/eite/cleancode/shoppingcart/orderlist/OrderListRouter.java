package es.ulpgc.eite.cleancode.shoppingcart.orderlist;

import es.ulpgc.eite.cleancode.shoppingcart.app.AppMediator;
import es.ulpgc.eite.cleancode.shoppingcart.app.OrderListToDetailState;
import es.ulpgc.eite.cleancode.shoppingcart.app.OrderToProductListState;
import es.ulpgc.eite.cleancode.shoppingcart.app.ProductToOrderListState;

public class OrderListRouter implements OrderListContract.Router {

  public static String TAG = OrderListRouter.class.getSimpleName();

  private AppMediator mediator;

  public OrderListRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public ProductToOrderListState getStateFromNextScreen() {
    return mediator.getProductToOrderListState();
  }

  @Override
  public void passStateToNextScreen(OrderToProductListState state) {
    mediator.setOrderToProductListState(state);
  }

  @Override
  public void passStateToDetailScreen(OrderListToDetailState state) {
    //TODO: falta implementacion
  }

}
