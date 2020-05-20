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
    //TODO: falta implementacion
    return null;
  }

  @Override
  public void passStateToNextScreen(OrderToProductListState state) {
    //TODO: falta implementacion
  }

  @Override
  public void passStateToDetailScreen(OrderListToDetailState state) {
    //TODO: falta implementacion
  }

}
