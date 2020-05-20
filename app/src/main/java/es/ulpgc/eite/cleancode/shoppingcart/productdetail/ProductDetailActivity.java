package es.ulpgc.eite.cleancode.shoppingcart.productdetail;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.cleancode.shoppingcart.R;
import es.ulpgc.eite.cleancode.shoppingcart.data.ProductData;

public class ProductDetailActivity
    extends AppCompatActivity implements ProductDetailContract.View {

  public static String TAG = ProductDetailActivity.class.getSimpleName();

  private ProductDetailContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_product_detail);
    getSupportActionBar().setTitle(R.string.product_detail_title);

    // do the setup
    ProductDetailScreen.configure(this);

    if (savedInstanceState == null) {
      presenter.onStart();

    } else {
      presenter.onRestart();
    }
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.onResume();
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();

    presenter.onBackPressed();
  }

  @Override
  protected void onPause() {
    super.onPause();

    presenter.onPause();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    presenter.onDestroy();
  }


  public void onProductButtonTapped(View view) {
    presenter.onProductButtonTapped();
  }

  @Override
  public void onDataUpdated(ProductDetailViewModel viewModel) {
    //Log.e(TAG, "onDataUpdated()");

    ProductData data = viewModel.data;

    // deal with the data
    ((TextView) findViewById(R.id.detailTitle)).setText(data.label());
    ((TextView) findViewById(R.id.detailSubtitle)).setText(data.details());
  }

  @Override
  public void injectPresenter(ProductDetailContract.Presenter presenter) {
    this.presenter = presenter;
  }

}
