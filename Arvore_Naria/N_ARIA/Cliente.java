package arvore.naria;

public class Cliente {

	public static void main(String[] args) {

		Arvore_naria n = new Arvore_naria("Como Ser Um Mestre Pokémon");
		
		n.setConteudo("Como Ser Um Mestre Pokémon", "Compre um console");
		
		n.setConteudo("Compre um console", "Nintendo DS");
		n.setConteudo("Compre um console", "3DS");
		n.setConteudo("Compre um console", "Gameboy");
		n.setConteudo("Nintendo DS", "jogue pokémon diamond");
		n.setConteudo("3DS", "jogue pokémon crystal");
		n.setConteudo("Gameboy", "jogue pokémon firered");
		n.setConteudo("jogue pokémon firered", "Realize as missões do jogo");
		n.setConteudo("jogue pokémon crystal", "Realize as missões do jogo");
		n.setConteudo("jogue pokémon diamond", "Realize as missões do jogo");
		
		n.setConteudo("Como Ser Um Mestre Pokémon", "Dicas");
		n.setConteudo("Dicas", "Capture todos os pokémons que você puder");
		n.setConteudo("Dicas", "Nunca se terá um time imbatível");
		n.setConteudo("Dicas", "Não se gabe do quanto você é bom");
		
		
		
		
		
		
		
		

		
	
		
		
		n.exibirArvore();

	}

}
