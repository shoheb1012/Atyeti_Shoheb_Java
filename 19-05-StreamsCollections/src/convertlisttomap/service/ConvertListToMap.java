package src.convertlisttomap.service;

import model.Product;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConvertListToMap {

    public static Map<Integer,Product> ConversionOfListToMap(List<Product> productList) {

       return productList.stream().collect(Collectors.toMap( x->
                x.getProductId(),
                Function.identity(),
               (existing,replacement)->existing  //mergeFunction
        ));

    }
    //.
}
