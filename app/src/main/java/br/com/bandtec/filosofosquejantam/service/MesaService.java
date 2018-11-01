package br.com.bandtec.filosofosquejantam.service;

import java.util.ArrayList;
import java.util.List;

import br.com.bandtec.filosofosquejantam.model.Filosofo;
import br.com.bandtec.filosofosquejantam.model.Talher;
import br.com.bandtec.filosofosquejantam.model.Token;

public class MesaService {
    private List<Filosofo> filosofos;
    private List<Talher> talheres;
    private List<Token> tokens;

    /**
     * @param qtd - quantidade de filósofos
     *            Inicia a mesa de acordo com a quantidade de filósofos
     */
    public void iniciarMesa(Integer qtd) {
        filosofos = new ArrayList<>();
        talheres = new ArrayList<>();
        tokens = new ArrayList<>();
        for (int i = 1; i <= qtd; i++) {
            Talher talher = new Talher(i);
            talheres.add(talher);
            Token token = new Token(i);
            tokens.add(token);
        }
        for (int i = 1; i <= qtd; i++) {
            Filosofo filosofo = new Filosofo(i);
            if(i == 1 || i == qtd) {
                for (int x = 0; x < qtd; x++) {

                    if (filosofo.getTalherEsquerdo() == null) {
                        if (!talheres.get(x).isLimpo()) {
                            filosofo.setTalherEsquerdo(talheres.get(x));
                            filosofo.getTalherEsquerdo().setLimpo(true);
                            filosofo.setTokenEsquerdo(null);
                            x = talheres.size();
                        } else {
                            if (filosofo.getTalherEsquerdo() == null && x == qtd - 1) {
                                for (int y = 0; y < qtd; y++) {
                                    if (tokens.get(y).getFilosofo() == null) {
                                        filosofo.setTokenEsquerdo(tokens.get(y));
                                        y = qtd;
                                    }
                                }
                            }
                        }
                    }
                }
                for (int x = 0; x < qtd; x++) {
                    if (filosofo.getTalherDireito() == null) {
                        if (!talheres.get(x).isLimpo()) {
                            filosofo.setTalherDireito(talheres.get(x));
                            filosofo.getTalherDireito().setLimpo(true);
                            filosofo.setTokenDireito(null);
                            x = talheres.size();
                        }
                        if (filosofo.getTalherDireito() == null && x == qtd - 1) {
                            for (int y = 0; y < qtd; y++) {
                                if (tokens.get(y).getFilosofo() == null) {
                                    filosofo.setTokenDireito(tokens.get(y));
                                    y = qtd;
                                }
                            }
                        }
                    }
                }
            }else{
                for (int x = 0; x < qtd; x++) {
                    if (filosofo.getTalherDireito() == null) {
                        if (!talheres.get(x).isLimpo()) {
                            filosofo.setTalherDireito(talheres.get(x));
                            filosofo.getTalherDireito().setLimpo(true);
                            filosofo.setTokenDireito(null);
                            x = talheres.size();
                        }
                        if (filosofo.getTalherDireito() == null && x == qtd - 1) {
                            for (int y = 0; y < qtd; y++) {
                                if (tokens.get(y).getFilosofo() == null) {
                                    filosofo.setTokenDireito(tokens.get(y));
                                    y = qtd;
                                }
                            }
                        }
                    }
                }
                for (int x = 0; x < qtd; x++) {

                    if (filosofo.getTalherEsquerdo() == null) {
                        if (!talheres.get(x).isLimpo()) {
                            filosofo.setTalherEsquerdo(talheres.get(x));
                            filosofo.getTalherEsquerdo().setLimpo(true);
                            filosofo.setTokenEsquerdo(null);
                            x = talheres.size();
                        } else {
                            if (filosofo.getTalherEsquerdo() == null && x == qtd - 1) {
                                for (int y = 0; y < qtd; y++) {
                                    if (tokens.get(y).getFilosofo() == null) {
                                        filosofo.setTokenEsquerdo(tokens.get(y));
                                        y = qtd;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            filosofos.add(filosofo);
        }
        for (int x = 0; x < qtd; x++) {
            if (x == 0) {
                filosofos.get(x).setVisinhoEsquerdo(filosofos.get(qtd - 1));
                filosofos.get(x).setVisinhoDireito(filosofos.get(x + 1));
            } else if (x == qtd - 1) {
                filosofos.get(x).setVisinhoEsquerdo(filosofos.get(x - 1));
                filosofos.get(x).setVisinhoDireito(filosofos.get(0));
            } else {
                filosofos.get(x).setVisinhoEsquerdo(filosofos.get(x - 1));
                filosofos.get(x).setVisinhoDireito(filosofos.get(x + 1));
            }
            if(filosofos.get(x).getTalherEsquerdo() != null){
                filosofos.get(x).getTalherEsquerdo().setLimpo(false);
            }
            if(filosofos.get(x).getTalherDireito() != null){
                filosofos.get(x).getTalherDireito().setLimpo(false);
            }
        }

    }
    public Filosofo getFilosofo1(){
        return this.filosofos.get(0);
    }
    public Filosofo getFilosofo2(){
        return this.filosofos.get(1);
    }
    public Filosofo getFilosofo3(){
        return this.filosofos.get(2);
    }

}

