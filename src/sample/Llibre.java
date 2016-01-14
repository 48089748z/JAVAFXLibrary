package sample;
/**
 * Created by 48089748z on 08/01/16.
 */
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name = "BOOK")
public class Llibre
{
    @Id @GeneratedValue
    @Column(name="titol")
    private String titol;

    @Column(name="autor")
    private String autor;

    @Column(name="numExemplars")
    private String numExemplars;

    @Column(name="editorial")
    private String editorial;

    @Column(name="numPagines")
    private String numPagines;

    @Column(name="anyEdicio")
    private String anyEdicio;

    public Llibre() {}
    public String getTitol() {return titol;}
    public void setTitol(String titol) {this.titol = titol;}
    public String getNumExemplars() {return numExemplars;}
    public void setNumExemplars(String numExemplars) {this.numExemplars = numExemplars;}
    public String getEditorial() {return editorial;}
    public void setEditorial(String editorial) {this.editorial = editorial;}
    public String getAnyEdicio() {return anyEdicio;}
    public void setAnyEdicio(String anyEdicio) {this.anyEdicio = anyEdicio;}
    public String getNumPagines() {return numPagines;}
    public void setNumPagines(String numPagines) {this.numPagines = numPagines;}
    public String getAutor() {return autor;}
    public void setAutor(String autor) {this.autor = autor;}
    public String toString()
    {
        return "\n     Titol: "+titol+"\n     Autor: "+autor+"\n     Num Exemplars: "+numExemplars+"\n     Editorial: "+editorial+"\n     Num Pagines: "+numPagines+"\n     Any Edició: "+anyEdicio;
    }
}
