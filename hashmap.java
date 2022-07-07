import java.util.ArrayList;
class entry<k, v>{
    private k key;
    private v value;
    private entry<k, v> nextEntry;
    public entry(k key, v value){
        this.key = key;
        this.value = value;
    }
    
    public k getKey(){
        return key;
    }
    public void setKey(k keyInput){
        key = keyInput; 
    }
    public v getValue(){
        return value;
    }
    public void setValue(v valueInput){
        value = valueInput;
    }
    public entry<k, v> getNextEntry(){
        return nextEntry;
    }
    public void setNextEntry(entry<k, v> nextEntryInput){
        nextEntry = nextEntryInput;
    }
}
public class hashmap<k, v>{
    private int capacity;
    private ArrayList<entry<k, v>> table;
    public hashmap(int capacityInput){
        capacity = capacityInput;
        this.table = new ArrayList<entry<k, v>>();
        for(int i = 0; i<capacityInput; i++){
            table.add(null);
        }
    }
    public void put(k key, v value){
        if (table.get(hash(key))==null){
            table.set(hash(key), new entry<k, v>(key, value));
        }
        else{
            entry<k,v> current = table.get(hash(key));
            while (current.getNextEntry()!=null){
                current = current.getNextEntry();
            }
            current.setNextEntry(new entry<k, v>(key, value));
        }
    }
    public v get(k key){
        entry<k, v> current = table.get(hash(key));
        while (current.getNextEntry()!=null && current.getKey()!=key){
            current = current.getNextEntry();
        }
        return current.getValue();
    }
    public int hash(k key){
        return key.hashCode()%capacity;
    }
    public static void main(String[] args){
        hashmap<String, Integer> map = new hashmap<String, Integer>(12);
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);
        System.out.println(map.get("c"));
    }
    
}
