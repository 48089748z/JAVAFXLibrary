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
    public String newWhat;
    public String whatToSearch;
    public ScrollPane scrollPane;
    public Text scrollText;
    public TextField field6;
    private ArrayList<Llibre> llibres = new ArrayList<>();
    private ArrayList<Soci> socis = new ArrayList<>();
    private ArrayList<Prestec> prestecs = new ArrayList<>();
    public Text textGuide;
    public TextField searchField;
    public TextField field1;
    public TextField field2;
    public TextField field3;
    public TextField field4;
    public TextField field5;
    public Button aceptar;
    public Button searchButton;
    private void createBook()
    {
        if (field1.getText().equals("") || field2.getText().equals("") || field3.getText().equals("") || field4.getText().equals("") || field5.getText().equals("") || field6.getText().equals(""))
        {
            textGuide.setText("Omple tots els camps!");
        }
        else
        {
            Llibre llibre = new Llibre();
            llibre.setTitol(field1.getText());
            llibre.setNumExemplars(field2.getText());
            llibre.setEditorial(field3.getText());
            llibre.setNumPagines(field4.getText());
            llibre.setAnyEdicio(field5.getText());
            llibre.setAutor(field6.getText());
            llibres.add(llibre);
            hideFields();
            textGuide.setText("CREAT LLIBRE: \n"+llibre.toString());
        }
    }
    private void createSoci()
    {
        if (field1.getText().equals("") || field2.getText().equals("") ||field3.getText().equals("") ||field4.getText().equals("") ||field5.getText().equals(""))
        {
            textGuide.setText("Omple tots els camps!");
        }
        else
        {
            Soci soci = new Soci();
            soci.setNom(field1.getText());
            soci.setCognom(field2.getText());
            soci.setEdat(field3.getText());
            soci.setDireccio(field4.getText());
            soci.setTelefon(field5.getText());
            socis.add(soci);
            hideFields();
            textGuide.setText("CREAT SOCI: \n" + soci.toString());
        }
    }
    private void createPrestec()
    {
        if (field1.getText().equals("") || field2.getText().equals("") ||field3.getText().equals("") ||field4.getText().equals(""))
        {
            textGuide.setText("Omple tots els camps!");
        }
        else
        {
            Prestec prestec = new Prestec();
            for (int x = 0; x < llibres.size(); x++)
            {
                if (llibres.get(x).getTitol().toLowerCase().equals(field1.getText().toLowerCase()))
                {
                    prestec.setLlibre(llibres.get(x));
                }
            }
            for (int x = 0; x < socis.size(); x++)
            {
                if (socis.get(x).getNom().toLowerCase().equals(field2.getText().toLowerCase()))
                {
                    prestec.setSoci(socis.get(x));
                }
            }
            prestec.setDataInici(field3.getText());
            prestec.setDataFinal(field4.getText());
            hideFields();
            try
            {
                textGuide.setText("CREAT PRESTEC: \n" + prestec.toString());
                prestecs.add(prestec);
            }
            catch (Exception e)
            {
                textGuide.setText("Llibre o Soci no existent!");
            }

        }
    }
    public void initialize()
    {
        textGuide.setText("\nBenvingut a la biblioteca, aqui podrás:\n\nAfegir Llibres. \n\nAfegir Socis. \n\nAfegir Prestecs \n\nMostrar llistats de Llibres.\n\nMostrar llistats de Socis.\n\nMostrar llistats de Prestecs    \n\nEtc.");
        hideFields();
    }
    public void newBook(ActionEvent actionEvent)
    {
        hideFields();
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
        field6.setText("");
        field6.setPromptText("Autor");
        newWhat="book";
    }
    public void newSoci(ActionEvent actionEvent)
    {
        hideFields();
        showFields();
        field6.setVisible(false);
        textGuide.setText("Nou Soci");
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
    public void newPrestec(ActionEvent actionEvent)
    {
        hideFields();
        showFields();
        field5.setVisible(false);
        field6.setVisible(false);
        textGuide.setText("Nou Prestec");
        field1.setText("");
        field1.setPromptText("Titol Llibre");
        field2.setText("");
        field2.setPromptText("Nom Soci");
        field3.setText("");
        field3.setPromptText("Data Inici");
        field4.setText("");
        field4.setPromptText("Data Final");
        newWhat="prestec";
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
    public void listPrestecs(ActionEvent actionEvent)
    {
        scrollPane.setVisible(true);
        scrollText.setText("  LLISTA DE PRESTECS");
        for (int x=0; x<prestecs.size(); x++)
        {
            scrollText.setText(scrollText.getText()+"\n\n"+prestecs.get(x).toString());
        }
    }
    public void checkFields(ActionEvent actionEvent)
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
            createPrestec();
        }
    }
    public void hideFields()
    {
        searchButton.setVisible(false);
        searchField.setVisible(false);
        scrollPane.setVisible(false);
        aceptar.setVisible(false);
        field1.setVisible(false);
        field2.setVisible(false);
        field3.setVisible(false);
        field4.setVisible(false);
        field5.setVisible(false);
        field6.setVisible(false);
    }
    public void showFields()
    {
        textGuide.setVisible(true);
        scrollPane.setVisible(false);
        aceptar.setVisible(true);
        field1.setVisible(true);
        field2.setVisible(true);
        field3.setVisible(true);
        field4.setVisible(true);
        field5.setVisible(true);
        field6.setVisible(true);
    }
    public void searchBookByTitle(ActionEvent actionEvent)
    {
        textGuide.setVisible(false);
        hideFields();
        searchField.setVisible(true);
        searchButton.setVisible(true);
        searchField.setText("");
        searchField.setPromptText("Buscar llibre por titol");
        whatToSearch = "title";
    }
    public void searchBookByAuthor(ActionEvent actionEvent)
    {
        textGuide.setVisible(false);
        hideFields();
        searchField.setVisible(true);
        searchButton.setVisible(true);
        searchField.setText("");
        searchField.setPromptText("Buscar llibre per autor");
        whatToSearch = "author";
    }
    public void searchMemberByName(ActionEvent actionEvent)
    {
        textGuide.setVisible(false);
        hideFields();
        searchField.setVisible(true);
        searchButton.setVisible(true);
        searchField.setText("");
        searchField.setPromptText("Buscar soci per nom");
        whatToSearch = "name";
    }
    public void searchMemberBySurname(ActionEvent actionEvent)
    {
        textGuide.setVisible(false);
        hideFields();
        searchField.setVisible(true);
        searchButton.setVisible(true);
        searchField.setText("");
        searchField.setPromptText("Buscar soci per cognom");
        whatToSearch = "surname";
    }
    public void search(ActionEvent actionEvent)
    {
        if (whatToSearch.equals("title"))
        {
            scrollPane.setVisible(true);
            scrollText.setText(" LLISTA DE LLIBRES AMB TITOL: '"+searchField.getText().toLowerCase()+"'");
            for (int x=0; x<llibres.size(); x++)
            {
                if (llibres.get(x).getTitol().toLowerCase().equals(searchField.getText().toLowerCase()))
                {
                    scrollText.setText(scrollText.getText()+"\n\n"+llibres.get(x).toString());
                }
            }
        }
        if (whatToSearch.equals("author"))
        {
            scrollPane.setVisible(true);
            scrollText.setText(" LLISTA DE LLIBRES AMB AUTOR: '"+searchField.getText().toLowerCase()+"'");
            for (int x=0; x<llibres.size(); x++)
            {
                if (llibres.get(x).getAutor().toLowerCase().equals(searchField.getText().toLowerCase()))
                {
                    scrollText.setText(scrollText.getText()+"\n\n"+llibres.get(x).toString());
                }
            }
        }
        if (whatToSearch.equals("name"))
        {
            scrollPane.setVisible(true);
            scrollText.setText(" LLISTA DE SOCIS AMB NOM: '"+searchField.getText().toLowerCase()+"'");
            for (int x=0; x<socis.size(); x++)
            {
                if (socis.get(x).getNom().toLowerCase().equals(searchField.getText().toLowerCase()))
                {
                    scrollText.setText(scrollText.getText()+"\n\n"+socis.get(x).toString());
                }
            }
        }
        if (whatToSearch.equals("surname"))
        {
            scrollPane.setVisible(true);
            scrollText.setText(" LLISTA DE SOCIS AMB COGNOM: '"+searchField.getText().toLowerCase()+"'");
            for (int x = 0; x < socis.size(); x++)
            {
                if (socis.get(x).getCognom().toLowerCase().equals(searchField.getText().toLowerCase()))
                {
                    scrollText.setText(scrollText.getText()+"\n\n"+socis.get(x).toString());
                }
            }
        }
    }
    public void close(ActionEvent actionEvent) {Platform.exit();}
}
