package es.ulpgc.eite.cleancode.shoppingcart.productdetail;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.shoppingcart.app.AppMediator;

public class ProductDetailScreen {

  public static void configure(ProductDetailContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = AppMediator.getInstance();
    ProductDetailState state = mediator.getProductDetailState();

    ProductDetailContract.Router router = new ProductDetailRouter(mediator);
    ProductDetailContract.Presenter presenter = new ProductDetailPresenter(state);
    ProductDetailContract.Model model = new ProductDetailModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
