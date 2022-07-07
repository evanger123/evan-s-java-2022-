class node<t>{
    private t value;
    private node<t> next;
    public t getValue(){
        return value;
    }
    public node<t> getNext(){
        return next;
    }
    public void setValue(t newVal){
        value = newVal;
    }
    public void setNext(node<t> newNext){
        next = newNext;
    }
    public node(node<t> next, t value){
        this.value = value;
        this.next = next;
    }
    @Override public String toString(){
        return value+"";
    }
}
class linklist<t>{
    private int size;
    private node<t> head;
    public linklist(){
        size = 0;
        head = null;
    }
    public t get(int index){
        node<t> current = head;
        if (head == null){
            throw new IndexOutOfBoundsException("no list");
        }
        for (int i = 0; i<index; i++){
            current = current.getNext();
        }
        return current.getValue();
    }
    public int getSize(){
        return size;
    }
    public void add(t newNode){
        node<t> current = head;
        if (head == null){
            head = new node<t>(null, newNode);
        }
        else{
            while(current.getNext()!=null){
                current = current.getNext();
            }
            current.setNext(new node<t>(null, newNode)); 
        }
        size+=1;
    }
    public t remove(int position){
        node<t> current = head;
        if (position==0){
            node<t> removed = head;
            head = current.getNext();
            size-=1;
            return removed.getValue();       
        }
        if (position==size){
            for (int i = 0; i<position-1; i++){
                current = current.getNext();
            }
            node<t> removed = current.getNext();
            current.setNext(null);
            size-=1;
            return(removed.getValue());
        }
        for (int i = 0; i<position-1; i++){
            current = current.getNext();
        }
        node<t> removed = current.getNext();
        current.setNext(current.getNext().getNext());
        size-=1;
        return removed.getValue();

    }
    public void insert(t newNode, int position){
        node<t> current = head;
        if (position>size){
            throw new IndexOutOfBoundsException();
        }
        if(position == 0){
            node<t> toAdd = new node<t>(head, newNode);
            head = toAdd;
            size+=1;
            return;
        }
        for (int i = 0; i<position-1; i++){
            current = current.getNext();
        }
        if(position==size){
            current = current.getNext();
            node<t> toAdd = new node<t>(null, newNode);
            current.setNext(toAdd);
        }
        node<t> toAdd = new node<t>(current.getNext().getNext(), newNode);
        current.setNext(toAdd);
        size+=1;
    }
    @Override public String toString(){
        node<t> current = head;
        String values = ""; 
        while(current!=null){
            values = values + current.toString() + " ";
            current = current.getNext();
        }
        return values;
    }
}
public class thing{
    public static void main(String[] args){
        linklist linx = new linklist();
        for (int i = 0; i<11; i++){
            linx.add(i);
            System.out.println(linx);
        }
        linx.insert("thirty four", 0);
        linx.insert("oeu", 11);
        linx.insert(98, 5);
        System.out.println(linx.remove(5));
        System.out.println(linx.remove(0));
        System.out.println(linx.remove(10));
        System.out.println(linx);

    }
}