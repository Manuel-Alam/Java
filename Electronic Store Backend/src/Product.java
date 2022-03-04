abstract class Product
{
    private double price;
    private int stockQuantity;
    private int soldQuantity;

    public Product(double price, int stockQuantity)
    {
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.soldQuantity = 0;

    }

    public double sellUnits(int amount)
    {
        if(amount > 0 && amount <= stockQuantity)
        {
            stockQuantity -= amount;
            soldQuantity += amount;

            return(price * amount);
        }

        if(amount == 0| amount > 0| amount < 0)
        {
            return 0;
        }

        return -1;
    }

    public String toString()
    {
        return(String.format("(%.1f dollars each, %d in stock, %d sold)",price,stockQuantity,soldQuantity));
    }

    public double getPrice()
    {
        return price;
    }


    public int getStockQuantity()
    {
        return stockQuantity;
    }


    public int getSoldQuantity()
    {
        return soldQuantity;
    }

}
