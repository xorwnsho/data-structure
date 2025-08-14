package deque;

public interface DequeADT<E> {

    // 맨 앞에 요소 추가
    void addFront(E e);

    // 맨 뒤에 요소 추기
    void addRear(E e);

    // 맨 앞의 요소 삭제 후 반환
    E deleteFront();

    // 맨 뒤의 요소 삭제 후 반환
    E deleteRear();

    // 비었는지
    boolean isEmpty();

    int size();

    // 모든 원소 삭제
    void clear();
}
