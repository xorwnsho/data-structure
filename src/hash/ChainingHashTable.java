package hash;

import list.linkedlist.LinkedList;

public class ChainingHashTable implements HashTable<Integer> {

    private Integer[] array;
    private int size;

    public ChainingHashTable(int length) {
        array = new Integer[length];
    }

    @Override
    public int hash(Integer integer) {
        // 일차 방정식
        // y = (2 * integer) - 1
        int hashValue = 2 * integer - 1;
        if (hashValue > array.length - 1) {
            throw new ArrayIndexOutOfBoundsException("인덱스 범위를 초과하여 값을 넣으려함.");
        } else {
            return hashValue;
        }
    }

    @Override
    public void insert(Integer integer) {
        // 해시함수 콜

        if (array[hash(integer)] != null) {

        } else {
            array[hash(integer)] = integer;
            size++;
        }
    }

    @Override
    public Integer search(Integer integer) {
        if(array[hash(integer)] == null){
            throw new NullPointerException("입력한 integer에 해당하는 인덱스가 없음");
        }
        return array[hash(integer)];
    }

    @Override
    public void delete(Integer integer) {
        if(array[hash(integer)] > array.length - 1){
            throw new ArrayIndexOutOfBoundsException("인덱스 범위 초과");
        }
        array[hash(integer)] = null;
        size--;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public void clear() {
        array = new Integer[10];
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
