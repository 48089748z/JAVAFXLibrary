package sample;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Created by 48089748z on 08/01/16.
 */
@Table(name="LOAN")
public class Prestec
{
    @Id @GeneratedValue
    @Column(name="llibre")
    private Llibre llibre;

    @Column(name="soci")
    private Soci soci;

    @Column(name="dataInici")
    private String dataInici;

    @Column(name="dataFinal")
    private String dataFinal;

    public Prestec() {}
    public Llibre getLlibre() {return llibre;}
    public void setLlibre(Llibre llibre) {this.llibre = llibre;}
    public Soci getSoci() {return soci;}
    public void setSoci(Soci soci) {this.soci = soci;}
    public String getDataInici() {return dataInici;}
    public void setDataInici(String dataInici) {this.dataInici = dataInici;}
    public String getDataFinal() {return dataFinal;}
    public void setDataFinal(String dataFinal) {this.dataFinal = dataFinal;}
    public String toString()
    {
        return "\n  Data Inici: "+dataInici+"\n  Data Final: "+dataFinal+"\n  Soci: "+soci.toString()+"\n  LLibre: "+llibre.toString();
    }
}
