public class Cliente {

	public static void main(String[] args) {

		Arvore_AVL avl = new Arvore_AVL();
		
		avl.setNumeroAVL(45);
	
		avl.setNumeroAVL(35);
		avl.setNumeroAVL(60);
		avl.setNumeroAVL(50);
		avl.setNumeroAVL(41);
		avl.setNumeroAVL(70);
		avl.setNumeroAVL(28);
		avl.setNumeroAVL(27);
		avl.setNumeroAVL(30);
		avl.setNumeroAVL(40);
		avl.setNumeroAVL(42);
		avl.setNumeroAVL(29);

		
		avl.exibirAVL();
		
		avl.buscaBinaria(40);

		
	}

}
