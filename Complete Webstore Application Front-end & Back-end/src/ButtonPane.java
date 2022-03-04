import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class ButtonPane extends Pane
{
    private Button resetStore, addToCart, removeFromCart, completeSale;

    public ButtonPane()
    {
        Pane innerPane = new Pane();

        resetStore = new Button("Reset Store");
        resetStore.relocate(30,335);
        resetStore.setPrefSize(120,50);

        addToCart = new Button("Add to Cart");
        addToCart.relocate(250,335);
        addToCart.setPrefSize(120,50);

        removeFromCart = new Button("Remove from Cart");
        removeFromCart.relocate(480,335);
        removeFromCart.setPrefSize(145,50);

        completeSale = new Button("Complete Sale");
        completeSale.relocate(635,335);
        completeSale.setPrefSize(145,50);

        addToCart.setDisable(true);
        removeFromCart.setDisable(true);
        completeSale.setDisable(true);

        innerPane.getChildren().addAll(resetStore,addToCart,removeFromCart,completeSale);

        getChildren().addAll(innerPane);
    }

    public Button getResetStore()
    {
        return resetStore;
    }

    public Button getAddToCart()
    {
        return addToCart;
    }

    public Button getRemoveFromCart()
    {
        return removeFromCart;
    }

    public Button getCompleteSale()
    {
        return completeSale;
    }
}
