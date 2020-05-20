package es.ulpgc.eite.cleancode.shoppingcart.orderlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import es.ulpgc.eite.cleancode.shoppingcart.R;
import es.ulpgc.eite.cleancode.shoppingcart.data.OrderData;


public class OrderListAdapter extends ArrayAdapter<OrderData> {

  private final List<OrderData> itemList;
  private final View.OnClickListener clickListener;


  public OrderListAdapter(
      Context ctx, List<OrderData> items, View.OnClickListener listener) {

    super(ctx, 0, items);

    itemList = items;
    clickListener = listener;
  }


  @Override
  public int getCount() {
    return itemList.size();
  }

  @Override
  public OrderData getItem(int position) {
    return itemList.get(position);
  }


  @Override
  public long getItemId(int position) {
    return getItem(position).id;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View itemView = convertView;

    if (itemView == null) {
      itemView = LayoutInflater
          .from(parent.getContext())
          .inflate(R.layout.content_cell_list, parent, false);
    }

    itemView.setTag(itemList.get(position));
    itemView.setOnClickListener(clickListener);

    final TextView titleView = itemView.findViewById(R.id.cellTitle);
    final TextView subtitleView = itemView.findViewById(R.id.cellSubtitle);
    OrderData data = itemList.get(position);
    titleView.setText(String.valueOf(data.label()));
    subtitleView.setText(data.content());

    return itemView;
  }


}
