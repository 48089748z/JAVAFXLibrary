package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Controller
{
    public ScrollPane scrollPane;
    public Text scrollText;
    private ArrayList<Llibre> llibres = new ArrayList<>();
    private ArrayList<Soci> socis = new ArrayList<>();
    private ArrayList<Prestec> prestecs = new ArrayList<>();
    public String newWhat;
    public Text textGuide;
    public TextField field1;
    public TextField field2;
    public TextField field3;
    public TextField field4;
    public TextField field5;
    public Button aceptar;

    public void initialize()
    {
        textGuide.setText("\nBenvingut a la biblioteca, aqui podrás:\n\nAfegir Llibres. \n\nAfegir Socis. \n\nMostrar llistats de Llibres.\n\nMostrar llistats de Socis.\n\nEtc.");
        hideFields();
    }

    public void newBook(ActionEvent actionEvent)
    {
        showFields();
        textGuide.setText("Nou Llibre");
        field1.setText("");
        field1.setPromptText("Titol");
        field2.setText("");
        field2.setPromptText("Num Exemplars");
        field3.setText("");
        field3.setPromptText("Editorial");
        field4.setText("");
        field4.setPromptText("Num Pagines");
        field5.setText("");
        field5.setPromptText("Any Edició");
        newWhat="book";
    }
    public void newSoci(ActionEvent actionEvent)
    {
        showFields();
        textGuide.setText("Nou Llibre");
        field1.setText("");
        field1.setPromptText("Nom");
        field2.setText("");
        field2.setPromptText("Cognom");
        field3.setText("");
        field3.setPromptText("Edat");
        field4.setText("");
        field4.setPromptText("Direccio");
        field5.setText("");
        field5.setPromptText("Telefon");
        newWhat="soci";
    }

    private void createBook()
    {
        Llibre llibre = new Llibre();
        llibre.setTitol(field1.getText());
        llibre.setNumExemplars(field2.getText());
        llibre.setEditorial(field3.getText());
        llibre.setNumPagines(field4.getText());
        llibre.setAnyEdicio(field5.getText());
        llibres.add(llibre);
        hideFields();
        textGuide.setText("CREAT LLIBRE: \n"+llibre.toString());
    }

    public void listBooks(ActionEvent actionEvent)
    {
        scrollPane.setVisible(true);
        scrollText.setText("  LLISTA DE LLIBRES");
        for (int x=0; x<llibres.size(); x++)
        {
            scrollText.setText(scrollText.getText()+"\n\n"+llibres.get(x).toString());
        }
    }
    public void listMembers(ActionEvent actionEvent)
    {
        scrollPane.setVisible(true);
        scrollText.setText("  LLISTA DE SOCIS");
        for (int x=0; x<socis.size(); x++)
        {
            scrollText.setText(scrollText.getText()+"\n\n"+socis.get(x).toString());
        }
    }
    public void close(ActionEvent actionEvent) {Platform.exit();}

    public void checkFields(ActionEvent actionEvent)
    {
        if (field1.getText().equals("") || field2.getText().equals("") || field3.getText().equals("") || field4.getText().equals("") || field5.getText().equals(""))
        {
            textGuide.setText("Omple tots els camps!");
        }
        else
        {
            whatToCreate();
        }
    }
    public void hideFields()
    {
        scrollPane.setVisible(false);
        aceptar.setVisible(false);
        field1.setVisible(false);
        field2.setVisible(false);
        field3.setVisible(false);
        field4.setVisible(false);
        field5.setVisible(false);
    }
    public void showFields()
    {
        scrollPane.setVisible(false);
        aceptar.setVisible(true);
        field1.setVisible(true);
        field2.setVisible(true);
        field3.setVisible(true);
        field4.setVisible(true);
        field5.setVisible(true);
    }
    public void whatToCreate()
    {
        if (newWhat.equals("book"))
        {
            createBook();
        }
        if (newWhat.equals("soci"))
        {
            createSoci();
        }
        if (newWhat.equals("prestec"))
        {
            //createPrestec();
        }
    }

    private void createSoci()
    {
        Soci soci = new Soci();
        soci.setNom(field1.getText());
        soci.setCognom(field2.getText());
        soci.setEdat(Integer.parseInt(field3.getText()));
        soci.setDireccio(field4.getText());
        soci.setTelefon(Integer.parseInt(field5.getText()));
        socis.add(soci);
        hideFields();
        textGuide.setText("CREAT SOCI: \n"+soci.toString());
    }
}
