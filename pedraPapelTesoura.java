import java.util.Scanner;
import java.util.Random;

public class pedraPapelTesoura {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
 
        int jogarNovamente;
        int jogadaUsuario;
        int jogadaComputador;
        int placarUsuario = 0;
        int placarComputador = 0;
        boolean fim = false;

        System.out.println("Pedra, Papel e Tesoura");
        System.out.println();

        do{
            do{
                //recebe a jogada do usuário
                System.out.println("Escolha a sua jogada");
                System.out.println("1 - Pedra");
                System.out.println("2 - Papel");
                System.out.println("3 - Tesoura");
                jogadaUsuario = scan.nextInt();

                if(jogadaUsuario < 1 || jogadaUsuario > 3) {
                    System.out.println("O número informado não é válido, tente novamente.");
                    System.out.println();
                }
            }while(jogadaUsuario < 1 || jogadaUsuario > 3);
            
            //recebe a jogada do computador
            jogadaComputador = rand.nextInt(3);
            jogadaComputador += 1;

            System.out.println();
            //transforma a jogada em String
            System.out.println("Pedra, papel, tesoura!");
            System.out.println("Você jogou: "+ jogadaToString(jogadaUsuario));
            System.out.println("O computador jogou: "+ jogadaToString(jogadaComputador));

            switch(checaResultado(jogadaUsuario, jogadaComputador)){
                case 1:
                    System.out.println("Os dois fizeram a mesma jogada, o jogo empatou!");
                    System.out.println("Não houve alteração no placar");
                    break;
                case 2:
                    System.out.println("Você venceu!");
                    placarUsuario++;
                    break;
                case 3:
                    System.out.println("Você perdeu!");
                    placarComputador++;
                    break;
            }

            //mostra como está o placar
            System.out.println();
            System.out.println("Placar");
            System.out.println("------------");
            System.out.println("Você: "+ placarUsuario);
            System.out.println("Computador "+ placarComputador);
            
            //verifica se usuário deseja jogar novamente
            System.out.println();
            System.out.println("Deseja jogar novamente?");
            System.out.println("1 - SIM");
            System.out.println("2 - NÃO");
            jogarNovamente = scan.nextInt();
            
            if(jogarNovamente == 2){
                fim = true;
            }
        }while(!fim);
    }

    //transforma o número jogado em String
    private static String jogadaToString(int jogada){
        String escolha = "";

        switch(jogada){
            case 1:
                escolha = "Pedra";
                break;
            case 2:
                escolha = "Papel";
                break;
            case 3:
                escolha = "Tesoura";
                break;
        }

        return escolha;
    }

    //checa se o usuário ou o computador ganhou
    private static int checaResultado(int jogUsuario, int jogComp){
        int resultado;

        if(jogUsuario == jogComp){
            resultado = 1; //empate
        }else if((jogUsuario == 1 && jogComp == 3) || (jogUsuario == 2 && jogComp == 1)
            || (jogUsuario == 3 && jogComp == 2)) {
            
            resultado = 2; //usuário venceu
        }else {
            resultado = 3; //usuário perdeu
        }

        return resultado;
    }
}