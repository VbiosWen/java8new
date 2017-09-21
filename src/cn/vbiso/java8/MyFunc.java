package cn.vbiso.java8;

@FunctionalInterface
public interface MyFunc<T> {
    public Integer getValue(T num);
}
