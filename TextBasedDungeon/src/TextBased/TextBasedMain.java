package TextBased;

import Inimigos.Inimigos;
import Itens.PocaoDeVida;
import java.util.Random;
import java.util.Scanner;


public class TextBasedMain 
{
    static Random rand = new Random();
    
    //Variaveis do jogador
    static int vidaMax = 100;
    static int vidaAtual = 0;
    static int danoAtaquePlayer = 30;
    static int pocoesVida = 3;
    static int danoMinimo = 0;
    static int qntUltimoSuspiro = 0;
    
    //Variaveis dos itens
    static boolean espadaEquipada = false;
    static boolean amuletoDanoEquipado = false;
    static boolean coleteEquipado = false;
    
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        
        
        //Inimigos
        Inimigos esqueleto = new Inimigos(70,20, "Esqueleto");
        Inimigos goblin = new Inimigos(50,10, "Goblin");
        Inimigos zumbi = new Inimigos(80,20, "Zumbi");
        Inimigos assassino = new Inimigos(100,20, "Assassino");
        Inimigos orc = new Inimigos(120,30, "Orc");
        Inimigos chefao = new Inimigos(200, 40, "Guardiao Da Masmorra");
        
        //Itens 
        PocaoDeVida pocao = new PocaoDeVida(50, "Poção De Vida");
        
        //Variaveis do Jogo
        Inimigos[] enemies = {esqueleto, esqueleto, goblin, goblin, goblin, zumbi, zumbi, assassino, assassino, orc};
        int inimigosDerrotados = 0;
        
        boolean rodando = true;
        
        vidaAtual = vidaMax;
        
        System.out.println("Boas-Vindas a Masmorra!");
        
