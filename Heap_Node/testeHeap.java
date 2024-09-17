package Heap_Node;

public class testeHeap {
    public static void main(String[] args) {
        HeapNode heap = new HeapNode();
        heap.insert(5, "algo");
        heap.insert(2, "algo");
        heap.insert(1, "algo");
        heap.insert(8, "algo");
        heap.insert(9, "algo");
        heap.insert(9, "algo");

        System.out.println("");
        heap.printTree(heap.root(), "", false);
        heap.Emordem(heap.root());

    }
    
}
