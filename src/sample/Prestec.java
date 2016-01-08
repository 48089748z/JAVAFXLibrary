package sample;

/**
 * Created by 48089748z on 08/01/16.
 */
public class Prestec
{
    //Préstec (llibre, soci, data inici, data final)
    private Llibre llibre;
    private Soci soci;
    private String dataInici;
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
}
