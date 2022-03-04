//Class representing an electronic store
//Has an array of products that represent the items the store can sell
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class ElectronicStore implements Serializable
{
  //private static final long serialVersionUID = 1L;
  private String name;
  private ArrayList<Product> stock;
  private ArrayList<Customer> customers;
  private double revenue;
  
  public ElectronicStore(String initName)
  {
    revenue = 0.0;
    name = initName;
    stock = new ArrayList<Product>();
    customers = new ArrayList<Customer>();
  }

  public void addProduct(Product newProduct)
  {
    if(!containsProduct(newProduct))
    {
      stock.add(newProduct);
    }
  }

  public boolean registerCustomer(Customer c)
  {
    if(!containsCustomer(c))
    {
      customers.add(c);
      return true;
    }
    return false;
  }

  public boolean addStock(Product p, int amount)
  {
    if(stock.contains(p))
    {
      p.setStockQuantity(p.getStockQuantity()+amount);
      return true;
    }

    return false;
  }

  public ArrayList<Product> searchProducts(String x)
  {
    ArrayList<Product> matchingProducts = new ArrayList<Product>();

    for(int i = 0; i < stock.size();i++)
    {
      if(stock.get(i).toString().toLowerCase().contains(x.toLowerCase()))
      {
        matchingProducts.add(stock.get(i));
      }
    }

    return matchingProducts;
  }

  public ArrayList<Product> searchProducts(String x, double minPrice, double maxPrice)
  {
    ArrayList<Product> matchingProducts = new ArrayList<Product>();
    for(int i = 0; i < searchProducts(x).size();i++)
    {
      if(searchProducts(x).get(i).getPrice() >= minPrice && searchProducts(x).get(i).getPrice() <= maxPrice)
      {
        matchingProducts.add(searchProducts(x).get(i));
      }

      else if (minPrice > maxPrice)
      {
        if(searchProducts(x).get(i).getPrice() >= minPrice)
        {
          matchingProducts.add(searchProducts(x).get(i));
        }

        else if(maxPrice == minPrice)
        {
          matchingProducts.add(searchProducts(x).get(i));
        }
      }
    }

    return matchingProducts;
  }

  public boolean sellProduct(Product p, Customer c, int amount)
  {
    if(stock.contains(p) && customers.contains(c) && amount <= p.getStockQuantity() && amount > 0)
    {
      c.setAmountSpent(c.getAmountSpent()+p.sellUnits(amount));
      c.addToPurchaseHistory(p,amount);
      return true;
    }

    return false;
  }

  public ArrayList<Customer> getTopXCustomers(int x)
  {
    ArrayList<Customer> sortedCustomers = new ArrayList<Customer>();

    if(x <= 0)
    {
      return sortedCustomers;
    }

    sortedCustomers.addAll(customers);

    Collections.sort(sortedCustomers, new Comparator<Customer>()
    {

      public int compare(Customer c1, Customer c2)
      {
        if(c1.getAmountSpent() > c2.getAmountSpent())
        {
          return -1;
        }

        else
        {
          return 1;
        }

      }
    });

    if(x > customers.size())
    {
      return sortedCustomers;
    }

    ArrayList<Customer> topYCustomers = new ArrayList<Customer>();
    for(int i = 0; i < x; i++)
    {
      topYCustomers.add(sortedCustomers.get(i));
    }

    return topYCustomers;
  }

  public boolean containsCustomer(Customer customer)
  {
    for(Customer i : customers)
    {
      if(i.getName().equals(customer.getName()))
      {
        return true;
      }
    }
    return false;
  }

  public boolean containsProduct(Product product)
  {
    for(Product i : stock)
    {
      if(i.toString().equals(product.toString()))
      {
        return true;
      }
    }
    return false;
  }

  public ArrayList<Customer> getCustomers()
  {
    return customers;
  }

  public String getName()
  {
    return name;
  }

  public boolean saveToFile(String fileName)
  {
    try
    {
      FileOutputStream fileOutput = new FileOutputStream(fileName);
      ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
      objectOutput.writeObject(this);
      objectOutput.close();
      return true;

    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }

    return false;
  }

  public static ElectronicStore loadFromFile(String fileName)
  {
    try
    {
      FileInputStream fileInput = new FileInputStream(fileName);
      ObjectInputStream objectInput = new ObjectInputStream(fileInput);

      ElectronicStore obj = (ElectronicStore) objectInput.readObject();

      objectInput.close();

      return obj;

    }
    catch (Exception ex)
    {
      return null;
    }

  }


} 