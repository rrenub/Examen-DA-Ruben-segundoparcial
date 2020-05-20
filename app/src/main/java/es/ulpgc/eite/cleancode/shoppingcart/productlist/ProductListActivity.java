package es.ulpgc.eite.cleancode.shoppingcart.productlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Comparator;

import es.ulpgc.eite.cleancode.shoppingcart.R;
import es.ulpgc.eite.cleancode.shoppingcart.data.ProductData;
import es.ulpgc.eite.cleancode.shoppingcart.productdetail.ProductDetailActivity;

public class ProductListActivity
    extends AppCompatActivity implements ProductListContract.View {

  public static String TAG = ProductListActivity.class.getSimpleName();

  private ProductListContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_product_list);
    getSupportActionBar().setTitle(R.string.product_list_title);

    // do the setup
    ProductListScreen.configure(this);

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

  @Override
  public void onDataUpdated(ProductListViewModel viewModel) {
    //Log.e(TAG, "onDataUpdated()");

    viewModel.datasource.sort(new Comparator<ProductData>() {

      @Override
      public int compare(ProductData d1, ProductData d2) {
        return d1.label.compareTo(d2.label);
      }
    });

    // deal with the datasource
    ((ListView) findViewById(R.id.productList)).setAdapter(new ProductListAdapter(
            this, viewModel.datasource, new View.OnClickListener() {

          @Override
          public void onClick(View view) {
            ProductData data = (ProductData) view.getTag();
            presenter.onListTapped(data);
          }
        })
    );
  }

  @Override
  public void navigateToNextScreen() {
    Intent intent = new Intent(this, ProductDetailActivity.class);
    startActivity(intent);
  }

  @Override
  public void injectPresenter(ProductListContract.Presenter presenter) {
    this.presenter = presenter;
  }
}
