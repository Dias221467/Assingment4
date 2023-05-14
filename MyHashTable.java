public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashTable() {
        chainArray = (HashNode<K, V>[]) new HashNode[M];
    }

    @SuppressWarnings("unchecked")
    public MyHashTable(int M) {
        this.M = M;
        chainArray = (HashNode<K, V>[]) new HashNode[M];
    }

    private int hash(K key) {
        return key.hashCode() % M;
    }

    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);

        if (chainArray[index] == null) {
            chainArray[index] = newNode;
        } else {
            HashNode<K, V> curr = chainArray[index];
            while (curr.next != null && !curr.key.equals(key)) {
                curr = curr.next;
            }
            if (curr.key.equals(key)) {
                curr.value = value;
            } else {
                curr.next = newNode;
            }
        }
        size++;
    }

    public V get(K key) {
        int index = hash(key);

        if (chainArray[index] != null) {
            HashNode<K, V> curr = chainArray[index];
            while (curr != null) {
                if (curr.key.equals(key)) {
                    return curr.value;
                }
                curr = curr.next;
            }
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);

        if (chainArray[index] != null) {
            HashNode<K, V> curr = chainArray[index];
            HashNode<K, V> prev = null;
            while (curr != null) {
                if (curr.key.equals(key)) {
                    if (prev == null) {
                        chainArray[index] = curr.next;
                    } else {
                        prev.next = curr.next;
                    }
                    size--;
                    return curr.value;
                }
                prev = curr;
                curr = curr.next;
            }
        }
        return null;
    }

    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> curr = chainArray[i];
            while (curr != null) {
                if (curr.value.equals(value)) {
                    return true;
                }
                curr = curr.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> curr = chainArray[i];
            while (curr != null) {
                if (curr.value.equals(value)) {
                    return curr.key;
                }
                curr = curr.next;
            }
        }
        return null;
    }
}
