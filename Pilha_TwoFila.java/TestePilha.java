public class TestePilha {

	public static void main(String[] args) {		
		PilhaTwoFila pp = new PilhaTwoFila();
		System.out.println("inserindo");
		for(int f=0;f<10;f++){
		  System.out.println(f);		  
		  pp.push(f);
		}
		System.out.println("retirando");
		for(int f=0;f<10;f++){
			  System.out.print(f);
			  System.out.println(" - "+pp.pop());
		}
	}
}
