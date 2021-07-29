package Itens;


public class AmuletoDano extends Item
{
    private int danoMinimo;
    
    public AmuletoDano(int chanceDeDrop, int danoMinimo, String nome)
    {
        setChanceDrop(chanceDeDrop);
        setDanoMinimo(danoMinimo);
        setNome(nome);
    }

    
    public int getDanoMinimo() {
        return danoMinimo;
    }

    
    public void setDanoMinimo(int danoMinimo) {
        this.danoMinimo = danoMinimo;
    }
}
