package es.ulpgc.eite.cleancode.shoppingcart.data;

import java.util.ArrayList;

public class ProductStore {

  private static ProductStore DATASTORE = new ProductStore();

  private String[] letters = {
      "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
      "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

  public ArrayList<ProductData> datasource;

  public static ProductStore instance() {
    if(DATASTORE == null) {
      DATASTORE = new ProductStore();
    }

    return DATASTORE;
  }

  private ProductStore() {
    this.datasource = new ArrayList<>();

    for (int index = 0; index < letters.length; index++) {
      datasource.add(new ProductData(letters[index]));
    }
  }

  public static void reinstance() { // for testing
    DATASTORE = new ProductStore();
  }
}
