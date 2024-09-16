package Heap_Node;

public class testeHeap {
    public static void main(String[] args) {
        HeapNode heap = new HeapNode();
        heap.upHeap(5, "algo");
        heap.upHeap(2, "algo");
        heap.upHeap(1, "algo");


        heap.printTree(heap.root(), "", false);
        heap.Emordem(heap.root());

    }
    
}
