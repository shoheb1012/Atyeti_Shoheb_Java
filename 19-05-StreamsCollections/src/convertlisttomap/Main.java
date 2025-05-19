package src.convertlisttomap;

import convertlisttomap.model.Product;
import convertlisttomap.service.ConvertListToMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();

        productList.add(new Product(1,"fan",4,630));
        productList.add(new Product(2,"cable",12,230));
        productList.add(new Product(3,"charger",14,1230));
        productList.add(new Product(4,"mobile",24,3230));
        productList.add(new Product(5,"laptop",34,5230));
        productList.add(new Product(6,"tv",44,1230));
        /*
           if we added another duplicate entry then it will throw an exception map not allow duplicate entry
           "Exception in thread "main" java.lang.IllegalStateException: Duplicate key 6 (attempted merging values productId=6, productName='tv', productQty=44, productPrice=1230.0 and productId=6, productName='tv', productQty=44, productPrice=1230.0)
          " we need to make changes in logic
         */
        productList.add(new Product(6,"tv",44,1230));

        Map<Integer, Product> productMap = ConvertListToMap.ConversionOfListToMap(productList);

        Set<Map.Entry<Integer, Product>> entries = productMap.entrySet();

        for(Map.Entry<Integer, Product> entry : entries)
        {
            System.out.println("Key:"+entry.getKey()+" "+"Value:"+entry.getValue());

        }

    }
}
