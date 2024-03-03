package demo.models.ordre;

import java.sql.Connection;
import java.sql.Timestamp;

import orm.DynamicORM;
import orm.annotations.Id;

public class MouvementLaptop extends DynamicORM<MouvementLaptop> {
    @Id
    Integer idmouvementlaptop;
    Integer idemplacement;
    Integer idmodellaptop;
    Timestamp datedebut;
    Timestamp datefin;

    public void setDernierMouvement(Connection connection) throws Exception {

        MouvementLaptop[] l = select(connection, false,
                "select * from dernieremplacement where idmodellaptop=" + idmodellaptop);
        if (l.length > 1) {
            throw new Exception("Erreur de donnees");
        }
        setIdmouvementlaptop(l[0].getIdmouvementlaptop());
        setIdemplacement(l[0].getIdemplacement());
        setIdmodellaptop(l[0].getIdmodellaptop());
        setDatedebut(l[0].getDatedebut());
        setDatefin(l[0].getDatefin());
    }

    public Integer getIdmouvementlaptop() {
        return idmouvementlaptop;
    }

    public void setIdmouvementlaptop(Integer idmouvementlaptop) {
        this.idmouvementlaptop = idmouvementlaptop;
    }

    public Integer getIdemplacement() {
        return idemplacement;
    }

    public void setIdemplacement(Integer idemplacement) {
        this.idemplacement = idemplacement;
    }

    public Integer getIdmodellaptop() {
        return idmodellaptop;
    }

    public void setIdmodellaptop(Integer idmodellaptop) {
        this.idmodellaptop = idmodellaptop;
    }

    public Timestamp getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Timestamp datedebut) {
        this.datedebut = datedebut;
    }

    public Timestamp getDatefin() {
        return datefin;
    }

    public void setDatefin(Timestamp datefin) {
        this.datefin = datefin;
    }
}
