
public class Computador {
	String marcador;
	
	Computador(String marcador){
		this.marcador = marcador;
	}
	
	//Preenche a primeira casa vazia em ordem crescente
	public void jogar(Tabuleiro tabuleiro) {
		String board[] = tabuleiro.getBoard();
		for(int i = 0; i<9; i++) {
			if(board[i].equals(" ")) {
				tabuleiro.jogar(i+1, this.marcador);
				break;
			}
		}
	}
}
