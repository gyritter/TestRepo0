package product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product>products= new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public int getNumberOfExpired(){
     List<Product>productsExp= new ArrayList<>();
        for(Product p:products){
            if (p.getExpiry().isBefore(LocalDate.now())){
               productsExp.add(p);
            }
        }
        return productsExp.size();
    }

    public static void main(String[] args) {
        Store store= new Store();
        store.addProduct(new Product("tej",2021,05,31));
        store.addProduct(new Product("csoki",2022,01,31));
        store.addProduct(new Product("tejszín",2021,02,20));
        store.addProduct( new Product("vaj",2021,04,10));
        System.out.println(store.getNumberOfExpired());

    }
}

