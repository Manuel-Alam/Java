
public class Laptop
{
    double cpuSpeed;
    int ram;
    int storage;
    boolean storageType;
    int screenSize;


    public Laptop(double cpuSpeed, int ram,int storage, boolean storageType,int screenSize)
    {
        this.cpuSpeed = cpuSpeed;
        this.ram = ram;
        this.storage = storage;
        this.storageType = storageType;
        this.screenSize = screenSize;

    }

    public String toString()
    {
        String storageT = "";
        if(this.storageType)
        {
            storageT = "SSD";
        }
        else
        {
            storageT = "HDD";
        }

        return(this.screenSize+"\" Laptop PC with "+this.cpuSpeed+"ghz CPU, "+this.ram+"GB RAM, "+this.storage+"GB "+storageT+" drive");
    }

    public static void main(String[]args)
    {
        //test code
        Laptop pc1 = new Laptop(3.1,32,500,true,15);
        System.out.print(pc1);
    }

}
