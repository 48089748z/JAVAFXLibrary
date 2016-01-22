package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
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
    public Button modifyBGuardar;
    public TextField modifyB1;
    public TextField modifyB2;
    public TextField modifyB3;
    public TextField modifyB4;
    public TextField modifyB5;
    public TextField modifyB6;
    public Text modifyBGuide;
    public void initialize()
    {
        modifyBGuide.setVisible(false);
        modifyBGuardar.requestFocus();
        modifyB1.setPromptText("Titol");
        modifyB2.setPromptText("Num Exemplars");
        modifyB3.setPromptText("Editorial");
        modifyB4.setPromptText("Num Pagines");
        modifyB5.setPromptText("Any Edició");
        modifyB6.setPromptText("Autor");
        fillItems();
        listViewBooks.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                borrarAntiguo();
                guardar();
            }
        });
    }
    public void borrarAntiguo()
    {
        listViewBooks.getItems().remove(listViewBooks.getSelectionModel().getSelectedIndex());
        listViewBooks.setVisible(false);
        DAO.deleteBook(listViewBooks.getSelectionModel().getSelectedItem().toString());
    }

    public void guardar()
    {
        if (modifyB1.getText().equals("") || modifyB2.getText().equals("") || modifyB3.getText().equals("") || modifyB4.getText().equals("") || modifyB5.getText().equals("") || modifyB6.getText().equals(""))
        {
            modifyBGuide.setVisible(true);
            modifyBGuide.setText("\nOMPLE TOTS ELS CAMPS");
        }
        else
        {
            listViewBooks.setVisible(true);
            Llibre modifiedBook = new Llibre();
            modifiedBook.setTitol(modifyB1.getText());
            modifiedBook.setNumExemplars(modifyB2.getText());
            modifiedBook.setEditorial(modifyB3.getText());
            modifiedBook.setNumPagines(modifyB4.getText());
            modifiedBook.setAnyEdicio(modifyB5.getText());
            modifiedBook.setAutor(modifyB6.getText());
            modifiedBook.setToString();
            DAO.saveBook(modifiedBook);
            fillItems();
        }
    }
    public void fillItems()
    {
        try {llibres = DAO.getBooks();}
        catch (Exception noBooks){}
        items.clear();
        for (int x=0; x<llibres.size(); x++)
        {
            items.add(llibres.get(x).toString());
        }
        ControllerMain refresh = new ControllerMain();
        refresh.fillArraysFromDB();
        listViewBooks.setItems(items);
    }
    public void borrar(ActionEvent actionEvent) {
        listViewBooks.setVisible(true);
    }
}
