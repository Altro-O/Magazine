package Magazine;

import Magazine.AbstractClass.AbstractOrder;
import Magazine.Classes.Customer;
import Magazine.Classes.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class OrderManager<T extends AbstractOrder> {
    private List<T> orders;

    public OrderManager() {
        orders = new ArrayList<>();
    }

    public void addOrder(T order) {
        orders.add(order);
    }

    public List<T> findOrdersByCustomer(String customerId) {
        return orders.stream()
                .filter(order -> order.getCustomer().getId().equals(customerId))
                .collect(Collectors.toList());
    }

    public void saveOrdersToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (T order : orders) {
                writer.write(order.serialize());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadOrdersFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                T order = (T) new Order("", new Customer("", "", ""));
                order.deserialize(line);
                addOrder(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

