package br.com.bandtec.filosofosquejantam.model;

public class Filosofo {
    private Integer id;
    private boolean isComendo;
    private boolean isFaminto;
    private boolean isDormindo;
    private Talher talherEsquerdo;
    private Talher talherDireito;
    private Token tokenDireito;
    private Token tokenEsquerdo;
    private Filosofo visinhoEsquerdo;
    private Filosofo visinhoDireito;
    /**
     * Construtor
     * */
    public Filosofo(Integer id){
        this.id = id;
        /*setComendo(false);
        setDormindo(true);
        setFaminto(false);*/
        isComendo = false;
        isDormindo = true;
        isFaminto = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isComendo() {
        return isComendo;
    }

    public void setComendo(boolean comendo) {
        isComendo = comendo;
        if(comendo){
            this.getTalherEsquerdo().setLimpo(false);
            this.getTalherDireito().setLimpo(false);
        }else{
            responderPedidoObserver();
        }
    }

    public Talher getTalherEsquerdo() {
        return talherEsquerdo;
    }

    public void setTalherEsquerdo(Talher talherEsquerdo) {
        /*if(talherEsquerdo != null){
             talherEsquerdo.setLimpo(true);
        }*/
        this.talherEsquerdo = talherEsquerdo;
    }

    public Talher getTalherDireito() {
        return talherDireito;
    }

    public void setTalherDireito(Talher talherDireito) {
        /*if(talherDireito != null){
            talherDireito.setLimpo(true);
        }*/
        this.talherDireito = talherDireito;
    }

    public Token getTokenDireito() {
        return tokenDireito;
    }

    public void setTokenDireito(Token tokenDireito) {
        if(tokenDireito != null)
            tokenDireito.setFilosofo(this);
        this.tokenDireito = tokenDireito;
    }

    public Token getTokenEsquerdo() {
        return tokenEsquerdo;
    }

    public void setTokenEsquerdo(Token tokenEsquerdo) {
        if(tokenEsquerdo != null)
            tokenEsquerdo.setFilosofo(this);
        this.tokenEsquerdo = tokenEsquerdo;
    }

    public Filosofo getVisinhoEsquerdo() {
        return visinhoEsquerdo;
    }

    public void setVisinhoEsquerdo(Filosofo visinhoEsquerdo) {
        this.visinhoEsquerdo = visinhoEsquerdo;
    }

    public Filosofo getVisinhoDireito() {
        return visinhoDireito;
    }

    public void setVisinhoDireito(Filosofo visinhoDireito) {
        this.visinhoDireito = visinhoDireito;
    }

    public boolean isFaminto() {
        return isFaminto;
    }

    public void setFaminto(boolean faminto) {
        isFaminto = faminto;
        comecarComer();
        if(!isComendo){
            fazerPedidoObserver();
        }
    }

    public boolean isDormindo() {
        return isDormindo;
    }

    public void setDormindo(boolean dormindo) {
        isDormindo = dormindo;
    }

    /*Métodos Lógica*/
    public void enviarTokenDireito(){
        Token token = this.getTokenDireito();
        this.setTokenDireito(null);
        getVisinhoDireito().receberTokenEsquerdo(token);
    }
    public void enviarTokenEsquerdo(){
        Token token = this.getTokenEsquerdo();
        this.setTokenEsquerdo(null);
        getVisinhoEsquerdo().receberTokenDireito(token);
    }
    /**
     * Passo 2
     * */
    public void enviarTalherDireito(){
        if(!isComendo() && getTalherDireito() != null && !getTalherDireito().isLimpo()){
            Talher talher = this.getTalherDireito();
            this.setTalherDireito(null);
            talher.setLimpo(true);
            getVisinhoDireito().receberTalherEsquerdo(talher);
            if(isFaminto){
                enviarTokenDireito();
            }
        }
    }
    /**
     * Passo 2
     * */
    public void enviarTalherEsquerdo(){
        if(!isComendo() && getTalherEsquerdo() != null && !getTalherEsquerdo().isLimpo()) {
            Talher talher = this.getTalherEsquerdo();
            this.setTalherEsquerdo(null);
            talher.setLimpo(true);
            getVisinhoEsquerdo().receberTalherDireito(talher);
            if(isFaminto){
                enviarTokenEsquerdo();
            }
        }
    }
    /**
     * Passo 3
     * */
    public void receberTokenDireito(Token token){
        this.setTokenDireito(token);
        enviarTalherDireito();
    }
    /**
     * Passo 3
     * */
    public void receberTokenEsquerdo(Token token){
        this.setTokenEsquerdo(token);
        enviarTalherEsquerdo();
    }
    /**
     * Passo 4
     * */
    public void receberTalherEsquerdo(Talher talher){
        this.setTalherEsquerdo(talher);
        comecarComer();
    }
    /**
     * Passo 4
     * */

    public void receberTalherDireito(Talher talher){
        this.setTalherDireito(talher);
        comecarComer();
    }
    /**
     * Passo 5
     * */
    private void comecarComer(){
        if(isFaminto() && getTalherEsquerdo() != null && getTalherDireito() != null){
            setComendo(true);
            setFaminto(false);
            getTalherEsquerdo().setLimpo(false);
            getTalherDireito().setLimpo(false);
        }
    }
    /**
     * Passo 1
     * */
    private void fazerPedidoObserver(){
        if(isFaminto() && getTokenDireito() != null && getTalherDireito() == null){
            enviarTokenDireito();
        }
        if(isFaminto() && getTokenEsquerdo() != null && getTalherEsquerdo() == null){
            enviarTokenEsquerdo();
        }
    }
    private void responderPedidoObserver(){
        if(!isComendo() && getTokenDireito() != null && getTalherDireito() != null){
            enviarTalherDireito();
        }
        if(!isComendo() && getTokenEsquerdo() != null && getTalherEsquerdo() != null){
            enviarTalherEsquerdo();
        }
    }
    /**
     * Passo 6
     * */
    public void pararComer(){
        if(isComendo()){
            setDormindo(true);
            setComendo(false);
        }
    }
    /**
     * Passo 7
     * */
    public void querComer(){
        if(isDormindo()){
            setDormindo(false);
            setFaminto(true);
        }
    }
}
