
public class ComputadorC extends Computador{

	ComputadorC(String marcador){
		super(marcador);
	}
	
	//Preenche a primeira casa vazia em ordem decrescente
		public void jogar(Tabuleiro tabuleiro) {
			String board[] = tabuleiro.getBoard();
			for(int i = 8; i>=0; i--) {
				if(board[i].equals(" ")) {
					tabuleiro.jogar(i+1, this.marcador);
					break;
				}
			}
		}
	
}
