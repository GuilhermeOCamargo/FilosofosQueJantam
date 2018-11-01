package br.com.bandtec.filosofosquejantam.model;

public class Talher {
    private Integer id;
    private boolean isLimpo;

    public Talher(Integer id){
        this.id = id;
        setLimpo(false);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isLimpo() {
        return isLimpo;
    }

    public void setLimpo(boolean limpo) {
        isLimpo = limpo;
    }

}
