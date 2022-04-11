import java.util.Scanner;

public class Jogo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Declaração de variáveis necessárias
		Scanner scan = new Scanner(System.in);
		Boolean verificador = false;
		String marcador = "";
		Boolean escolhaDificuldade = false;
		Computador comp = null;
		
		//Pegar nome do jogador
		System.out.println("Digite seu nome: ");
		String name = scan.next();

		//Pega a escolha do jogador entre X e O		
			while(!verificador) {
				System.out.println("Você prefere ser X ou O?");
				marcador = scan.next();
				//Verifica se ele digitou X ou O
				if(marcador.equals("X") | marcador.equals("O")) {
					verificador = true;
				}
			}
			//Instancia um obj do tipo Jogador passando o nome para o construtor
			Jogador jogador = new Jogador(name, marcador);
			verificador=false;
			
			//Escolhe o marcador do computador de acordo com o marcador que o usuário escolheu
			String marcadorComputador = "";
			if(jogador.getMarcador().equals("X")) {
				marcadorComputador = "O";
			}else {
				marcadorComputador = "X";
			}
			
			
			//Escolhe a dificuldade do jogo e instancia o obj de acordo com a escolha
			while(!escolhaDificuldade) {
				try {
			System.out.println("Em qual dificuldade voce quer jogar?");
			System.out.println("1 - Computador A");
			System.out.println("2 - Computador B");
			System.out.println("3 - Computador C");
			int opcao = scan.nextInt();
			if(opcao == 1) {
				comp = new Computador(marcadorComputador);
				escolhaDificuldade = true;
			}else if(opcao == 2) {
				comp = new ComputadorB(marcadorComputador);
				escolhaDificuldade = true;
			}else if(opcao == 3) {
				comp = new ComputadorC(marcadorComputador);
				escolhaDificuldade = true;
			}else {
				System.out.println("Opcao invalida! Escolha novamente!");
			}
			}catch(Exception error) {
					System.out.println("Ocorreu um erro! Escolha novamente!");
				}
			}
			
			//Instancia um novo tabuleiro
			Tabuleiro tabuleiro = new Tabuleiro();
			
			//Executa o jogo até ter uma vitória/derrota ou empate
			while(!tabuleiro.verificaVitoria() & !tabuleiro.verificaEmpate()) {
				System.out.println("Sua vez...");
				jogador.jogar(tabuleiro);
				if(!tabuleiro.verificaVitoria() & !tabuleiro.verificaEmpate()) {
				System.out.println("Vez do computador...");
				comp.jogar(tabuleiro);
				}
			}
			
			//Verifica quem ganhou o jogo e exibe mensagem na tela
			if(tabuleiro.getGanhador().equals(jogador.getMarcador())) {
				System.out.println("Você venceu!");
			}else {
				System.out.println("Você perdeu!");
			}
		}
	}