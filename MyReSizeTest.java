public class MyReSizeTest {
    public static void main(String[] args) {
        MyHashTable<String, Integer> hashTable = new MyHashTable<>(4);

        for (int i = 0; i < 10; i++) {
            String key = "Key" + i;
            int value = i;
            hashTable.put(key, value);
            System.out.println("Inserted: " + key);
            System.out.println("Size: " + hashTable.size + ", Capacity: " + hashTable.M);
            System.out.println();
        }
    }
}
