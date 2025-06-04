package ArrayList응용예제;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Order {
    List<Product> products = new ArrayList<>();
    BigDecimal total = BigDecimal.ZERO;

    public Order() {}

    public void addItem(Product product) {
        products.add(product);
        total = total.add(product.getPrice());
    }

    public Product getItem(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public void removeItem(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                total = total.subtract(product.getPrice());
                products.remove(product);
            }
        }
    }

    public BigDecimal calculateFinalPrice(BigDecimal taxRate) {
        return (total.add((total.multiply(taxRate)))).setScale(2, RoundingMode.HALF_UP);
    }

    public List<Product> getProduct() {
        return products;
    }
}
