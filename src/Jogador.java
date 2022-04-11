import java.util.Scanner;

public class Jogador {
	String nome;
	String marcador;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarcador() {
		return marcador;
	}
	public void setMarcador(String marcador) {
		this.marcador = marcador;
	}
	
	//Construtor da classe para setar o nome do jogar e o marcador dele
	Jogador(String nome, String marcador){
		this.nome = nome;
		this.marcador = marcador;
	}

	//Realiza as jogadas lendo a posição que o usuario quer
	public void jogar(Tabuleiro tabuleiro) {
		Boolean verificador = false;
		Scanner scan = new Scanner(System.in);
		if(!tabuleiro.verificaVitoria() | !tabuleiro.verificaEmpate()) {
		
			//Repete até digitar uma posição válida
		while(!verificador) {
			System.out.println("Digite a posição: (1-9)");
			int jogada = scan.nextInt();
			if(jogada > 0 & jogada < 10) {
				if(tabuleiro.jogar(jogada, this.marcador)) {
					verificador = true;
				}
			}
		}
		}
	}
}
