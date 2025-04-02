package Magazine.Classes;


import Magazine.AbstractClass.AbstractCustomer;

public class Customer extends AbstractCustomer {
    private String email;

    public Customer(String id, String name, String email) {
        super(id, name);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String serialize() {
        return super.serialize() + "," + email;
    }

    @Override
    public void deserialize(String data) {
        super.deserialize(data);
        String[] parts = data.split(",");
        this.email = parts[2];
    }
}
