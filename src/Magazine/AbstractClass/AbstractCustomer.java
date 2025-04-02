package Magazine.AbstractClass;

import Magazine.Interface.Identifiable;
import Magazine.Interface.Serializable;

public abstract class AbstractCustomer implements Identifiable, Serializable {
    private String id;
    private String name;

    public AbstractCustomer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String serialize() {
        return id + "," + name;
    }

    @Override
    public void deserialize(String data) {
        String[] parts = data.split(",");
        this.id = parts[0];
        this.name = parts[1];
    }
}
