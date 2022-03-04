//Class representing an electronic store
//Has an array of products that represent the items the store can sell
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ElectronicStore
{
  public final int MAX_PRODUCTS = 10;
  private String name;
  private ArrayList<Product> stock,cart,popularItems,allItems;
  private double revenue;
  private int sales;
  
  public ElectronicStore(String initName)
  {
    revenue = 0.0;
    sales = 0;
    name = initName;
    stock = new ArrayList<Product>(MAX_PRODUCTS);
    cart = new ArrayList<Product>(MAX_PRODUCTS);
    popularItems = new ArrayList<Product>();
    allItems = new ArrayList<Product>();

  }
  
  public String getName(){
    return name;
  }

  public void addProduct(Product newProduct)
  {
    stock.add(newProduct);
    allItems.add(newProduct);
  }

  public void addToCart(Product product)
  {
    if(product.getAmountInCart() == 0)
    {
      cart.add(product);
      product.setAmountInCart(product.getAmountInCart()+1);
      product.setStockQuantity(product.getStockQuantity()-1);

    }
    else if(product.getAmountInCart() > 0 && product.getAmountInCart() < 10)
    {
      product.setAmountInCart(product.getAmountInCart()+1);
      product.setStockQuantity(product.getStockQuantity()-1);

    }

    if(product.getStockQuantity() == 0)
    {
      stock.remove(product);
    }

  }

  public void removeFromCart(int index)
  {
    if(!cart.isEmpty())
    {
      Product p = cart.get(index);
      if(cart.get(index).getAmountInCart() > 1)
      {
        p.setAmountInCart(p.getAmountInCart()-1);
        p.setStockQuantity(p.getStockQuantity()+1);
      }

      if(!stock.contains(p))
      {
        stock.add(p);
      }

      else if(cart.get(index).getAmountInCart() == 1)
      {
        cart.remove(p);

        p.setStockQuantity(p.getStockQuantity()+1);
        p.setAmountInCart(p.getAmountInCart()-1);

      }

    }

  }

  public ArrayList<Product> mostPopular()
  {
    if(popularItems.isEmpty())
    {
      for(int i = 0; i < 3;i++)
      {
        popularItems.add(stock.get(i));
      }

      return popularItems;
    }

    else if(!popularItems.isEmpty())
    {

      ArrayList<Product> stockCopy = new ArrayList<Product>();
      stockCopy.addAll(allItems);
      
      Collections.sort(stockCopy, new Comparator<Product>()
      {

        public int compare(Product p1, Product p2)
        {
          if(p1.getSoldQuantity() > p2.getSoldQuantity())
          {
            return -1;
          }

          else
          {
            return 1;
          }

        }
      });

      popularItems.removeAll(popularItems);
      for(int i = 0; i < 3; i++)
      {
        popularItems.add(stockCopy.get(i));
      }

      return popularItems;
    }

    return popularItems;
  }

  public void completeSale()
  {
    revenue += cartTotal();

    for(int i = 0; i < cart.size(); i++)
    {
      cart.get(i).setSoldQuantity(cart.get(i).getAmountInCart());
      cart.get(i).setAmountInCart(0);
    }
    sales++;
    cart.removeAll(cart);
  }

  public double cartTotal()
  {
    if(!cart.isEmpty())
    {
      double cartTotal = 0;

      for(int i = 0; i < cart.size();i++)
      {
        cartTotal+= cart.get(i).getPrice()*cart.get(i).getAmountInCart();
      }

      return cartTotal;
    }

    return 0;
  }

  public ArrayList<Product> getPopularItems() {
    return popularItems;
  }

  public double getRevenue(){
    return revenue;
  }

  public static ElectronicStore createStore()
  {
    ElectronicStore store1 = new ElectronicStore("Watts Up Electronics");
    Desktop d1 = new Desktop(100, 10, 3.0, 16, false, 250, "Compact");
    Desktop d2 = new Desktop(200, 10, 4.0, 32, true, 500, "Server");
    Laptop l1 = new Laptop(150, 10, 2.5, 16, true, 250, 15);
    Laptop l2 = new Laptop(250, 10, 3.5, 24, true, 500, 16);
    Fridge f1 = new Fridge(500, 10, 250, "White", "Sub Zero", 15.5, false);
    Fridge f2 = new Fridge(750, 10, 125, "Stainless Steel", "Sub Zero", 23, true);
    ToasterOven t1 = new ToasterOven(25, 10, 50, "Black", "Danby", 8, false);
    ToasterOven t2 = new ToasterOven(75, 10, 50, "Silver", "Toasty", 12, true);
    store1.addProduct(d1);
    store1.addProduct(d2);
    store1.addProduct(l1);
    store1.addProduct(l2);
    store1.addProduct(f1);
    store1.addProduct(f2);
    store1.addProduct(t1);
    store1.addProduct(t2);
    return store1;
  }

  public int getSales()
  {
    return sales;
  }
  public ArrayList<Product> getStock()
  {
    return stock;
  }

  public ArrayList<Product> getCart()
  {
    return cart;
  }

}