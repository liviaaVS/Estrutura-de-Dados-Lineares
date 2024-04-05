
public class TestePilha {

	public static void main(String[] args) {		
		PilhaNode pp= new PilhaNode();
		System.out.println("inserindo");
		for(int f=0;f<10;f++){
		  System.out.println(f);		  
		  pp.push(f);
		}
		System.out.println("retirando");
		for(int f=0;f<8;f++){
			  System.out.print(f);
			  System.out.println(" - "+pp.pop());
		}
		Object penultimo = pp.pop();
		// Imprimir o penúltimo elemento
		System.out.println("Penúltimo: " + penultimo);
		// Obter e imprimir o último elemento
		System.out.println("Último: " + pp.top());


	}
}
