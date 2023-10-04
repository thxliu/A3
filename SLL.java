public class SLL<T> {

    private NodeSL<T> head;
    private NodeSL<T> tail;

    public SLL(){
        this.head = null;
        this.tail = null;
    }

    /** 
   *  Accessor for head node
   *  @return the head node
   */
    public NodeSL<T> getHead(){
        return head;
    }

    /** 
   *  Accessor for tail node
   *  @return the tail node
   */
    public NodeSL<T> getTail(){
        return tail;
    }

    /** 
   *  Determines whether a list is empty
   *  @return T/F is the list empty?
   */
    public boolean isEmpty(){
        return head == null;
    }

    /** 
   *  Inserts the given item at the head of the list
   *  @param v item to insert 
   */
    public void addFirst(T v){
        NodeSL<T> newNode = new NodeSL<T>(v, null);

        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.setNext(head);
            head = newNode;
        }
    }

    /** Converts to a string representation */
    public String toString(){
        String result = "[";

        for (NodeSL<T> item = this.head; item != null; item = item.getNext()) {
            result += item.getData();

            if (item.getNext() != null){
                result += ", ";
            }
          }
        result += "]";

        return result;
    }

/** 
   *  Removes the given item from the head of the list
   *  @return v item removed
   */
    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        T item = head.getData();
        head = head.getNext();
        return item;
    }

    /** 
   *  Inserts the given item at the tail of the list
   *  @param item to insert 
   */
    public void addLast(T v){
        NodeSL<T> newNode = new NodeSL<>(v, null);

        if (isEmpty()){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.setNext(newNode);
            tail = newNode;
        }

    }

    /** 
   *  Removes the given item from the tail of the list
   *  @return item removed
   */
    public T removeLast(){
        T removedData;

        if (isEmpty()){
            throw new IllegalArgumentException("Invalid argument - empty list");
        }

        if (head == tail){
            removedData = head.getData();
            head = null;
            tail = null; 
        }
        else{
            NodeSL<T> previousNode = head;
            removedData = tail.getData();
            while (previousNode.getNext() != tail){
                previousNode = previousNode.getNext();
            }
            tail = previousNode;
            previousNode.setNext(null);
        }

        return removedData;
    }

    /** 
   *  Inserts the given item after the specified node
   *  @param here node to insert after
   *  @param v item to insert 
   */
    public void addAfter(NodeSL<T> here, T v){
        NodeSL<T> newNode = new NodeSL<T>(v, here);
        if (here != null){
            newNode.setNext(here.getNext());
            here.setNext(newNode);

            if (tail == here){
                tail = newNode;
            }
        }
        else{
            throw new IllegalArgumentException("Invalid position - node is null");
        }
    }

    /** 
   *  Removes the node after the given position
   *  @param here marks position to remove after
   *  @return item removed
   */
    public T removeAfter(NodeSL<T> here){
        NodeSL<T> removedNode = here.getNext();
        
        if (here == null){
            if (head == null){
                throw new IllegalArgumentException("Invalid argument - list is empty");
            }

            T removedData = head.getData();
            head = head.getNext();

            if (head == null){
                tail = null;
            }
            return removedData;
        }

        if (removedNode == null){
            throw new IllegalArgumentException("Invalid argument - no node to remove");
        }
        T removedData = removedNode.getData();
        here.setNext(removedNode.getNext());

        if (tail == removedNode){
            tail = here;
        }

        return removedData;
    }

    /**
   *  Returns a count of the number of elements in the list
   *  @return current number of nodes
   */
  public int size(){
    return 0;
  }

  /** 
   *  Makes a copy of elements from the original list
   *  @param here  starting point of copy
   *  @param n  number of items to copy
   *  @return the copied list
   */
  public SLL<T> subseqByCopy(NodeSL<T> here, int n){
    return null;
  }

  /**
   *  Places copy of the provided list into this after the specified node.
   *  @param list  the list to splice in a copy of
   *  @param afterHere  marks the position in this where the new list should go
   */
  public void spliceByCopy(SLL<T> list, NodeSL<T> afterHere){
    
  }

/** 
   *  Extracts a subsequence of nodes and returns them as a new list
   *  @param afterHere  marks the node just before the extraction
   *  @param toHere  marks the node where the extraction ends
   *  @return  the new list
   */
  public SLL<T> subseqByTransfer(NodeSL<T> afterHere, NodeSL<T> toHere){
    return null;
  }

/** 
   *  Takes the provided list and inserts its elements into this
   *  after the specified node.  The inserted list ends up empty.
   *  @param list  the list to splice in.  Becomes empty after the call
   *  @param afterHere  Marks the place where the new elements are inserted
   */
  public void spliceByTransfer(SLL<T> list, NodeSL<T> afterHere){
    
  }
}
