package arvore.naria;

public class Cliente {

	public static void main(String[] args) {

		Arvore_naria n = new Arvore_naria("Como Ser Um Mestre Pok�mon");
		
		n.setConteudo("Como Ser Um Mestre Pok�mon", "Compre um console");
		
		n.setConteudo("Compre um console", "Nintendo DS");
		n.setConteudo("Compre um console", "3DS");
		n.setConteudo("Compre um console", "Gameboy");
		n.setConteudo("Nintendo DS", "jogue pok�mon diamond");
		n.setConteudo("3DS", "jogue pok�mon crystal");
		n.setConteudo("Gameboy", "jogue pok�mon firered");
		n.setConteudo("jogue pok�mon firered", "Realize as miss�es do jogo");
		n.setConteudo("jogue pok�mon crystal", "Realize as miss�es do jogo");
		n.setConteudo("jogue pok�mon diamond", "Realize as miss�es do jogo");
		
		n.setConteudo("Como Ser Um Mestre Pok�mon", "Dicas");
		n.setConteudo("Dicas", "Capture todos os pok�mons que voc� puder");
		n.setConteudo("Dicas", "Nunca se ter� um time imbat�vel");
		n.setConteudo("Dicas", "N�o se gabe do quanto voc� � bom");
		
		
		
		
		
		
		
		

		
	
		
		
		n.exibirArvore();

	}

}
