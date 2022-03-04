import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ElectronicStoreApp extends Application
{
    private ElectronicStore model;

    public ElectronicStoreApp()
    {
        model = ElectronicStore.createStore();
    }
    public void start(Stage primaryStage)
    {
        Pane aPane = new Pane();
        ElectronicStoreView  view = new ElectronicStoreView();
        aPane.getChildren().add(view);

        view.update(model);
        primaryStage.setTitle("Electronic Store Application - "+model.getName());
        primaryStage.setScene(new Scene(aPane));
        primaryStage.setResizable(false);
        primaryStage.show();


        view.getStoreStock().setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent mouseEvent)
            {
                int i = view.getStoreStock().getSelectionModel().getSelectedIndex();

                if(i !=-1)
                {
                    view.getButtonPane().getAddToCart().setDisable(false);
                }


            }
        });

        view.getButtonPane().getAddToCart().setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent actionEvent)
            {
                Product product = view.getStoreStock().getSelectionModel().getSelectedItem();

                if(product.getStockQuantity() == 1)
                {
                    view.getButtonPane().getAddToCart().setDisable(true);
                }
                if(product !=null)
                {
                    model.addToCart(product);
                    view.update(model);
                    if(!model.getCart().isEmpty())
                    {
                        view.getButtonPane().getCompleteSale().setDisable(false);
                    }
                }


            }
        });

        view.getCurrentCart().setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent mouseEvent)
            {
                int i = view.getCurrentCart().getSelectionModel().getSelectedIndex();

                if(i != -1)
                {
                    view.getButtonPane().getRemoveFromCart().setDisable(false);
                }

            }
        });

        view.getButtonPane().getRemoveFromCart().setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent actionEvent)
            {
                int i = view.getCurrentCart().getSelectionModel().getSelectedIndex();

                if(i != -1)
                {
                    model.removeFromCart(i);
                    view.update(model);
                    view.getButtonPane().getRemoveFromCart().setDisable(true);
                    if(model.getCart().isEmpty())
                    {
                        view.getButtonPane().getCompleteSale().setDisable(true);
                    }
                }

            }
        });

        view.getButtonPane().getCompleteSale().setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent actionEvent)
            {
                model.completeSale();
                view.getButtonPane().getRemoveFromCart().setDisable(true);
                view.getButtonPane().getCompleteSale().setDisable(true);
                view.update(model);

            }
        });

        view.getButtonPane().getResetStore().setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent actionEvent)
            {
                model = ElectronicStore.createStore();
                view.update(model);

            }
        });

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
