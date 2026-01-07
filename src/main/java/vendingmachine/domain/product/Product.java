package vendingmachine.domain.product;

public class Product {
    private final ProductName name;
    private final ProductPrice price;
    private Stock stock;

    public Product(String name, int price, int stockQuantity) {
        this.name = new ProductName(name);
        this.price = new ProductPrice(price);
        this.stock = new Stock(stockQuantity);
    }

    public String getName() {
        return name.value();
    }

    public int getPrice() {
        return price.value();
    }

    public int getStockQuantity() {
        return stock.value();
    }
}
