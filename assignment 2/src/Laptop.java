public class Laptop extends Computer
{
    private double screenSize;

    public Laptop(double price, int stockQuantity, double cpuSpeed, int ram, boolean ssd, int storage, double screenSize)
    {
        super(price, stockQuantity, cpuSpeed, ram, ssd, storage);
        this.screenSize = screenSize;
    }

    public String toString()
    {
        if(isSsd())
        {
            return (String.format(" %.1f inch Laptop "+super.toString(),screenSize));

        }

        return (String.format(" %.1f inch Laptop "+super.toString(),screenSize));

    }

}
