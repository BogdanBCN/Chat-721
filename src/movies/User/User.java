package movies.User;

import movies.Order;

import java.util.List;

public class User {
    private String firsName;
    private String lastName;
    private List<Order> orders;

    public User(String firsName, String lastName, List<Order> orders) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.orders = orders;
    }

    public double calculatePriceForOrder(int position) {
        Order o = orders.get(position);
        return o.calculateTotalPrice();
    }

    public double calculateOrderPriceForAllOrders() {
        double sum = 0;
        for (Order o : orders) {
            sum += o.calculateTotalPrice();
        }
        return sum;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
