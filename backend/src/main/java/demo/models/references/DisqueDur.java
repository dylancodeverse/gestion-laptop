package demo.models.references;

import orm.DynamicORM;

public class DisqueDur extends DynamicORM<DisqueDur> {
    Integer iddisquedur;
    String disquedur;

    public Integer getIddisquedur() {
        return iddisquedur;
    }

    public void setIddisquedur(Integer iddisquedur) {
        this.iddisquedur = iddisquedur;
    }

    public String getDisquedur() {
        return disquedur;
    }

    public void setDisquedur(String disquedur) {
        this.disquedur = disquedur;
    }
}
