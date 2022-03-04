public class Fridge extends KitchenAppliance
{
    private double cubicFeet;
    private boolean hasFreezer;

    public Fridge(double price, int stockQuantity, int wattage, String color, String brand, double cubicFeet, boolean hasFreezer)
    {
        super(price, stockQuantity, wattage, color, brand);
        this.cubicFeet = cubicFeet;
        this.hasFreezer = hasFreezer;

    }

    public String toString()
    {
        if(hasFreezer)
        {

            return(String.format(" %.1f cu. ft. %s Fridge with Freezer"+super.toString(),cubicFeet, getBrand()));
        }

        return(String.format(" %.1f cu. ft. %s Fridge"+super.toString(),cubicFeet, getBrand()));
    }
}
