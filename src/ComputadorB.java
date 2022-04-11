import java.util.Random;

public class ComputadorB extends Computador{

	//Construtor da superclasse
	ComputadorB(String marcador) {
		super(marcador);
	}
	
	//Faz jogadas em posições aleatórias
	public void jogar(Tabuleiro tabuleiro) {
		Random rand = new Random();
		Boolean verificador = false;
		int random;
		//Executa até sortear uma casa válida para a jogada
		while(!verificador) {	
			random = rand.nextInt(9) + 1;
			if(tabuleiro.jogar(random, super.marcador)) {
				verificador = true;
			}
			
		}
	}
	
}
