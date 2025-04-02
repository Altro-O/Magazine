package Magazine.Classes;

import Magazine.AbstractClass.AbstractProduct;
import Magazine.Constant.ProductCategory;


public class Product extends AbstractProduct {
    public Product(String id, String name, double price, ProductCategory category) {
        super(id, name, price, category);
    }
}
