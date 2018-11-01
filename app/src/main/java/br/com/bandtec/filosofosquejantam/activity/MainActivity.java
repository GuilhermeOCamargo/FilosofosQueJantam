package br.com.bandtec.filosofosquejantam.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import bandtec.com.br.filosofosquejantam.R;
import br.com.bandtec.filosofosquejantam.model.Filosofo;
import br.com.bandtec.filosofosquejantam.service.MesaService;

public class MainActivity extends AppCompatActivity {
    /*Botões*/
    private Button btnComecar1, btnComecar2, btnComecar3;
    private Button btnParar1, btnParar2, btnParar3;
    /*Talheres*/
    private TextView talherD1, talherD2, talherD3;
    private TextView talherE1, talherE2, talherE3;
    /*Tokens*/
    private TextView tokenD1, tokenD2, tokenD3;
    private TextView tokenE1, tokenE2, tokenE3;
    /*Imagens*/
    private ImageView imgFilosofo1, imgFilosofo2, imgFilosofo3;
    /*Mesa*/
    private MesaService mesaService;
    /*Filosofos*/
    private Filosofo filosofo1, filosofo2, filosofo3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Mesa*/
        mesaService = new MesaService();
        mesaService.iniciarMesa(3);
        /*Filosofos*/
        filosofo1 = mesaService.getFilosofo1();
        filosofo2 = mesaService.getFilosofo2();
        filosofo3 = mesaService.getFilosofo3();
        /*Botões começar*/
        btnComecar1 = findViewById(R.id.btnComercar1);
        btnComecar2 = findViewById(R.id.btnComercar2);
        btnComecar3 = findViewById(R.id.btnComercar3);
        /*Botões parar*/
        btnParar1 = findViewById(R.id.btnParar1);
        btnParar2 = findViewById(R.id.btnParar2);
        btnParar3 = findViewById(R.id.btnParar3);
        /*Talheres*/
        talherD1 = findViewById(R.id.talherD1);
        talherD2 = findViewById(R.id.talherD2);
        talherD3 = findViewById(R.id.talherD3);
        talherE1 = findViewById(R.id.talherE1);
        talherE2 = findViewById(R.id.talherE2);
        talherE3 = findViewById(R.id.talherE3);
        /*Token*/
        tokenD1 = findViewById(R.id.tokenD1);
        tokenD2 = findViewById(R.id.tokenD2);
        tokenD3 = findViewById(R.id.tokenD3);
        tokenE1 = findViewById(R.id.tokenE1);
        tokenE2 = findViewById(R.id.tokenE2);
        tokenE3 = findViewById(R.id.tokenE3);
        /*Imagens*/
        imgFilosofo1 = findViewById(R.id.imgFilosofo1);
        imgFilosofo2 = findViewById(R.id.imgFilosofo2);
        imgFilosofo3 = findViewById(R.id.imgFilosofo3);
        changeState();
    }

    public void comecarComer1(View v){
        filosofo1.querComer();
        changeState();
    }
    public void pararComer1(View v){
        filosofo1.pararComer();
        changeState();
    }
    public void comecarComer2(View v){
        filosofo2.querComer();
        changeState();
    }
    public void pararComer2(View v){
        filosofo2.pararComer();
        changeState();
    }
    public void comecarComer3(View v){
        filosofo3.querComer();
        changeState();
    }
    public void pararComer3(View v){
        filosofo3.pararComer();
        changeState();
    }

    /**
     * Altera o estado dos 3 filósofos
     * */
    private void changeState(){
        stateFilosofo1();
        stateFilosofo2();
        stateFilosofo3();
    }
    /**
     * Verifica o estado do filósofo 1
     * */
    private void stateFilosofo1(){
        /*Estado do filósofo*/
        if(filosofo1.isDormindo()){
            imgFilosofo1.setImageResource(R.mipmap.pensando1);
            btnComecar1.setVisibility(View.VISIBLE);
            btnParar1.setVisibility(View.INVISIBLE);
        }else if(filosofo1.isComendo()){
            imgFilosofo1.setImageResource(R.mipmap.comendo);
            btnComecar1.setVisibility(View.INVISIBLE);
            btnParar1.setVisibility(View.VISIBLE);
        }else if(filosofo1.isFaminto()){
            imgFilosofo1.setImageResource(R.mipmap.esperando);
            btnComecar1.setVisibility(View.INVISIBLE);
        }
        /*Estado talher Esquerdo*/
        if(filosofo1.getTalherEsquerdo() != null){
            if(filosofo1.getTalherEsquerdo().isLimpo()){
                talherE1.setBackgroundColor(getColor(R.color.verde_azulado));
            }else{
                talherE1.setBackgroundColor(getColor(R.color.amarelo));
            }
        }else{
            talherE1.setBackgroundColor(getColor(R.color.white));
        }
        /*Estado talher Direito*/
        if(filosofo1.getTalherDireito() != null){
            if(filosofo1.getTalherDireito().isLimpo()){
                talherD1.setBackgroundColor(getColor(R.color.verde_azulado));
            }else{
                talherD1.setBackgroundColor(getColor(R.color.amarelo));
            }
        }else{
            talherD1.setBackgroundColor(getColor(R.color.white));
        }
        /*Token esquerdo*/
        if(filosofo1.getTokenEsquerdo() != null){
            tokenE1.setBackgroundColor(getColor(R.color.verde));
        }else{
            tokenE1.setBackgroundColor(getColor(R.color.white));
        }
        /*Token Direito*/
        if(filosofo1.getTokenDireito() != null){
            tokenD1.setBackgroundColor(getColor(R.color.verde));
        }else{
            tokenD1.setBackgroundColor(getColor(R.color.white));
        }
    }
    /**
     * Verifica o estado do filósofo 2
     * */
    private void stateFilosofo2(){
        /*Estado do filósofo*/
        if(filosofo2.isDormindo()){
            imgFilosofo2.setImageResource(R.mipmap.pensando1);
            btnComecar2.setVisibility(View.VISIBLE);
            btnParar2.setVisibility(View.INVISIBLE);
        }else if(filosofo2.isComendo()){
            imgFilosofo2.setImageResource(R.mipmap.comendo);
            btnComecar2.setVisibility(View.INVISIBLE);
            btnParar2.setVisibility(View.VISIBLE);
        }else if(filosofo2.isFaminto()){
            imgFilosofo2.setImageResource(R.mipmap.esperando);
            btnComecar2.setVisibility(View.INVISIBLE);

        }
        /*Estado talher Esquerdo*/
        if(filosofo2.getTalherEsquerdo() != null){
            if(filosofo2.getTalherEsquerdo().isLimpo()){
                talherE2.setBackgroundColor(getColor(R.color.verde_azulado));
            }else{
                talherE2.setBackgroundColor(getColor(R.color.amarelo));
            }
        }else{
            talherE2.setBackgroundColor(getColor(R.color.white));
        }
        /*Estado talher Direito*/
        if(filosofo2.getTalherDireito() != null){
            if(filosofo2.getTalherDireito().isLimpo()){
                talherD2.setBackgroundColor(getColor(R.color.verde_azulado));
            }else{
                talherD2.setBackgroundColor(getColor(R.color.amarelo));
            }
        }else{
            talherD2.setBackgroundColor(getColor(R.color.white));
        }
        /*Token esquerdo*/
        if(filosofo2.getTokenEsquerdo() != null){
            tokenE2.setBackgroundColor(getColor(R.color.verde));
        }else{
            tokenE2.setBackgroundColor(getColor(R.color.white));
        }
        /*Token Direito*/
        if(filosofo2.getTokenDireito() != null){
            tokenD2.setBackgroundColor(getColor(R.color.verde));
        }else{
            tokenD2.setBackgroundColor(getColor(R.color.white));
        }
    }
    /**
     * Verifica o estado do filósofo 3
     * */
    private void stateFilosofo3(){
        /*Estado do filósofo*/
        if(filosofo3.isDormindo()){
            imgFilosofo3.setImageResource(R.mipmap.pensando1);
            btnComecar3.setVisibility(View.VISIBLE);
            btnParar3.setVisibility(View.INVISIBLE);
        }else if(filosofo3.isComendo()){
            imgFilosofo3.setImageResource(R.mipmap.comendo);
            btnComecar3.setVisibility(View.INVISIBLE);
            btnParar3.setVisibility(View.VISIBLE);
        }else if(filosofo3.isFaminto()){
            imgFilosofo3.setImageResource(R.mipmap.esperando);
            btnComecar3.setVisibility(View.INVISIBLE);

        }
        /*Estado talher Esquerdo*/
        if(filosofo3.getTalherEsquerdo() != null){
            if(filosofo3.getTalherEsquerdo().isLimpo()){
                talherE3.setBackgroundColor(getColor(R.color.verde_azulado));
            }else{
                talherE3.setBackgroundColor(getColor(R.color.amarelo));
            }
        }else{
            talherE3.setBackgroundColor(getColor(R.color.white));
        }
        /*Estado talher Direito*/
        if(filosofo3.getTalherDireito() != null){
            if(filosofo3.getTalherDireito().isLimpo()){
                talherD3.setBackgroundColor(getColor(R.color.verde_azulado));
            }else{
                talherD3.setBackgroundColor(getColor(R.color.amarelo));
            }
        }else{
            talherD3.setBackgroundColor(getColor(R.color.white));
        }
        /*Token esquerdo*/
        if(filosofo3.getTokenEsquerdo() != null){
            tokenE3.setBackgroundColor(getColor(R.color.verde));
        }else{
            tokenE3.setBackgroundColor(getColor(R.color.white));
        }
        /*Token Direito*/
        if(filosofo3.getTokenDireito() != null){
            tokenD3.setBackgroundColor(getColor(R.color.verde));
        }else{
            tokenD3.setBackgroundColor(getColor(R.color.white));
        }
    }
}
