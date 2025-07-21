package deque;

public interface DequeADT<E> {

    // 맨 앞에 요소 추가
    void addFirst(E e);

    // 맨 뒤에 요소 추기
    void addRear(E e);

    // 맨 앞의 요소 삭제 후 반환
    E removeFirst();

    // 맨 뒤의 요소 삭제 후 반환
    E removeRear();

    // 맨 앞의 요소 확인
    E getFirst();

    // 맨 뒤의 요소 확인
    E getRear();

    // 비었는지
    boolean isEmpty();

    // 모든 원소 확인
    void printAll();

    // 모든 원소 삭제
    void dequeueAll();
}
