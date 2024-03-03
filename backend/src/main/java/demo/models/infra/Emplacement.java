package demo.models.infra;

import java.sql.Connection;

import demo.models.laptops.Laptop;
import demo.models.laptops.ModelLaptop;
import demo.models.ordre.MouvementLaptop;
import orm.DynamicORM;
import orm.annotations.Id;

public class Emplacement extends DynamicORM<Emplacement> {
    @Id
    Integer idemplacement;
    String emplacement;
    Integer hierarchie;

    public void setAsMagasinCentral() throws Exception {
        hierarchie = 10;
        Emplacement[] emps = select();
        if (emps.length > 1) {
            throw new Exception("Magasin central plus de 1");
        } else if (emps.length == 0) {
            throw new Exception("Pas de magasin central , hierarchie =" + hierarchie);
        } else {
            setIdemplacement(emps[0].getIdemplacement());
            setEmplacement(emps[0].getEmplacement());
        }
    }

    /**
     * Module du premier achat (Ajout stock dans magasin central)
     * 
     * @param laptopid
     * @param connection
     * @throws Exception
     */
    public void premierAchat(String laptopid, Connection connection) throws Exception {
        try {
            // mijery hoe misy ve ilay laptop
            Laptop l = new Laptop();
            l.setLaptopid(laptopid, connection);
            // maka anle magasin central
            setAsMagasinCentral();
            // insertion @ilay ModelLaptop vaovao alony
            ModelLaptop mm = new ModelLaptop();
            mm.setLaptopid(l.getLaptopid());
            mm.insert(connection, true);
            // izay vao atsofoka anaty premier mouvement
            MouvementLaptop mouvevement = new MouvementLaptop();
            mouvevement.setIdemplacement(getIdemplacement());
            mouvevement.setIdmodellaptop(mm.getIdmodellaptop());
            mouvevement.insert(connection, true);
            // commit
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.close();
        }

    }

    public Integer getIdemplacement() {
        return idemplacement;
    }

    public void setIdemplacement(Integer idemplacement) {
        this.idemplacement = idemplacement;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public Integer getHierarchie() {
        return hierarchie;
    }

    public void setHierarchie(Integer hierarchie) {
        this.hierarchie = hierarchie;
    }

    public void setIdemplacement(String destinataire, Connection connection) throws Exception {
        setIdemplacement(Integer.parseInt(destinataire));
        ;
        Emplacement[] xs = selectWhere(connection, true, "idemplacement=" + getIdemplacement());
        if (xs.length == 0) {
            throw new Exception("L'emplacement est introuvable avec Idemplacement=" + destinataire);
        }
        setEmplacement( xs[0].getEmplacement());
        setHierarchie(xs[0].getHierarchie());
        
    }
}
