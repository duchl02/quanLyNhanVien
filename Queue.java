package quanLyNhanVien;

import java.util.ArrayList;


public class Queue<T> {

  private int size = 0;
  ArrayList<T> queueArray = new ArrayList<T>();

  public void add(T element) {
    queueArray.add(element);
  }

  public T remove() {
    T value = null;
    size = queueArray.size();
    if (size == 0) {
      return null;
    }
    try {
      value = queueArray.get(0);
      queueArray.remove(0);
    } catch (Exception e) {
      System.out.println(e);
    }

    return value;
  }


  public T peek() {
    size = queueArray.size();
    if (size == 0) {
      return null;
    }
    return queueArray.get(0);
  }

  public T poll() {
    T value = null;
    try {
      value = queueArray.get(0);
      queueArray.remove(0);
    } catch (ArithmeticException e) {
      return null;
    }
    return value;
  }

  public Boolean isEmpty() {
    return queueArray.size() == 0;
  }

  public void show() {
    this.queueArray.forEach(p -> System.out.println(p));
  }

  public int size() {
    return queueArray.size();
  }

  public T get(int index) {
    return queueArray.get(index);

  }

  public void delete(int index) {
    try {
      queueArray.remove(index);

    } catch (Exception e) {
      System.out.println("Đã có lỗi xảy ra");
    }
  }
}
