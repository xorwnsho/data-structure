package stack;

public interface StackADT<E> {
    // 원소 추가
    void push(E t);

    // 원소 삭제 (맨 위)
    E pop();

    // 맨 위의 원소 확인
    E peek();

    // Stack 길이 출력
    int size();

    // Stack이 비었으면 true, 아니면 else
    boolean isEmpty();

    // Stack 초기화
    void clear();

    boolean isFull();
}
