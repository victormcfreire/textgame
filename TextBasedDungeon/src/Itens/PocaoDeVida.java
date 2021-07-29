package Itens;

public class PocaoDeVida extends Item
{
    private int quantidadeCura = 30;

    public PocaoDeVida(int chanceDrop, String nome)
    {
        setChanceDrop(chanceDrop);
        setNome(nome);
    }
    
    
    public int getQuantidadeCura() {
        return quantidadeCura;
    }

    public void setQuantidadeCura(int quantidadeCura) {
        this.quantidadeCura = quantidadeCura;
    }
    
}
