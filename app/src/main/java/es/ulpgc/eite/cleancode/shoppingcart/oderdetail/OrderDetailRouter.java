package es.ulpgc.eite.cleancode.shoppingcart.oderdetail;

import es.ulpgc.eite.cleancode.shoppingcart.app.AppMediator;
import es.ulpgc.eite.cleancode.shoppingcart.app.OrderListToDetailState;

public class OrderDetailRouter implements OrderDetailContract.Router {

  public static String TAG = OrderDetailRouter.class.getSimpleName();

  private AppMediator mediator;

  public OrderDetailRouter(AppMediator mediator) {
    this.mediator = mediator;
  }


  @Override
  public OrderListToDetailState getStateFromPreviousScreen() {
    //TODO: falta implementacion
    return null;
  }

}
