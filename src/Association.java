public class Association<K, V> {
    protected K key;
    protected V value;

    public Association(K key, V value){
        this.key=key;
        this.value=value;
    }

    public V getValue(){
        return value;
    }

    public K getKey(){
        return key;
    }

}
