class tree{
    private binary_node head;
    public tree(){
        this.head = null;
    }
    public void removeNode(int delete){
        head = removeNode(head, delete);
    }
    public binary_node removeNode(binary_node node, int delete){
        if (node.getValue() == delete){
            if (node.getRightChild()==null && node.getLeftChild()==null){
                return null;
            }
            else if(node.getRightChild()!=null && node.getLeftChild()==null){
                return node.getRightChild();
            }
            else if(node.getRightChild()==null && node.getLeftChild()!=null){
                return node.getLeftChild();
            }
            else{
                binary_node tempNode = node.getRightChild();
                while(tempNode.getLeftChild()!=null){
                    tempNode = node.getLeftChild();
                }
                node.setValue(tempNode.getValue());
                return tempNode;
            }
        }
        else if (delete>=node.getValue()){
            node.setRightChild(removeNode(node.getRightChild(), delete));
        }
        else{
            node.setLeftChild(removeNode(node.getLeftChild(), delete));
        }

        return node;
    }
    public void addNode(int nodeInt){
        binary_node toAdd = new binary_node(nodeInt);
        addNode(toAdd, head);
    }
    public void addNode(binary_node newNode, binary_node current){
        if (head==null){
            head=newNode;
            return;
        }
        if (newNode.getValue()>=current.getValue() && current.getRightChild()!=null){
            current = current.getRightChild();
            addNode(newNode, current);
        }
        else if (current.getRightChild()==null){
            current.setRightChild(newNode);
        }
        else if (newNode.getValue()<current.getValue() && current.getLeftChild()!=null){
            current = current.getLeftChild();
            addNode(newNode, current);
        }
        else{
            current.setLeftChild(newNode);
        }   
    }
    public void printTree(){
        printTree(head);
    }
    public void printTree(binary_node current){
        
        if (current.getLeftChild()!=null){
            printTree(current.getLeftChild());
        }
        if (current.getRightChild()!=null){
            printTree(current.getRightChild());
        }
        System.out.println(current.getValue());
    }

}
class binary_node{
    private int value;
    private binary_node leftChild;
    private binary_node rightChild;
    public binary_node(int value){
        this.value = value;
    }
    public binary_node getLeftChild(){
        return leftChild;
    }
    public binary_node getRightChild(){
        return rightChild;
    }
    public int getValue(){
        return value;
    }
    public void setLeftChild(binary_node newChild){
        this.leftChild = newChild;
    }
    public void setRightChild(binary_node newChild){
        this.rightChild = newChild;
    }
    public void setValue(int newValue){
        this.value = newValue;
    }
    @Override public String toString(){
        return value+"";
    }
}
public class binary_search {
    public static void main(String[] args){
        binary_node node = new binary_node(50);
        tree bt = new tree();
        bt.addNode(node, null);
        for (int i = 0; i<10; i++){
            bt.addNode(i);
        }
        bt.removeNode(6);
        bt.printTree();

    }    
}
