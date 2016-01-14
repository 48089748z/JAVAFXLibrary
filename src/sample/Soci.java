package sample;
/**
 * Created by 48089748z on 08/01/16.
 */
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name = "MEMBER")
public class Soci
{
    @Id @GeneratedValue
    @Column(name="nom")
    private String nom;

    @Column(name="cognom")
    private String cognom;

    @Column(name="edat")
    private String edat;

    @Column(name="direccio")
    private String direccio;

    @Column(name="telefon")
    private String telefon;

    public Soci(){}
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getEdat() {
        return edat;
    }

    public void setEdat(String edat) {
        this.edat = edat;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String toString()
    {
        return "\n     Nom: "+nom+"\n     Cognom: "+cognom+"\n     Edat: "+edat+"\n     Direcció: "+direccio+"\n     Telefon: "+telefon;
    }
}
