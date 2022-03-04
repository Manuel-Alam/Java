import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class ElectronicStoreView extends Pane
{
    private ListView<Product> storeStock, popularItems;
    private ListView<String> currentCart;
    private TextField salesField, revenueField, saleField;
    private ButtonPane buttonPane;
    private Label currentCartLabel;

    public ElectronicStoreView()
    {
        Label storeSummaryLabel = new Label("Store Summary:");
        Label storeStockLabel = new Label("Store Stock:");
        currentCartLabel = new Label("Current Cart ($0.00):");
        Label salesLabel = new Label("# Sales:");
        Label revenueLabel = new Label("Revenue:");
        Label saleLabel = new Label("$ / Sale:");
        Label popularItemLabel = new Label("Most Popular Items:");

        storeStock = new ListView<Product>();
        popularItems = new ListView<Product>();
        currentCart = new ListView<String>();

        salesField = new TextField();
        revenueField = new TextField();
        saleField = new TextField();

        storeSummaryLabel.relocate(50,5);
        storeStockLabel.relocate(290, 5);
        currentCartLabel.relocate(600, 5);

        salesLabel.relocate(35,30);
        revenueLabel.relocate(27,60);
        saleLabel.relocate(32, 90);
        popularItemLabel.relocate(32,115);

        salesField.relocate(80, 28);
        salesField.setPrefSize(80,25);
        salesField.setEditable(false);

        revenueField.relocate(80, 56);
        revenueField.setPrefSize(80,25);
        revenueField.setEditable(false);

        saleField.relocate(80, 85);
        saleField.setPrefSize(80,25);
        saleField.setEditable(false);

        popularItems.setPrefSize(150,188);
        popularItems.relocate(10, 140);

        storeStock.setPrefSize(300,300);
        storeStock.relocate(170,28);

        currentCart.setPrefSize(300,300);
        currentCart.relocate(480,28);


        buttonPane = new ButtonPane();

        salesField.setText("0");
        saleField.setText("N/A");
        revenueField.setText("0.00");

        getChildren().addAll(storeSummaryLabel,storeStockLabel,currentCartLabel,salesLabel,revenueLabel,saleLabel,popularItemLabel,buttonPane,storeStock,popularItems,currentCart,salesField,revenueField,saleField);

        setPrefSize(800, 400);
    }

    public void update(ElectronicStore model)
    {
        String[] cartWithNumbers = new String[model.getCart().size()];

        for(int i = 0; i < cartWithNumbers.length;i++)
        {
            cartWithNumbers[i] = String.format("(%sx) %s",model.getCart().get(i).getAmountInCart(),model.getCart().get(i).toString());

        }
        storeStock.setItems(FXCollections.observableArrayList(model.getStock()));
        currentCart.setItems(FXCollections.observableArrayList(cartWithNumbers));
        currentCartLabel.setText(String.format("Current Cart($%s)",model.cartTotal()));
        revenueField.setText(String.format("%s", model.getRevenue()));
        salesField.setText(String.format("%s",model.getSales()));
        popularItems.setItems(FXCollections.observableArrayList(model.mostPopular()));

        if(model.getSales() > 0)
        {
            saleField.setText(String.format("%.2f",model.getRevenue()/model.getSales()));
        }

        else if (model.getSales() == 0)
        {
            saleField.setText("N/A");

        }


    }

    public ButtonPane getButtonPane()
    {
        return buttonPane;
    }

    public ListView<Product> getStoreStock()
    {
        return storeStock;
    }

    public ListView<String> getCurrentCart()
    {
        return currentCart;
    }

    public ListView<Product> getPopularItems()
    {
        return popularItems;
    }

}
