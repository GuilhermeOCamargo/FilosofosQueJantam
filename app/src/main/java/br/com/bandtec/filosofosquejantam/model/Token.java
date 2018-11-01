package br.com.bandtec.filosofosquejantam.model;

public class Token {
    private Integer id;
    private Filosofo filosofo;

    public Token(Integer id){
        this.id = id;
        filosofo = null;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Filosofo getFilosofo() {
        return filosofo;
    }

    public void setFilosofo(Filosofo filosofo) {
        this.filosofo = filosofo;
    }
}
