package TextBased;

import Inimigos.Inimigos;
import Itens.AmuletoDano;
import Itens.ColeteDeCouro;
import Itens.EspadaLonga;
import Itens.Item;
import Itens.PocaoDeVida;
import Itens.UltimoSuspiro;
import static TextBased.TextBasedMain.amuletoDanoEquipado;
import static TextBased.TextBasedMain.coleteEquipado;
import static TextBased.TextBasedMain.danoAtaquePlayer;
import static TextBased.TextBasedMain.danoMinimo;
import static TextBased.TextBasedMain.espadaEquipada;
import static TextBased.TextBasedMain.pocoesVida;
import static TextBased.TextBasedMain.qntUltimoSuspiro;
import static TextBased.TextBasedMain.rand;
import static TextBased.TextBasedMain.vidaAtual;
import static TextBased.TextBasedMain.vidaMax;


public class ChanceDrop 
{
    public static void ChanceDeDrop(Inimigos inimigo)
    {
        //Itens possiveis de serem dropados
        EspadaLonga espadaLonga = new EspadaLonga(30, 60, "Espada Longa");
        PocaoDeVida pocao = new PocaoDeVida(50, "Poção de Cura");
        ColeteDeCouro colete = new ColeteDeCouro(30, 50, "Colete De Couro");
        AmuletoDano amuletoDano = new AmuletoDano(40, 10, "Amuleto Do Guerreiro");
        UltimoSuspiro ultimoSuspiro = new UltimoSuspiro(10, "Ultimo Suspiro");
        
        //Switch para ver qual o inimigo sendo enfrentado e quais possiveis itens ele pode dropar
        if("Esqueleto".equals(inimigo.getNome()))
        {
            Item[] drops = {espadaLonga, pocao};
            
            for (int i = 0; i < drops.length; i++) 
            {
                if (drops[i].getChanceDrop() > rand.nextInt(100)) 
                {
                    System.out.println(" # O " + inimigo.getNome() + " soltou um(a) " + drops[i].getNome() + "! #");
                    if(drops[i].getNome().equals(pocao.getNome()))
                    {
                        pocoesVida++;
                        if(pocoesVida == 1)
                        {
                            System.out.println(" # Voce tem agora " + pocoesVida + " Poção de Vida no inventario! #");
                        }
                        else
                        {
                            System.out.println(" # Voce tem agora " + pocoesVida + " Poções de Vida no inventario! #");
                        }
                    }
                    if(drops[i].getNome().equals(espadaLonga.getNome()) && espadaEquipada == false)
                    {
                        System.out.println(" # Voce equipa a Espada Longa e isso lhe da mais força em combate! #");

                        espadaEquipada = true;
                        danoAtaquePlayer += espadaLonga.getDano();

                        System.out.println(" # Seu dano de ataque maximo é: " + danoAtaquePlayer);
                    }
                    else
                    {
                        System.out.println(" # Voce ja tem uma Espada Longa equipada! #");
                    }
                }
            }
        }
        
        else if("Assassino".equals(inimigo.getNome()))
        {
            Item[]drops = {colete, pocao};
            for (int i = 0; i < drops.length; i++) 
            {
                if (drops[i].getChanceDrop() > rand.nextInt(100)) 
                {
                    System.out.println(" # O " + inimigo.getNome() + " soltou um(a) " + drops[i].getNome() + "! #");
                    if(drops[i].getNome().equals(pocao.getNome()))
                    {
                        pocoesVida++;
                        if(pocoesVida == 1)
                        {
                            System.out.println(" # Voce tem agora " + pocoesVida + " Poção de Vida no inventario! #");
                        }
                        else
                        {
                            System.out.println(" # Voce tem agora " + pocoesVida + " Poções de Vida no inventario! #");
                        }
                    }
                    
                    else if(drops[i].getNome().equals(colete.getNome()) && coleteEquipado == false)
                    {
                        System.out.println(" # Voce equipa o Colete De Couro e isso lhe da uma resistencia extra! #");
                        
                        coleteEquipado = true;
                        vidaMax += colete.getVida();
                        
                        System.out.println(" # Sua vida agora é: " + vidaAtual + "/" + vidaMax);
                    }
                }
            }
        }
        else if("Goblin".equals(inimigo.getNome()))
        {
            Item[]drops = {pocao};
            pocao.setChanceDrop(70);
            if (drops[0].getChanceDrop() > rand.nextInt(100)) 
            {
                System.out.println(" # O " + inimigo.getNome() + " soltou um(a) " + drops[0].getNome() + "! #");
                if(drops[0].getNome().equals(pocao.getNome()))
                {
                    if(pocoesVida == 1)
                    {
                        pocoesVida++;
                        System.out.println(" # Voce tem agora " + pocoesVida + " Poção de Vida no inventario! #");
                    }
                    else
                    {
                        System.out.println(" # Voce tem agora " + pocoesVida + " Poções de Vida no inventario! #");
                    }
                }  
            }
        }
        else if("Zumbi".equals(inimigo.getNome()))
        {
            Item[] drops = {amuletoDano, pocao, ultimoSuspiro};
            for (int i = 0; i < drops.length; i++) 
            {
                if (drops[i].getChanceDrop() > rand.nextInt(100)) 
                {
                    System.out.println(" # O " + inimigo.getNome() + " soltou um(a) " + drops[i].getNome() + "! #");
                    if(drops[i].getNome().equals(pocao.getNome()))
                    {
                        pocoesVida++;
                        if(pocoesVida == 1)
                        {
                            System.out.println(" # Voce tem agora " + pocoesVida + " Poção de Vida no inventario! #");
                        }
                        else
                        {
                            System.out.println(" # Voce tem agora " + pocoesVida + " Poções de Vida no inventario! #");
                        }
                    }
                    
                    else if(drops[i].getNome().equals(amuletoDano.getNome()) && amuletoDanoEquipado == false)
                    {
                        System.out.println(" # Voce equipa o Amuleto Do Guerreiro e isso aumenta sua habilidade! #");
                        
                        amuletoDanoEquipado = true;
                        danoMinimo = 10;
                        
                        System.out.println(" # Seu dano minimo agora é: " + danoMinimo + "! #");
                    }
                    else if(drops[i].getNome().equals(ultimoSuspiro.getNome()))
                    {
                        System.out.println(" # Voce achou o Ultimo Suspiro. Será util em momentos de fraqueza! #");
                        
                        qntUltimoSuspiro++;
                        
                        System.out.println(" # Voce tem " + qntUltimoSuspiro + " chances! #");
                    }
                }
            }
        }
    }
}
