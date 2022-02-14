package com.qipeng.general;

/**
 * @author Qp
 * @version 1.0
 * @date 2020/12/10 22:32
 */
public class Pair<T> {

    private T first;
    private T last;

    public Pair() {

    }

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setLast(T last) {
        this.last = last;
    }

    // 静态方法
    // 泛型类型<T>不能用于静态方法
    // 在static修饰符后面加一个<T>，可以使编译通过
    // 但是这个<T>和Pair<T>类型的<T>已经没有任何关系了
    public static <T> Pair<T> create(T first, T last) {
        return new Pair<>(first, last);
    }

    // 对于静态方法，可以单独改写为“泛型”方法，只需要使用另一个类型
    // 区别静态方法的泛型和实例类型的泛型
    public static <E> Pair<E> create2(E first, E last) {
        return new Pair<>(first, last);
    }
}
