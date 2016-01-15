package sample;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

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
    private Date dataInici;

    @Column(name="dataFinal")
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
