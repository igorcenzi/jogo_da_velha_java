public class Tabuleiro {
    String board[] = new String[9];
    String ganhador = "";


    //Construtor para preencher o tabuleiro
    Tabuleiro(){
        iniciaTabuleiro();
        exibeTabuleiro();
    }
    
    //inicia as posições do tabuleiro com espaço vazio
    public void iniciaTabuleiro() {
    	for (int i = 0; i < 9; i++) {
            board[i] = " ";
        }
    }

    public String[] getBoard() {
		return board;
	}

	public void setBoard(String[] board) {
		this.board = board;
	}

	//exibe o tabuleiro na tela
	public void exibeTabuleiro(){
        System.out.println("1[" + board[0] +"] " + "2[" + board[1] +"] " + "3[" + board[2] +"]");
        System.out.println("4[" + board[3] +"] " + "5[" + board[4] +"] " + "6[" + board[5] +"]");
        System.out.println("7[" + board[6] +"] " + "8[" + board[7] +"] " + "9[" + board[8] +"]");
    }

    //Verifica se a posição jogada está disponível
    public Boolean verificaJogada(int jogada){
        if(!board[jogada].equals(" ")){
            return false;
        }else{
            return true;
        }
    }
    
    //Função que faz a jogada no tabuleiro, chama a função verificaJogada pra saber se o movimento é válido
    //logo em seguida exibe o tabuleiro na tela
    public Boolean jogar(int jogada, String marcador) {
    	if(verificaJogada(jogada-1)) {
    		board[jogada-1] = marcador;
    		exibeTabuleiro();
    		return true;
    	}
    	return false;
    }
    
    public Boolean verificaVitoria() {
    	//verifica se algum jogador ganhou
    	//Faz as verificações de linha e colunas, se as posições forem iguais e diferente de vazias,
    	//ele retorna true para vitória
    	if(board[0].equals(board[1]) & board[0].equals(board[2]) & !board[0].equals(" ")) {
    		this.setGanhador(board[0]);
    		return true;
    	}else if(board[3].equals(board[4]) & board[3].equals(board[5]) & !board[3].equals(" ")) {
    		this.setGanhador(board[3]);
    		return true;
    	}else if(board[6].equals(board[7]) & board[6].equals(board[8]) & !board[6].equals(" ")) {
    		this.setGanhador(board[6]);
    		return true;
    	}else if(board[0].equals(board[4]) & board[0].equals(board[8]) & !board[0].equals(" ")) {
    		this.setGanhador(board[0]);
    		return true;
    	}else if(board[2].equals(board[4]) & board[2].equals(board[6]) & !board[2].equals(" ")) {
    		this.setGanhador(board[2]);
    		return true;
    	}else if(board[0].equals(board[3]) & board[0].equals(board[6]) & !board[0].equals(" ")) {
    		this.setGanhador(board[0]);
    		return true;
    	}else if(board[1].equals(board[4]) & board[1].equals(board[7]) & !board[1].equals(" ")) {
    		this.setGanhador(board[1]);
    		return true;
    	}else if(board[2].equals(board[5]) & board[2].equals(board[8]) & !board[2].equals(" ")) {
    		this.setGanhador(board[2]);
    		return true;
    	}
    	
    	return false;
    }
    
    public String getGanhador() {
		return ganhador;
	}

	public void setGanhador(String ganhador) {
		this.ganhador = ganhador;
	}

	//Verifica se tem alguma casa livre, caso não tenha ele retorna true para empate
    public Boolean verificaEmpate() {
    	for(int i = 0; i<9; i++) {
    		if(this.board[i].equals(" ")) {
    			return false;
    		}
    	}
    	System.out.println("Empatou");
    	return true;
    }

}
