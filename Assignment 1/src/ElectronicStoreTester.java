import java.util.Scanner;

public class ElectronicStoreTester
{
    public static void main(String[]args)
    {
        Scanner scan = new Scanner(System.in);
        ElectronicStore store = new ElectronicStore("Bestbuy");
        store.printStock();

        boolean prompt = true;

        while(prompt)
        {
            System.out.println("Enter a term for search for:");
            String userInput = "";
            userInput = scan.nextLine();
            if(userInput.equals("quit"))
            {
                prompt = false;
            }

            else if(store.searchStock(userInput))
            {
                System.out.println("A matching item is contained in the store's stock.");
            }

            else if(!store.searchStock(userInput))
            {
                System.out.println("No items in the store's stock match that term.");
            }

        }
    }

}
