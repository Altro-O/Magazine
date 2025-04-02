package Magazine.AbstractClass;


import Magazine.Classes.Customer;
import Magazine.Classes.Product;
import Magazine.Constant.OrderStatus;
import Magazine.Constant.ProductCategory;
import Magazine.Interface.Orderable;
import Magazine.Interface.Serializable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public abstract class AbstractOrder implements Orderable, Serializable {
    private String id;
    private AbstractCustomer customer;
    private List<AbstractProduct> products;
    private OrderStatus status;
    private LocalDate orderDate;

    public AbstractOrder(String id, AbstractCustomer customer) {
        this.id = id;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.status = OrderStatus.PENDING;
        this.orderDate = LocalDate.now();
    }

    public void addProduct(AbstractProduct product) {
        products.add(product);
    }

    public double getTotalPrice() {
        return products.stream().mapToDouble(AbstractProduct::getPrice).sum();
    }

    public AbstractCustomer getCustomer() {
        return customer;
    }

    @Override
    public void processOrder() {
        System.out.println("Processing order ID: " + id + " for customer: " + customer.getName());
        System.out.println("Products in the order:");
        products.forEach(product -> System.out.println("- " + product.getName() + ": $" + product.getPrice()));
        System.out.println("Total price: $" + getTotalPrice());
        System.out.println("Order Status: " + status);
        System.out.println("Order Date: " + orderDate);
    }

    @Override
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(",").append(customer.serialize()).append(",").append(status).append(",").append(orderDate).append(",");
        for (AbstractProduct product : products) {
            sb.append(product.serialize()).append(";");
        }
        return sb.toString();
    }

    @Override
    public void deserialize(String data) {
        String[] parts = data.split(",", 4);
        this.id = parts[0];
        this.customer = new Customer("", "").deserialize(parts[1]);
        this.status = OrderStatus.valueOf(parts[2]);
        this.orderDate = LocalDate.parse(parts[3]);
        String[] productData = parts[4].split(";");
        for (String pd : productData) {
            if (!pd.isEmpty()) {
                AbstractProduct product = new Product("", "", 0, ProductCategory.ELECTRONICS);
                product.deserialize(pd);
                addProduct(product);
            }
        }
    }
}
