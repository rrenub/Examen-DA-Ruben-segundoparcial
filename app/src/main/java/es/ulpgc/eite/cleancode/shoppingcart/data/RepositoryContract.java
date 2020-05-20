package es.ulpgc.eite.cleancode.shoppingcart.data;

import java.util.List;

public interface RepositoryContract {

    List<ProductData> getProductList();

    void updateProductList (ProductData data);
}
