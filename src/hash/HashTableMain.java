package hash;

public class HashTableMain {
    public static void main(String[] args) {
        ArrayHashTable hashTable = new ArrayHashTable(10);

        hashTable.insert(3);
        hashTable.insert(5);
        hashTable.insert(2);
        System.out.println(hashTable);

        hashTable.delete(3);
        System.out.println(hashTable);

        hashTable.insert(1);
        System.out.println(hashTable);

        hashTable.insert(1);
        System.out.println(hashTable.search(4));

    }
}
