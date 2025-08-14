package hashtable;

public interface HashTableADT<K, V> {

    // 키와 값을 해시 테이블에 저장
    V put(K key, V value);

    // 키에 맞는 값을 return
    V get(K key);

    // 제거
    V remove(K key);

    // 해당 키가 테이블에 있는지
    boolean containsKey(K key);

    // 테이블 사이즈 리턴
    int size();

    // 테이블이 비었는지
    boolean isEmpty();

}
