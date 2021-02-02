package Assignment10;

class SList<T> {

    //store head of linklist
    private Link head;

    //private inner class that generate nodes
    private class Link {
        private T data;
        private Link next;

        Link(T data) {
            this.data = data;
            next = null;
        }
    }

    //Iterator class used to iterate through linked list
    class SListIteratorImplementor implements SListIterator<T> {
        private Link curr, prev;

        SListIteratorImplementor() {
            curr = head;
            prev = null;
        }

        @Override
        public boolean hasNext() {
            if (curr != null) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            T data = curr.data;
            prev = curr;
            curr = curr.next;

            return data;

        }

        @Override
        public void insert(T data) {
            Link newNode = new Link(data);

            //when no node then both curr and prev null
            if (curr == prev) {
                head = newNode;
                curr = head;
            } else if (prev == null) {
                head = newNode;
                head.next = curr;
                curr = head;
            } else {
                prev.next = newNode;
                newNode.next = curr;
                curr = newNode;

            }

        }

        @Override
        public void remove() {
            try {
                if (curr == null) {
                    throw new Exception("no element at current position");
                }
                //removal of first node
                if (prev == null) {
                    head = curr.next;
                    curr = head;
                } else {

                    prev.next = curr.next;
                    curr = prev.next;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    //creade a node with constructor
    SList(T data) {
        head = new Link(data);
    }

    SList() {
        //empty list
    }

    //returning object of iterator class
    SListIterator iterator() {
        return new SListIteratorImplementor();


    }

    @Override
    public String toString() {
        Link node = head;
        String str;
        str = "[ ";
        while (node != null) {
            str += node.data + " ";
            node = node.next;
        }
        str += "]";
        return str;
    }
}