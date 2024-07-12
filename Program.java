import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Product> products = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        for (int i = 1;i<=n;i++){
            System.out.printf("Product #%d data:\n",i);
            System.out.print("Common, used or imported (c/u/i)? ");
            char type = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            switch (type){
                case 'c':
                    products.add(new Product(name,price));
                    break;
                case 'u':
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    sc.nextLine();
                    String date = sc.nextLine();
                    products.add(new UsedProduct(name,price,sdf.parse(date)));
                    break;
                case 'i':
                    System.out.print("Customs fee: ");
                    Double customsFee = sc.nextDouble();
                    products.add(new ImportedProduct(name,price,customsFee));
                    break;
                default:
                    System.out.println("Tipo errado, Tente novamente.");
                    break;
            }
        }
        System.out.println("PRICE TAGS:");
        for (Product productList:products) {
            System.out.println(productList.priceTag());
        }

        sc.close();
    }
}
