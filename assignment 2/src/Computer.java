abstract class Computer extends Product
{
    private double cpuSpeed;
    private int ram;
    private boolean ssd;
    private int storage;

    public Computer(double price, int stockQuantity, double cpuSpeed, int ram, boolean ssd, int storage)
    {
        super(price, stockQuantity);
        this.cpuSpeed = cpuSpeed;
        this.ram = ram;
        this.ssd = ssd;
        this. storage = storage;
    }

    public String toString()
    {
        if(isSsd())
        {
            return (String.format("PC with %.1fghz CPU, %dGB RAM, %dGB SSD drive "+super.toString(),getCpuSpeed(),getRam(),getStorage()));
        }
        return (String.format("PC with %.1fghz CPU, %dGB RAM, %dGB HDD drive "+super.toString(),getCpuSpeed(),getRam(),getStorage()));
    }
    public double getCpuSpeed()
    {
        return cpuSpeed;
    }

    public boolean isSsd()
    {
        return ssd;
    }

    public int getRam()
    {
        return ram;
    }

    public int getStorage()
    {
        return storage;
    }


}
