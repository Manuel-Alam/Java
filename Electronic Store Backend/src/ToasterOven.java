public class ToasterOven extends KitchenAppliance
{
    private int width;
    private boolean convection;

    public ToasterOven(double price, int stockQuantity, int wattage, String color, String brand,int width, boolean convection)
    {
        super(price, stockQuantity, wattage, color, brand);
        this.width = width;
        this.convection = convection;
    }

    public String toString()
    {
        if(convection)
        {
            return(String.format(" %d inch %s Toaster with convection"+super.toString(),width,getBrand()));
        }
        return(String.format(" %d inch %s Toaster"+super.toString(),width,getBrand()));

    }

}
