package Magazine.AbstractClass;

import Magazine.Constant.ProductCategory;
import Magazine.Interface.Identifiable;
import Magazine.Interface.Purchasable;
import Magazine.Interface.Serializable;

public abstract class AbstractProduct implements Identifiable, Purchasable, Serializable {
    protected String id;
    protected String name;
    protected double price;
    protected ProductCategory category;

    public AbstractProduct(String id, String name, double price, ProductCategory category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String serialize() {
        return id + "," + name + "," + price + "," + category;
    }

    @Override
    public void deserialize(String data) {
        String[] parts = data.split(",");
        this.id = parts[0];
        this.name = parts[1];
        this.price = Double.parseDouble(parts[2]);
        this.category = ProductCategory.valueOf(parts[3]);
    }
}
