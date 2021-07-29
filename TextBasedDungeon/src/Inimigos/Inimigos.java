package Inimigos;


public class Inimigos 
{
    private int vidaMax;
    private int danoAtaque;
    private String nome;
    private int vidaAtual;
    
    
    public Inimigos(int vida, int dano, String nome)
    {
        setVidaMax(vida);
        setDanoAtaque(dano);
        setNome(nome);
        vidaAtual = vidaMax;
    }
    
    
    public int getVidaMax() {
        return vidaMax;
    }

    
    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }

    
    public int getDanoAtaque() {
        return danoAtaque;
    }

    
    public void setDanoAtaque(int danoAtaque) {
        this.danoAtaque = danoAtaque;
    }

    
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public int getVidaAtual() {
        return vidaAtual;
    }

    
    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }
    
}
