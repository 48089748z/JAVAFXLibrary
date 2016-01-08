package sample;

/**
 * Created by 48089748z on 08/01/16.
 */
public class Soci
{
    //Soci (nom, cognom, edat, direcció, telèfon)
    private String nom;
    private String cognom;
    private Integer edat;
    private String direccio;
    private Integer telefon;
    public Soci(){}
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}
    public String getCognom() {return cognom;}
    public void setCognom(String cognom) {this.cognom = cognom;}
    public Integer getEdat() {return edat;}
    public void setEdat(Integer edat) {this.edat = edat;}
    public String getDireccio() {return direccio;}
    public void setDireccio(String direccio) {this.direccio = direccio;}
    public Integer getTelefon() {return telefon;}
    public void setTelefon(Integer telefon) {this.telefon = telefon;}
    public String toString()
    {
        return "\n  Nom: "+nom+"\n  Cognom: "+cognom+"\n  Edat: "+edat+"\n  Direcció: "+direccio+"\n  Telefon: "+telefon;
    }
}
