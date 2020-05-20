package es.ulpgc.eite.cleancode.shoppingcart.data;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements RepositoryContract{

    private static ProductRepository INSTANCE;

    private final String LETTER_LIST = "ABCDEFGHI";
    private List<ProductData> products;

    private ProductRepository() {
        products = new ArrayList<>();
        for(int i=0; i < LETTER_LIST.length(); i++){
            String currentLabel = String.valueOf(LETTER_LIST.charAt(i));
            products.add(new ProductData(currentLabel));
            //Log.d(TAG,currentLabel + datasource.get(i).content + " " + datasource.get(i).value);
        }
    }

    public static ProductRepository getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ProductRepository();
        }
        return INSTANCE;
    }

    @Override
    public List<ProductData> getProductList() {
        return products;
    }

    @Override
    public void updateProductList(ProductData data) {
        //TODO Implementar
    }
}
