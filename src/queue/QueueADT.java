package queue;

public interface QueueADT<E> {

    // 마지막에 원소 삽입
    void enqueue(E e);

    // 먼저 들어온 원소 삭제
    void dequeue();

    // 첫 번째 원소 확인
    E first();

    // 마지막 원소 확인
    E rear();

    // 비어 있는 지 확인
    boolean isEmpty();

    // 모든 원소 확인
    void printAll();

    // 모든 원소 삭제
    void dequeueAll();

}
