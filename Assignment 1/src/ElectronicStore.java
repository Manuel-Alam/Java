import java.util.ArrayList;

public class ElectronicStore
{
    String storeName;
    ArrayList<Desktop> desktopList;
    ArrayList<Laptop> laptopList;
    ArrayList<Fridge> fridgeList;


    public ElectronicStore(String storeName)
    {
        this.storeName = storeName;
        this.desktopList = new ArrayList<Desktop>();
        this.laptopList = new ArrayList<Laptop>();
        this.fridgeList = new ArrayList<Fridge>();

        Desktop d1 = new Desktop(3,16,250,true);
        Desktop d2 = new Desktop(4.2,36,500,false);
        Desktop d3 = new Desktop(2.5,8,150,true);

        Laptop l1 = new Laptop(3.1,32,600,true,15);
        Laptop l2 = new Laptop(2.1,16,250,false,10);
        Laptop l3 = new Laptop(4.1,32,500,true,11);

        Fridge f1 = new Fridge(15.6, true, "Gray");
        Fridge f2 = new Fridge(13.8, true, "Orange");
        Fridge f3 = new Fridge(11.2, false, "Red");

        this.desktopList.add(d1);
        this.desktopList.add(d2);
        this.desktopList.add(d3);

        this.laptopList.add(l1);
        this.laptopList.add(l2);
        this.laptopList.add(l3);

        this.fridgeList.add(f1);
        this.fridgeList.add(f2);
        this.fridgeList.add(f3);

    }

    public void printStock()
    {
        for(int i = 0; i < desktopList.size();i++)
        {
            System.out.println(desktopList.get(i));
        }

        for(int j = 0; j < laptopList.size();j++)
        {
            System.out.println(laptopList.get(j));
        }

        for(int k = 0; k < fridgeList.size();k++)
        {
            System.out.println(fridgeList.get(k));
        }
    }

    public boolean searchStock(String item)
    {
        for(int i = 0; i < desktopList.size();i++)
        {
            if(desktopList.get(i).toString().toLowerCase().contains(item.toLowerCase()))
            {
                return true;
            }
        }

        for(int j = 0; j < laptopList.size();j++)
        {
            if(laptopList.get(j).toString().toLowerCase().contains(item.toLowerCase()))
            {
                return true;
            }
        }
        
        for(int k = 0; k < fridgeList.size();k++)
        {
            if(fridgeList.get(0).toString().toLowerCase().contains(item.toLowerCase()))
            {
                return true;
            }
        }

        return false;
    }
}
