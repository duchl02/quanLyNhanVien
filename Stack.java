package quanLyNhanVien;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Stack<T> {

  private int size = 0;
  ArrayList<T> stackArray = new ArrayList<T>();

  public void push(T element) {
    stackArray.add(element);
  }

  public T peek() {
    size = stackArray.size();
    if (size == 0) {
      return null;
    }
    return stackArray.get(size - 1);
  }

  public T pop() {
    T value = null;
    try {
      value = stackArray.get(size - 1);
      stackArray.remove(size - 1);
    } catch (ArithmeticException e) {
      System.out.println(e);
    }
    return value;
  }

  public T getTop() throws NoSuchElementException {
    size = stackArray.size();
    if (size == 0) {
      throw new NoSuchElementException("mảng rỗng");
    }
    return stackArray.get(size - 1);
  }

  public void delete(int index) {
    try {
      stackArray.remove(index);

    } catch (Exception e) {
      System.out.println("Đã có lỗi xảy ra");
    }
  }


  public Boolean isEmpty() {
    return stackArray.size() == 0;
  }

  public void show() {
    this.stackArray.forEach(p -> System.out.println(p));
  }

  public int size() {
    return stackArray.size();
  }

  public T get(int index) {
    return stackArray.get(index);

  }

}
