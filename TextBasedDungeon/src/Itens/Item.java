package Itens;

public abstract class Item 
{
    private int chanceDrop;
    private String nome;
    private int dano;
    private int vida;

    
    public int getChanceDrop() 
    {
        return chanceDrop;
    }

    public void setChanceDrop(int chanceDrop) 
    {
        this.chanceDrop = chanceDrop;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public int getDano() 
    {
        return dano;
    }

    public void setDano(int dano) 
    {
        this.dano = dano;
    }

    public int getVida() 
    {
        return vida;
    }

    public void setVida(int vida) 
    {
        this.vida = vida;
    }
    
    
}
