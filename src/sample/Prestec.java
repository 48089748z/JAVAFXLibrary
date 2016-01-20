package sample;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by 48089748z on 08/01/16.
 */
@Entity
public class Prestec implements Serializable
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private Llibre llibre;
    private Soci soci;
    private Date dataInici;
    private Date dataFinal;

    public Prestec() {}
    public Llibre getLlibre() {return llibre;}
    public void setLlibre(Llibre llibre) {this.llibre = llibre;}
    public Soci getSoci() {return soci;}
    public void setSoci(Soci soci) {this.soci = soci;}
    public Date getDataInici() {return dataInici;}
    public void setDataInici(Date dataInici) {this.dataInici = dataInici;}
    public Date getDataFinal() {return dataFinal;}
    public void setDataFinal(Date dataFinal) {this.dataFinal = dataFinal;}
    public String toString()
    {
        return "\n     Data Inici: "+dataInici+"\n     Data Final: "+dataFinal+"\n     Soci: "+soci.toString()+"\n     LLibre: "+llibre.toString();
    }
}
