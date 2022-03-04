abstract class KitchenAppliance extends Product
{
    private int wattage;
    private String color;
    private String brand;

    public KitchenAppliance(double price, int stockQuantity, int wattage, String color, String brand)
    {
        super(price, stockQuantity);
        this.wattage = wattage;
        this.color = color;
        this.brand = brand;

    }

    public String toString()
    {
        return(String.format(" (%s, %d watts) "+super.toString(),color,wattage));
    }

    public int getWattage()
    {
        return wattage;
    }

    public String getColor()
    {
        return color;
    }

    public String getBrand()
    {
        return brand;
    }

}
