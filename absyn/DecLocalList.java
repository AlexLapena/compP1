package absyn;

public class DecLocalList {
  public Dec head;
  public DecLocalList tail;
  public DecLocalList(Dec head, DecLocalList tail) {
    this.head = head;
    this.tail = tail;
  }
}
