package es.ulpgc.eite.cleancode.shoppingcart.oderdetail;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Comparator;

import es.ulpgc.eite.cleancode.shoppingcart.R;
import es.ulpgc.eite.cleancode.shoppingcart.data.OrderData;
import es.ulpgc.eite.cleancode.shoppingcart.data.ProductData;

public class OrderDetailActivity
    extends AppCompatActivity implements OrderDetailContract.View {

  public static String TAG = OrderDetailActivity.class.getSimpleName();

  private OrderDetailContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_order_detail);
    getSupportActionBar().setTitle(R.string.order_detail_title);

    // do the setup
    OrderDetailScreen.configure(this);

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
  public void onDataUpdated(OrderDetailViewModel viewModel) {
    //Log.e(TAG, "onDataUpdated()");

    OrderData data = viewModel.data;
    data.content.sort(new Comparator<ProductData>() {

      @Override
      public int compare(ProductData d1, ProductData d2) {
        return d1.label.compareTo(d2.label);
      }
    });

    // deal with the datasource
    ((ListView) findViewById(R.id.orderDetail)).setAdapter(new OrderDetailAdapter(
            this, data.content, new View.OnClickListener() {

          @Override
          public void onClick(View view) {
            ProductData data = (ProductData) view.getTag();
            presenter.onListTapped(data);
          }
        })
    );
  }

  @Override
  public void injectPresenter(OrderDetailContract.Presenter presenter) {
    this.presenter = presenter;
  }
}
