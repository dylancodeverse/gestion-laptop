package demo.models.ordre;

import java.sql.Connection;
import java.sql.Timestamp;

import demo.models.infra.Emplacement;
import demo.models.laptops.Laptop;
import demo.models.laptops.ModelLaptop;
import orm.DynamicORM;
import orm.annotations.Id;

public class Transfert extends DynamicORM<Transfert> {
    @Id
    Integer idtransfert;
    Integer idmouvementlaptop;
    Integer destinataire;
    Timestamp datetransfert;
    Timestamp datefindetransfert;

    /**
     * Regle de gestion : entre ana magasin central sy tsotra ihany no afaka
     * mifandefa
     * pc
     * 
     * @param connection
     * @param laptop
     * @param destinataire
     * @throws Exception
     */
    public void transfererLaptop(Connection connection, String laptop, String destinataire) throws Exception {
        try {
            // tena misy ve io laptop io
            ModelLaptop modelLaptop = new ModelLaptop();
            modelLaptop.setIdmodellaptop(laptop, connection);

            // iza ilay hitransferena azy
            Emplacement emplacement = new Emplacement();
            emplacement.setIdemplacement(destinataire, connection);

            // aiza izy izao
            MouvementLaptop mouvementLaptop = new MouvementLaptop();
            mouvementLaptop.setIdmodellaptop(modelLaptop.getIdmodellaptop());
            mouvementLaptop.setDernierMouvement(connection);

            // mi transfert @ tenany ve:

            if (mouvementLaptop.getIdemplacement() == emplacement.getIdemplacement()) {
                throw new Exception("Mandefa @ tenany ahoana ??");
            }
            // misy magasin central ve entre an'izy roa
            Emplacement magasinCentral = new Emplacement();
            magasinCentral.setAsMagasinCentral();
            // raha samy tsy magasin central izy roa:
            if (emplacement.getIdemplacement() != magasinCentral.getIdemplacement() &&
                    mouvementLaptop.getIdemplacement() != magasinCentral.getIdemplacement()) {
                throw new Exception("Tsy afaka mandefa entana entre samy magasin simple");
            }

            // mi proceder @ ilay transfert @ izay:
            setIdmouvementlaptop(mouvementLaptop.getIdmouvementlaptop());
            setDestinataire(emplacement.getIdemplacement());

            insert(connection, true);
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.close();
        }

    }

    public Integer getIdtransfert() {
        return idtransfert;
    }

    public void setIdtransfert(Integer idtransfert) {
        this.idtransfert = idtransfert;
    }

    public Timestamp getDatetransfert() {
        return datetransfert;
    }

    public void setDatetransfert(Timestamp datetransfert) {
        this.datetransfert = datetransfert;
    }

    public Timestamp getDatefindetransfert() {
        return datefindetransfert;
    }

    public void setDatefindetransfert(Timestamp datefindetransfert) {
        this.datefindetransfert = datefindetransfert;
    }

    public Integer getIdmouvementlaptop() {
        return idmouvementlaptop;
    }

    public void setIdmouvementlaptop(Integer idmouvementlaptop) {
        this.idmouvementlaptop = idmouvementlaptop;
    }

    public Integer getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Integer destinataire) {
        this.destinataire = destinataire;
    }
}
