import java.util.Random;

public class MyTestingClass {
    private int id;

    public MyTestingClass(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        // Custom hashCode implementation
        // You can modify this implementation based on your requirements
        return id % 10; // Modulo 10 to distribute elements across buckets
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MyTestingClass other = (MyTestingClass) obj;
        return id == other.id;
    }

    @Override
    public String toString() {
        return "MyTestingClass{" +
                "id=" + id +
                '}';
    }
}

public class MyHashTableTest {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();

        // Add random 10,000 elements to the hash table
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(i);
            Student value = new Student("Student " + i);
            table.put(key, value);
        }

        // Count the number of elements in each bucket
        int[] bucketSizes = new int[table.M];
        for (int i = 0; i < table.M; i++) {
            HashNode<MyTestingClass, Student> currentNode = table.chainArray[i];
            while (currentNode != null) {
                bucketSizes[i]++;
                currentNode = currentNode.next;
            }
        }

        // Print the number of elements in each bucket
        for (int i = 0; i < table.M; i++) {
            System.out.println("Bucket " + i + ": " + bucketSizes[i] + " elements");
        }
    }
}