        //While que faz o jogo rodar
        JOGO:
        while (rodando) 
        {   
            //Apresentação do Inimigo
            System.out.println("-----------------------------------------");
            Inimigos inimigo;
            
            if(inimigosDerrotados >= 10)
            {
                inimigo = chefao;
                System.out.println("\t# Voce acaba de encontrar o inimigo mais poderoso da masmorra! #");
                System.out.println("\t# Esteja preparado para as consequencias ao seguir em frente! #");
                
            }
            else
            {
                inimigo = enemies[rand.nextInt(enemies.length)];
                System.out.println("\t# Um " + inimigo.getNome() + " apareceu! #\n");
            }
            
            //While que cuida do combate
            OUTER:
            while (inimigo.getVidaAtual() > 0) 
            {   
                //Apresentação dos Status e opções
                System.out.println("\tSua Vida: " + vidaAtual + "/" + vidaMax);
                System.out.println("\tVida do " + inimigo.getNome() + ": " + inimigo.getVidaAtual() + "/" +  inimigo.getVidaMax());
                System.out.println("\n\tO que voce deseja fazer?");
                System.out.println("\t1. Atacar");
                System.out.println("\t2. Beber Uma Poção de Vida");
                System.out.println("\t3. Fugir");
                System.out.println("\t4. Mostrar Status");
                
                String input = scan.nextLine();
                
                //Verificação da escolha do jogador
                switch (input) 
                {
                    //Caso o player decida atacar o inimigo
                    case "1" -> 
                    {
                        
                        int danoCausado = rand.nextInt(danoAtaquePlayer);
                        int danoRecebido = rand.nextInt(inimigo.getDanoAtaque());
                        
                        
                        //Verificação se o jogador tem o item "Amuleto Do Guerreiro" equipado
                        if(amuletoDanoEquipado && danoCausado < danoMinimo)
                        {
                            danoCausado = danoMinimo;
                        }
                        
                        //Calculo dos danos causados por ambos
                        vidaAtual -= danoRecebido;
                        inimigo.setVidaAtual(inimigo.getVidaAtual() - danoCausado);
                        
                        System.out.println("\t> Voce causou " + danoCausado + " de dano no " + inimigo.getNome());
                        System.out.println("\t> Voce recebeu " + danoRecebido + " em resposta!");
                        
                        //Se o jogador tiver menos que 1 de vida, mas possuir um item "Ultimo Suspiro" ele vai poder continuar jogando
                        if(vidaAtual < 1 && qntUltimoSuspiro > 0)
                        {
                            System.out.println("Voce tem " + qntUltimoSuspiro + "Ultimo(s) Suspiro(s) no inventario!");
                            System.out.println("-----------------------------------------");
                            System.out.println("Voce deseja usar 1 Ultimo Suspiro e continuar tentando?");
                            System.out.println("1. Tentar mais uma vez");
                            System.out.println("2. Sair da masmorra");
            
                            String resp = scan.nextLine();
                            
                            while (!resp.equals("1") && !resp.equals("2")) 
                            {                
                                System.out.println("Comando invalido!");
                                resp = scan.nextLine();
                            }
                            
                            if(resp.equals("1"))
                            {
                                vidaAtual += 50;
                                System.out.println("Voce continua na sua aventura!");
                                System.out.println("Sua vida agora é: " + vidaAtual + "/" + vidaMax);
                            }
                            
                            else if(resp.equals("2"))
                            {
                                System.out.println("Voce saiu da masmorra, com um gosto de vitoria da sua aventura!");
                                break;
                            }
                        }
                        
                        //Se a vida do jogador cair abaixo de 1, o codigo sai do While atual e logo em seguida, apresenta a tela de fim de jogo
                        else if (vidaAtual < 1) 
                        {
                            System.out.println("Voce recebeu muito dano e esta muito exausto para continuar!");
                            vidaAtual = 0;
                            break OUTER;
                        }
                        break;
                    }
                    
                    //Caso o jogador escolha beber uma poção
                    case "2" -> 
                    {
                        //Se o jogador tiver poção no inventario
                        if(pocoesVida > 0)
                        {
                            //Apenas podera tomar a poçao se a sua vida não estiver no maximo
                            if(vidaAtual < vidaMax)
                            {
                                vidaAtual += pocao.getQuantidadeCura();
                                pocoesVida--;
                                
                                //Se a vida atual depois da cura for maior que a vida maxima, se torna a vida maxima
                                if(vidaAtual > vidaMax)
                                {
                                    vidaAtual = vidaMax;
                                }
                                
                                //Feedback do que aconteceu para o jogador
                                System.out.println("\t> Voce bebeu uma Poção de Vida que cura " + pocao.getQuantidadeCura() + "."
                                                  + "\n\t> Sua vida agora é: " + vidaAtual + "/" + vidaMax
                                                  + "\n\t> Voce tem " + pocoesVida + " Poções de Vida sobrando.\n");
                            }
                            
                            //Se o jogador ja estiver com a vida cheia
                            else
                            {
                                System.out.println("\n\t> Voce ja esta com a vida cheia! \n");
                            }
                        }
                        
                        //Se o jogador não tiver poção no inventario
                        else
                        {
                            System.out.println("\t> Voce não tem mais Poções de Vida. Derrote inimigos para tentar pegar mais!");
                        }
                    }
                    //Caso o jogador decida fugir do inimigo, o loop sai do combate, e retorna para o começo, achando outro inimigo
                    case "3" -> 
                    {
                        System.out.println("\tVoce fugiu do " + inimigo.getNome() + "!");
                        continue JOGO;
                    }
                    
                    case "4" ->
                    {
                        System.out.println("\tSeus Status: ");
                        System.out.println("\tDano minimo: " + danoMinimo);
                        System.out.println("\tDano maximo: " + danoAtaquePlayer);
                        System.out.println("\tQuantidade de Poções de Vida: " + pocoesVida);
                        System.out.println("\tQuantidade de Ultimo Suspiro: " + qntUltimoSuspiro);
                    }
                    //Caso o jogador digite algo que não esta previsto nas condições propostas
                    default -> System.out.println("Comando invalido!");
                }
            }
            
            //Se o while for quebrado por que a vida do jogador chegou abaixo de 0, ele vem para esse if
            if(vidaAtual < 1)
            {
                System.out.println("Voce manca para fora da masmorra, cansado demais para batalhar.");
                
                //Esse break leva para fora do While JOGO e apresenta a tela de fim de jogo
                break;
            }
            else if(inimigo.getVidaAtual() <= 0)
            {
                if(inimigo.getNome() == chefao.getNome())
                {
                    System.out.println("# Voce derrotou o Guardião! #");
                    System.out.println("# Seu nome entrara para a historia! #");
                    break;
                }
                
                //Feedback da morte do inimigo
                System.out.println("-----------------------------------------");
                System.out.println(" # " + inimigo.getNome() + " foi derrotado! #");
                System.out.println(" # " + "Sua vida: " + vidaAtual + "/" + vidaMax + " #");
                
                
                inimigosDerrotados++;
                
                //Drop
                ChanceDrop.ChanceDeDrop(inimigo);

                //Depois que o combate acaba, o jogador pode decidir se vai continuar ou sair
                System.out.println("-----------------------------------------");
                System.out.println("O que voce quer fazer agora?");
                System.out.println("1. Continuar a explorar");
                System.out.println("2. Sair da masmorra");

                String input = scan.nextLine();

                //Esse While garante que o jogador não digite nada alem do sugerido nas opções
                while (!input.equals("1") && !input.equals("2")) 
                {                
                    System.out.println("Comando invalido!");
                    input = scan.nextLine();
                }

                //Se o jogador decidir continuar, esse if vai manda-lo de volta ao combate
                if(input.equals("1"))
                {
                    System.out.println("Voce continua na sua aventura!");
                }

                //Essa outra condição o manda para a tela de fim de jogo com o break saindo do While JOGO
                else if(input.equals("2"))
                {
                    System.out.println("Voce saiu da masmorra, com um gosto de vitoria da sua aventura!");
                    break;
                }
                inimigo.setVidaAtual(inimigo.getVidaMax());
            }
        }
        
        //Tela de fim de jogo
        System.out.println("#######################");
        System.out.println("# Obrigado por jogar! #");
        System.out.println("#######################");
    }
}
