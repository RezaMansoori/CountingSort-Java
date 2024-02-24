package ac.um.ds;

public class CountingSort<T extends IntegerKeyType> {

    private short K;

    public CountingSort(short K) {
        this.K = K;
    }

    public void sort(T[] A) {
        int[] C = new int[this.K + 1];
        T[] B = (T[]) new IntegerKeyType[A.length];
        for (int i = 0; i < C.length; i++) {
            C[i] = 0;
        }
        for (int i = 0; i < A.length; i++) {
            C[A[i].getKey()] = C[A[i].getKey()] + 1;
        }
        for (int i = 1; i < C.length; i++) {
            C[i] = C[i] + C[i - 1];
        }
        for (int i = A.length - 1; i > -1; i--) {
            B[C[A[i].getKey()]-1] = A[i];
            C[A[i].getKey()] = C[A[i].getKey()] - 1;
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = B[i];
        }
    }

}
