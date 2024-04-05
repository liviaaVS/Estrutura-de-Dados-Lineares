public class testefila {
    
    public static void main(String[] args) {
        FilaNode fn= new FilaNode();
		System.out.println("Enfileirando");

		for(int f=0;f<10;f++){
		  System.out.println(f);		  
		  fn.fileirar(f);
		}
		System.out.println("Desenfileirando");

		for(int f=0;f<5;f++){
			  System.out.println(" - "+fn.Dfileirar());
		}
		System.out.println("Primeiro da fila: " + fn.first());
    }
}
