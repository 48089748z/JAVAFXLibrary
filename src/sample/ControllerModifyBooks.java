package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.util.ArrayList;

/**
 * Created by 48089748z on 22/01/16.
 */
public class ControllerModifyBooks
{
    private DAO DAO = new DAO();
    private ArrayList<Llibre> llibres = new ArrayList<>();
    private ObservableList<String> items = FXCollections.observableArrayList();

    public ListView listViewBooks;
    public Button modifyBorrar;
    public Button modifyGuardar;
    public TextField modify1;
    public TextField modify2;
    public TextField modify3;
    public TextField modify4;
    public TextField modify5;
    public TextField modify6;
    public void initialize()
    {
        fillItems();
        listViewBooks.setItems(items);
        listViewBooks.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                listViewBooks.setVisible(false);
               // listViewBooks.getSelectionModel().getSelectedItems().remove(listViewBooks.getFocusModel().getFocusedIndex());

               // String[] splitted = selected.split("-");
            }
        });
    }
    public void fillItems()
    {
        try {llibres = DAO.getBooks();}
        catch (Exception noBooks){}
        for (int x=0; x<llibres.size(); x++)
        {
            items.add(llibres.get(x).toString());
        }
    }
}
