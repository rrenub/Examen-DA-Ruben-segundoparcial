package es.ulpgc.eite.cleancode.shoppingcart.orderlist;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.shoppingcart.app.AppMediator;
import es.ulpgc.eite.cleancode.shoppingcart.data.ProductRepository;
import es.ulpgc.eite.cleancode.shoppingcart.data.RepositoryContract;

public class OrderListScreen {

  public static void configure(OrderListContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = AppMediator.getInstance();
    OrderListState state = mediator.getOrderListState();
    //RepositoryContract repository = ProductRepository.getInstance();

    OrderListContract.Router router = new OrderListRouter(mediator);
    OrderListContract.Presenter presenter = new OrderListPresenter(state);
    OrderListContract.Model model = new OrderListModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
