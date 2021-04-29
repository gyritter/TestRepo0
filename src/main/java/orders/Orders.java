package orders;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Orders {
    private Map<String, TreeSet<String>> ordersMap = new HashMap<>();

    public Map<String, TreeSet<String>> getOrdersMap() {
        return ordersMap;
    }

    public void readLines(BufferedReader reader) throws IOException{

        String line;

        while ((line = reader.readLine()) != null) {

            String[] div = line.split(" ");
            String[] div2 = div[1].split(",");
            TreeSet<String> treeset = new TreeSet<>();
            Collections.addAll(treeset, div2);
            ordersMap.put(div[0], treeset);

        }
    }

    public TreeSet<String> getProductListById(String id){
        return ordersMap.get(id);
    }

    public Map<String, Integer> getAllProducts(){
        Map<String, Integer> result = new HashMap<>();
        for(TreeSet <String> s:ordersMap.values()){
            for (String s2:s){
                if(!result.containsKey(s2)){
                    result.put(s2,0);
                }
                result.put(s2, result.get(s2)+1);
            }
        }
        return result;
    }

    public int getProductsByProductName(String name){
        return getAllProducts().get(name);
    }

    public int getProductsNumberById(String id){
            return ordersMap.get(id).size();
    }

    public void writeLines(BufferedWriter writer) {
        Map<String, Integer> towrite = getAllProducts();
        try {
            for (Map.Entry entry:towrite.entrySet()) {

                writer.write(entry.getKey() + "," + entry.getValue()+ "\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }



    public static void main(String[] args) {
        Orders orders = new Orders();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Orders.class.getResourceAsStream("orders.txt")))) {
            orders.readLines(reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        System.out.println(orders.getAllProducts());
       System.out.println(orders.getProductListById("A10"));
      System.out.println(orders.getProductsByProductName("chips"));
       System.out.println(orders.getProductsNumberById("A10"));


        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("orderedProducts.txt"))) {
            orders.writeLines(writer);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }
}

