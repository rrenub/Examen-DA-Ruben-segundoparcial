package es.ulpgc.eite.cleancode.shoppingcart.productlist;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.shoppingcart.app.AppMediator;

public class ProductListScreen {

  public static void configure(ProductListContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = AppMediator.getInstance();
    ProductListState state = mediator.getProductListState();

    mediator.setProductListState(new ProductListState());

    ProductListContract.Router router = new ProductListRouter(mediator);
    ProductListContract.Presenter presenter = new ProductListPresenter(state);
    ProductListContract.Model model = new ProductListModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
