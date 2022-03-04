
public class Fridge
{
    double size;
    boolean type;
    String colour;

    public Fridge(double size, boolean type, String colour)
    {
        this.size = size;
        this.type = type;
        this.colour = colour;
    }

    public String toString()
    {
        String type = "";

        if(this.type)
        {
            return(this.size+" cubic foot Fridge with Freezer ("+this.colour+")");
        }

        return(this.size+" cubic foot Fridge ("+this.colour+")");

    }

    public static void main(String[]args)
    {
        Fridge f1 = new Fridge(15.6, true, "Gray");
        System.out.print(f1);
    }
}
