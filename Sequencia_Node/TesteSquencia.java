public class TesteSquencia {
    public static void main(String[] args) {
        SequenciaNode sequencia = new SequenciaNode();


        sequencia.insertLast(1);
        sequencia.insertLast(2);
        Node x = sequencia.insertLast(3);
        sequencia.insertLast(4);

        int r =  sequencia.rankOF(x);
        System.out.println(r);
        System.out.println(sequencia.atRank(r).getValue());


    }
}
