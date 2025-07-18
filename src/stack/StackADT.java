package stack;

public interface StackADT<T> {
    // 원소 추가
    void push(T t);

    // 원소 삭제 (맨 위)
    void pop();

    // 맨 위의 원소 반환
    T top();

    // Stack 길이 출력
    T length();

    // Stack이 비었으면 true, 아니면 else
    boolean isEmpty();

    // Stack 초기화
    void clear();

    // Stack의 모든 원소 출력
    void printStack();
}
