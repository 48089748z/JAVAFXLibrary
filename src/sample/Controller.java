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
    public Text textGuide;
    public TextField searchField;
    public TextField field1;
    public TextField field2;
    public TextField field3;
    public TextField field4;
    public TextField field5;
    public TextField field6;
    public Button guardar;
    public Button buscar;
    private ArrayList<Llibre> llibres = new ArrayList<>();
    private ArrayList<Soci> socis = new ArrayList<>();
    private ArrayList<Prestec> prestecs = new ArrayList<>();
    public String newWhat;
    public String whatToSearch;

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
            hideAllFields();
            textGuide.setText("\nCREAT LLIBRE: \n" + llibre.toString());
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
            hideAllFields();
            textGuide.setText("\nCREAT SOCI: \n" + soci.toString());
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
            hideAllFields();
            try
            {
                textGuide.setText("\nCREAT PRESTEC: \n" + prestec.toString());
                prestecs.add(prestec);
            }
            catch (Exception e)
            {
                textGuide.setText("\nLlibre o Soci no existent!\n\nBusca a la llista de Llibres i Socis per veure quins hi han disponibles.\n\nTambé pots crear'ne de nous.");
            }
        }
    }
    public void initialize()
    {
        textGuide.setText("\nBenvingut a la biblioteca, aqui podrás:\n\nAfegir Llibres.\n\nAfegir Socis.\n\nAfegir Prestecs.\n\nMostrar llistats de Llibres.\n\nMostrar llistats de Socis.\n\nMostrar llistats de Prestecs.\n\nEtc.");
        hideAllFields();
        textGuide.setVisible(true);
    }
    public void newBook(ActionEvent actionEvent)
    {
        newWhat="BOOK";
        showNewFields();
        textGuide.setText("Nou Llibre");
        field1.setPromptText("Titol");
        field2.setPromptText("Num Exemplars");
        field3.setPromptText("Editorial");
        field4.setPromptText("Num Pagines");
        field5.setPromptText("Any Edició");
        field6.setPromptText("Autor");
    }
    public void newSoci(ActionEvent actionEvent)
    {
        newWhat="SOCI";
        showNewFields();
        textGuide.setText("Nou Soci");
        field1.setPromptText("Nom");
        field2.setPromptText("Cognom");
        field3.setPromptText("Edat");
        field4.setPromptText("Direccio");
        field5.setPromptText("Telefon");
    }
    public void newPrestec(ActionEvent actionEvent)
    {
        newWhat="PRESTEC";
        showNewFields();
        textGuide.setText("Nou Prestec");
        field1.setPromptText("Titol Llibre");
        field2.setPromptText("Nom Soci");
        field3.setPromptText("Data Inici");
        field4.setPromptText("Data Final");
    }
    public void listBooks(ActionEvent actionEvent)
    {
        scrollPane.setVisible(true);
        scrollText.setText("\n   LLISTA DE LLIBRES");
        for (int x=0; x<llibres.size(); x++) {scrollText.setText(scrollText.getText()+"\n\n"+llibres.get(x).toString());}
    }
    public void listMembers(ActionEvent actionEvent)
    {
        scrollPane.setVisible(true);
        scrollText.setText("\n   LLISTA DE SOCIS");
        for (int x=0; x<socis.size(); x++) {scrollText.setText(scrollText.getText()+"\n\n"+socis.get(x).toString());}
    }
    public void listPrestecs(ActionEvent actionEvent)
    {
        scrollPane.setVisible(true);
        scrollText.setText("\n   LLISTA DE PRESTECS");
        for (int x=0; x<prestecs.size(); x++) {scrollText.setText(scrollText.getText()+"\n\n"+prestecs.get(x).toString());}
    }
    public void checkFields(ActionEvent actionEvent)
    {
        if (newWhat.equals("BOOK")) {createBook();}
        if (newWhat.equals("SOCI")) {createSoci();}
        if (newWhat.equals("PRESTEC")) {createPrestec();}
    }
    public void hideAllFields()
    {
        textGuide.setVisible(false);
        searchField.setVisible(false);
        scrollPane.setVisible(false);
        buscar.setVisible(false);
        guardar.setVisible(false);
        field1.setVisible(false);
        field2.setVisible(false);
        field3.setVisible(false);
        field4.setVisible(false);
        field5.setVisible(false);
        field6.setVisible(false);
    }
    public void showNewFields()
    {
        hideAllFields();
        guardar.setVisible(true);
        guardar.requestFocus();
        textGuide.setVisible(true);
        scrollPane.setVisible(false);
        field1.setVisible(true);
        field1.clear();
        field2.setVisible(true);
        field2.clear();
        field3.setVisible(true);
        field3.clear();
        field4.setVisible(true);
        field4.clear();
        if (newWhat.equals("BOOK") || newWhat.equals("SOCI"))
        {
            field5.setVisible(true);
            field5.clear();
        }
        if (newWhat.equals("BOOK"))
        {
            field6.setVisible(true);
            field6.clear();
        }
    }
    public void showSearchFields()
    {
        hideAllFields();
        searchField.setVisible(true);
        buscar.setVisible(true);
        buscar.requestFocus();
        searchField.clear();
    }
    public void searchBookByTitle(ActionEvent actionEvent)
    {
        showSearchFields();
        searchField.setPromptText("Buscar llibre por titol");
        whatToSearch = "TITLE";
    }
    public void searchBookByAuthor(ActionEvent actionEvent)
    {
        showSearchFields();
        searchField.setPromptText("Buscar llibre per autor");
        whatToSearch = "AUTHOR";
    }
    public void searchMemberByName(ActionEvent actionEvent)
    {
        showSearchFields();
        searchField.setPromptText("Buscar soci per nom");
        whatToSearch = "NAME";
    }
    public void searchMemberBySurname(ActionEvent actionEvent)
    {
        showSearchFields();
        searchField.setPromptText("Buscar soci per cognom");
        whatToSearch = "SURNAME";
    }
    public void search(ActionEvent actionEvent)
    {
        if (whatToSearch.equals("TITLE"))
        {
            scrollPane.setVisible(true);
            scrollText.setText("\n  LLIBRES AMB TITOL:   '  "+searchField.getText().toLowerCase()+"  '");
            for (int x=0; x<llibres.size(); x++)
            {
                if (llibres.get(x).getTitol().toLowerCase().equals(searchField.getText().toLowerCase()))
                {
                    scrollText.setText(scrollText.getText()+"\n\n"+llibres.get(x).toString());
                }
            }
        }
        if (whatToSearch.equals("AUTHOR"))
        {
            scrollPane.setVisible(true);
            scrollText.setText("\n  LLIBRES AMB AUTOR:   '  "+searchField.getText().toLowerCase()+"  '");
            for (int x=0; x<llibres.size(); x++)
            {
                if (llibres.get(x).getAutor().toLowerCase().equals(searchField.getText().toLowerCase()))
                {
                    scrollText.setText(scrollText.getText()+"\n\n"+llibres.get(x).toString());
                }
            }
        }
        if (whatToSearch.equals("NAME"))
        {
            scrollPane.setVisible(true);
            scrollText.setText("\n  SOCIS AMB NOM:   '  "+searchField.getText().toLowerCase()+"  '");
            for (int x=0; x<socis.size(); x++)
            {
                if (socis.get(x).getNom().toLowerCase().equals(searchField.getText().toLowerCase()))
                {
                    scrollText.setText(scrollText.getText()+"\n\n"+socis.get(x).toString());
                }
            }
        }
        if (whatToSearch.equals("SURNAME"))
        {
            scrollPane.setVisible(true);
            scrollText.setText("\n  SOCIS AMB COGNOM:   '  "+searchField.getText().toLowerCase()+"  '");
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
