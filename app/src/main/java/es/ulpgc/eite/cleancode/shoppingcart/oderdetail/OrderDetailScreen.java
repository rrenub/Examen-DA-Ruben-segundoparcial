package es.ulpgc.eite.cleancode.shoppingcart.oderdetail;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.shoppingcart.app.AppMediator;

public class OrderDetailScreen {

  public static void configure(OrderDetailContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = AppMediator.getInstance();
    OrderDetailState state = mediator.getOrderDetailState();

    OrderDetailContract.Router router = new OrderDetailRouter(mediator);
    OrderDetailContract.Presenter presenter = new OrderDetailPresenter(state);
    OrderDetailContract.Model model = new OrderDetailModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
