package main;

import bridges.base.SLelement;

public class MyList<E extends Mapable> implements SimpleList<E> {

  private SLelement<E> head;
  private SLelement<E> tail;
  private int size;

  public MyList() {
    head = null;
    tail = null;
    size = 0;
  }

  @Override
  public void add(E e) throws IllegalArgumentException {
    if (e == null) {
      throw new IllegalArgumentException("A null element is not allowed.");
    } else {
      SLelement<E> adding =
          new SLelement<E>(
              String.format(
                  "%s : %.2fM total hours watched",
                  e.getLable(), (double) e.getWatched() / 1000000),
              e);
      adding.setColor(e.getColor());
      adding.setSize(e.getSize());
      if (isEmpty()) {
        head = adding;
        tail = adding;
        size++;
      } else {
        tail.setNext(adding);
        tail = tail.getNext();
        size++;
      }
    }
  }

  public void thing() {
    SLelement<E> curr = head;
    while (curr.getNext() != null) {
      curr.getLinkVisualizer(curr.getNext()).setThickness(5);
      curr.getLinkVisualizer(curr.getNext()).setColor("orange");
      curr = curr.getNext();
    }
  }

  @Override
  public E remove(E e) throws IllegalArgumentException {
    if (isEmpty()) {
      throw new IllegalArgumentException("List is empty.");
    } else if (e == null) {
      throw new IllegalArgumentException("A null element is not allowed.");
    } else {
      SLelement<E> node = head;
      while (node.getNext() != null) {
        if (node.getNext().getValue() == e) {
          node.setNext(node.getNext().getNext());
          return node.getValue();
        }
        node = node.getNext();
      }
    }
    return null;
  }

  /**
   * Performs a linear search to find.
   *
   * @author Christopher
   * @author Yasseen
   * @param E e : represents node element data.
   * @param int cutOff : represents cutOff rank for linear search
   */
  @Override
  public void search(E e) throws IllegalArgumentException {
    if (e == null) {
      throw new IllegalArgumentException("A null element is not allowed.");
    } else {
      SLelement<E> node = head;
      if (indexOf(e) == -1) {
        while (node.getNext() != null) {
          node.getLinkVisualizer(node.getNext()).setThickness(10);
          node.getLinkVisualizer(node.getNext()).setColor("orange");
          node = node.getNext();
        }
        return;
      }

      while (node.getValue().getRank() < e.getRank()) {
        node.getLinkVisualizer(node.getNext()).setThickness(10);
        node.getLinkVisualizer(node.getNext()).setColor("orange");
        node = node.getNext();
      }
    }
  }

  @Override
  public E get(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException("Index out of bounds!!");
    } else {
      SLelement<E> curr = head;
      for (int i = 0; i < index; i++) {
        curr = curr.getNext();
      }
      return curr.getValue();
    }
  }

  // why did we do all of this in the first place.
  @Override
  public int indexOf(E target) throws IllegalArgumentException {
    if (target == null) {
      throw new IllegalArgumentException("A null element is not allowed.");
    } else {
      SLelement<E> node = head;
      int index = 0;
      while (node != null) {
        if (node.getValue().getRank() == target.getRank()) {
          return index;
        }
        node = node.getNext();
        index++;
      }
    }
    return -1;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return head == null;
  }

  public SLelement<E> getHead() {
    return head;
  }
}
