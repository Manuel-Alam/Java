public class Desktop extends Computer
{
    private String profile;

    public Desktop(double price, int stockQuantity, double cpuSpeed, int ram, boolean ssd, int storage, String profile)
    {
        super(price, stockQuantity, cpuSpeed, ram, ssd, storage);
        this.profile = profile;
    }

    public String toString()
    {
        if(isSsd())
        {
            return (String.format(" %s Desktop "+super.toString(),profile));
        }

        return (String.format(" %s Desktop "+super.toString(),profile));

    }


}
