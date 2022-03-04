
import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable
{
    //private static final long serialVersionUID = 1L;
    private String name;
    private double amountSpent;
    private ArrayList<Product> purchaseHistory;
    private ArrayList<Integer> numberOfEachProduct;

    public Customer(String name)
    {
        this.name = name;
        amountSpent = 0;
        purchaseHistory = new ArrayList<Product>();
        numberOfEachProduct = new ArrayList<Integer>();
    }

    public String toString()
    {
        return String.format("%s who has spent $%s",name,amountSpent);
    }

    public static void main(String[]args)
    {
        Customer manny = new Customer("Manny");
        System.out.println(manny);

    }

    public void printPurchaseHistory()
    {
        for(int i = 0; i < purchaseHistory.size();i++)
        {
            System.out.println(numberOfEachProduct.get(i)+" X "+purchaseHistory.get(i));
        }

    }

    public void addToPurchaseHistory(Product product, int amount)
    {
        if(!contains(product))
        {
            purchaseHistory.add(product);
            numberOfEachProduct.add(amount);
        }

        else if(contains(product))
        {
            for(int i =0; i < purchaseHistory.size();i++)
            {
                if(purchaseHistory.get(i).toString().equals(product.toString()))
                {
                    numberOfEachProduct.set(i, numberOfEachProduct.get(i)+amount);
                }
            }
        }

    }

    public boolean contains(Product product)
    {
        for(Product i : purchaseHistory)
        {
            if(i.toString().equals(product.toString()))
            {
                return true;
            }
        }
        return false;
    }

    public String getName()
    {
        return name;
    }

    public double getAmountSpent()
    {
        return amountSpent;
    }

    public void setAmountSpent(double amountSpent)
    {
        this.amountSpent = amountSpent;
    }
}

