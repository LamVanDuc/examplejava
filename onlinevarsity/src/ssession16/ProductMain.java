package ssession16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ProductMain {
    public static void main(String[] args) throws IOException {
        List<String> productId = new ArrayList<>();
        List<String> productName = new ArrayList<>();
        List<String> brandName = new ArrayList<>();
        List<String> productPrice = new ArrayList<>();
        String value;
        int size;
        String productdata;

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<Product> list = new ArrayList<Product>();
        do {
            System.out.println("Enter the number of Product[Only name numeric values] ");
             value = input.readLine();
        }while (value.matches("[a-zA-Z]*\\d+.") == false);
        size = Integer.parseInt(value);
        System.out.println("Enter the details below using (, ) seperator in the ord er of ProductID, ProductName , BrandName , ProductPrice");

        for (int i = 0 ; i< size ; i++){
            try {
                productdata = input.readLine();
                String[] data = productdata.split(",");
                productId.add(data[0]);
                productName.add(data[1]);
                brandName.add(data[2]);
                productPrice.add(data[3]);
            }catch (IOException e){
                System.out.println(e.getMessage());
            }

        }
        for (int i = 0; i< productName.size() ; i++){
            list.add(new Product(Integer.parseInt(productId.get(i)),productName.get(i),brandName.get(i),Double.parseDouble(productPrice.get(i))));
            classifiedByPrice(list);
            classifiedByProduct(list);
            classifiedByBrand(list);
            filteringByProductName(input,productName,productId,brandName,productPrice);


        }


    }

    public static void classifiedByPrice(List<Product> list){
        List<Double> priceList;

        priceList = list.stream().map(Product::getProductPrice).collect(Collectors.toList());
        DoubleSummaryStatistics price = priceList.stream().mapToDouble((x)->x).summaryStatistics();
        System.out.println("Maximum price in the List : " + price.getMax());
        System.out.println("Minimum price in the List : " + price.getMin());
        System.out.println("Sum of all products price : " + price.getSum());
        System.out.println("Average of all products prices : " + price.getAverage());
    }
    public static void classifiedByBrand(List<Product>list){
        System.out.println("Display the average of price by Brand");

        Map<String,Double> brandByPriceToAverage = list.stream().collect(groupingBy(Product::getBrandName,averagingDouble(Product::getProductPrice)));
        for (Map.Entry<String,Double> me:brandByPriceToAverage.entrySet()){
            String pp= me.getKey();
            System.out.println(pp);
            System.out.println(me.getValue());
        }
        System.out.println("Display the sum of price by Brand");

        Map<String, Double> brandToSum = list.stream().collect(groupingBy(Product::getProductName , summingDouble(Product::getProductPrice)));
        System.out.println(brandToSum);
    }
    public static void classifiedByProduct(List<Product>list){
        List<String> productname;
        List<Double> productcount;
        productname = list.stream().map(Product::getProductName).collect(Collectors.toList());
        productcount = list.stream().map(Product::getProductPrice).collect(Collectors.toList());

        DoubleSummaryStatistics productCount = productcount.stream().mapToDouble(x->x).summaryStatistics();
        System.out.println("The given Product name are : "+ productname);
        System.out.println("Count of Product : "+productCount.getCount());
        System.out.println("Display the Products names with maximum price");

        Map<String , Optional<Product>> productToHighestPrice = list.stream().collect(groupingBy(Product::getProductName , maxBy(comparing(Product::getProductPrice))));

        for (Map.Entry<String , Optional<Product>>me:productToHighestPrice.entrySet()){
            String pp = me.getKey();
            Optional<Product> p = me.getValue();
            System.out.println(pp);
            System.out.println(p.get().getProductPrice());
        }
    }

    public static void filteringByProductName(BufferedReader input ,List<String> productName , List<String> productId , List<String> brandName , List<String> productPrice) throws IOException{
        boolean flag = false;
        System.out.println("Enter the Product Name you want to search : ");
        String search = input.readLine();
        for (int i = 0 ; i < productName.size(); i ++){
            String curVal = productName.get(i);
            if (curVal.contains(search)){
                System.out.println(productId.get(i) +" " +productName.get(i) +" "+ brandName.get(i) +" "+productPrice.get(i));
                flag = true;
            }
        }
        if (flag = false){
            System.out.println("the product name is not available");
        }
    }

}
