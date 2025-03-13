package cart;

import db.OrderDetail;
import db.OrderHeader;
import db.OrderHeaderFacade;
import db.Shoes;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<String, Item> map = null;

    public Cart() {
        map = new HashMap<>();
    }

    public void add(Shoes shoes, int quantity, String size) {
        String key = shoes.getId() + "-" + size;
        if (map.containsKey(key)) {
            // If item exists with the same size, increase quantity
            Item item = map.get(key);
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            // Otherwise, create a new Item with size
            Item item = new Item(shoes, quantity, size);
            map.put(key, item);
        }
    }

    public Collection<Item> getItems() {
        return map.values();
    }

    public Double getTotal() {
        double total = 0;
        for (Item item : this.map.values()) {
            total += item.getCost();
        }
        return total;
    }

    public void empty() {
        map.clear();
    }

    public void remove(int id, String size) {
        String key = id + "-" + size;
        map.remove(key);
    }

    public void update(int id, String size, int quantity) {
        String key = id + "-" + size;
        Item item = map.get(key);
        if (item != null) {
            item.setQuantity(quantity);
        }
    }

    public void checkout(int customerId) throws ClassNotFoundException, SQLException {
        Date date = new Date();
        int employeeId = 2;
        String status = "NEW";//NEW->SHIPPING->CANCEL,CLOSE
        OrderHeader oh = new OrderHeader(date, status, customerId, employeeId);

        for (Item item : this.getItems()) {
            OrderDetail od = new OrderDetail(item.getShoes().getId(), item.getQuantity(), item.getShoes().getPrice(), item.getShoes().getDiscount());
            oh.add(od);
        }

        OrderHeaderFacade ohf = new OrderHeaderFacade();
        ohf.insert(oh);
    }
}
