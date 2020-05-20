package es.ulpgc.eite.cleancode.shoppingcart.orderlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Comparator;

import es.ulpgc.eite.cleancode.shoppingcart.R;
import es.ulpgc.eite.cleancode.shoppingcart.app.AppMediator;
import es.ulpgc.eite.cleancode.shoppingcart.data.OrderData;
import es.ulpgc.eite.cleancode.shoppingcart.oderdetail.OrderDetailActivity;
import es.ulpgc.eite.cleancode.shoppingcart.productlist.ProductListActivity;

public class OrderListActivity
    extends AppCompatActivity implements OrderListContract.View {

  public static String TAG = OrderListActivity.class.getSimpleName();

  private OrderListContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_order_list);
    getSupportActionBar().setTitle(R.string.order_list_title);

    if (savedInstanceState == null) {
      AppMediator.resetInstance();
    }

    // do the setup
    OrderListScreen.configure(this);

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


  public void onOrderButtonTapped(View view) {
    presenter.onButtonTapped();
  }

  @Override
  public void onDataUpdated(OrderListViewModel viewModel) {
    //Log.e(TAG, "onDataUpdated()");

    viewModel.datasource.sort(new Comparator<OrderData>() {

      @Override
      public int compare(OrderData d1, OrderData d2) {
        return d1.label.compareTo(d2.label);
      }
    });

    // deal with the datasource
    ((ListView) findViewById(R.id.orderList)).setAdapter(new OrderListAdapter(
            this, viewModel.datasource, new View.OnClickListener() {

          @Override
          public void onClick(View view) {
            OrderData data = (OrderData) view.getTag();
            presenter.onListTapped(data);
          }
        })
    );
  }

  @Override
  public void navigateToNextScreen() {
    Intent intent = new Intent(this, ProductListActivity.class);
    startActivity(intent);
  }

  @Override
  public void navigateToDetailScreen() {
    Intent intent = new Intent(this, OrderDetailActivity.class);
    startActivity(intent);
  }

  @Override
  public void injectPresenter(OrderListContract.Presenter presenter) {
    this.presenter = presenter;
  }

}
