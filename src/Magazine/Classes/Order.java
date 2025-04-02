package Magazine.Classes;

import Magazine.AbstractClass.AbstractCustomer;
import Magazine.AbstractClass.AbstractOrder;

public class Order extends AbstractOrder {

    public Order(String id, AbstractCustomer customer) {
        super(id, customer);
    }
        @Override
        public void processOrder() {
            super.processOrder();
        }
    }
