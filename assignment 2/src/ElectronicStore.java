import java.util.Scanner;

public class ElectronicStore
{
    private final int MAX_PRODUCTS = 10;
    private String name;
    private double revenue;
    private Product products[] = new Product[MAX_PRODUCTS];

    public ElectronicStore(String name)
    {
        this.name = name;
        revenue = 0;
    }

    public String getName()
    {
        return name;
    }

    public boolean addProduct(Product p)
    {
        for(int i = 0; i< products.length;i++)
        {
            if(products[i] == null)
            {
                products[i] = p;
                return true;
            }
        }

        return false;
    }

    public boolean sellProducts()
    {
        printStock();

        boolean prompt = true;

        while(prompt)
        {
            Scanner scan = new Scanner(System.in);

            int productIndex = 0;
            int amountOfProduct = 0;

            System.out.println("Please enter product index:");
            productIndex = scan.nextInt();

            System.out.println("Please enter amount of product");
            amountOfProduct = scan.nextInt();

            if(productIndex < products.length&& productIndex >=0 && amountOfProduct > 0)
            {
                Product p  = products[productIndex];
                revenue += p.sellUnits(amountOfProduct);

                prompt = false;
                return true;
            }
            return false;
        }
        return false;

    }

    public boolean sellProducts(int item, int amount)
    {
        if(item < products.length && amount > 0)
        {
            Product p = products[item];

            if(p != null)
            {
                revenue += p.sellUnits(amount);
                System.out.println(revenue);
                return true;

            }

        }

        return false;
    }

    public double getRevenue()
    {
        return revenue;
    }

    public void printStock()
    {
        for(int i = 0; i < products.length;i++)
        {
            if(products[i] != null)
            {
                System.out.println(i+"."+products[i]);
            }
        }
    }

}
