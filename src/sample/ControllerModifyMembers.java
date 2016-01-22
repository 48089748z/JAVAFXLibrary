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
public class ControllerModifyMembers
{
    private DAO DAO = new DAO();
    private ArrayList<Soci> socis = new ArrayList<>();
    private ObservableList<String> items = FXCollections.observableArrayList();

    public ListView listViewMembers;

    public Button modifyMGuardar;
    public TextField modifyM1;
    public TextField modifyM2;
    public TextField modifyM3;
    public TextField modifyM4;
    public TextField modifyM5;
    public Text modifyBGuide;
    public void initialize()
    {
        modifyBGuide.setVisible(false);
        modifyMGuardar.requestFocus();
        modifyM1.setPromptText("Nom");
        modifyM2.setPromptText("Cognom");
        modifyM3.setPromptText("Edat");
        modifyM4.setPromptText("Direccio");
        modifyM5.setPromptText("Telefon");
        fillItems();
        listViewMembers.setOnMouseClicked(new EventHandler<MouseEvent>()
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
        listViewMembers.getItems().remove(listViewMembers.getSelectionModel().getSelectedIndex());
        listViewMembers.setVisible(false);
        DAO.deleteMember(listViewMembers.getSelectionModel().getSelectedItem().toString());
    }

    public void guardar()
    {
        if (modifyM1.getText().equals("") || modifyM2.getText().equals("") || modifyM3.getText().equals("") || modifyM4.getText().equals("") || modifyM5.getText().equals(""))
        {
            modifyBGuide.setVisible(true);
            modifyBGuide.setText("\nOMPLE TOTS ELS CAMPS");
        }
        else
        {
            listViewMembers.setVisible(true);
            Soci modifiedMember = new Soci();
            modifiedMember.setNom(modifyM1.getText());
            modifiedMember.setCognom(modifyM2.getText());
            modifiedMember.setEdat(modifyM3.getText());
            modifiedMember.setDireccio(modifyM3.getText());
            modifiedMember.setTelefon(modifyM4.getText());
            modifiedMember.setToString();
            modifyM1.setPromptText("Nom");
            modifyM2.setPromptText("Cognom");
            modifyM3.setPromptText("Edat");
            modifyM4.setPromptText("Direccio");
            modifyM5.setPromptText("Telefon");
            DAO.saveMember(modifiedMember);
            fillItems();
        }
    }
    public void fillItems()
    {
        try {
            socis = DAO.getMembers();}
        catch (Exception noBooks){}
        items.clear();
        for (int x = 0; x< socis.size(); x++)
        {
            items.add(socis.get(x).toString());
        }
        ControllerMain refresh = new ControllerMain();
        refresh.fillArraysFromDB();
        listViewMembers.setItems(items);
    }
    public void borrar(ActionEvent actionEvent)
    {
        listViewMembers.setVisible(true);
    }
}
