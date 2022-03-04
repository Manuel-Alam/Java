
public class Desktop
{
    double cpuSpeed;
    int ram;
    int storage;
    boolean storageType;


    public Desktop(double cpuSpeed, int ram,int storage, boolean storageType)
    {
        this.cpuSpeed = cpuSpeed;
        this.ram = ram;
        this.storage = storage;
        this.storageType = storageType;

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

        return("Desktop PC with "+this.cpuSpeed+"ghz CPU, "+this.ram+"GB RAM, "+this.storage+"GB "+storageT+" drive");
    }

    public static void main(String[]args)
    {
        //test code
        Desktop pc1 = new Desktop(3,16,250,true);
        System.out.print(pc1);
    }


}
