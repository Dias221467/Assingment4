import java.util.Objects;

public class MyTestingClass {
    private int value;

    public MyTestingClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + value;
        return result;
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
        return value == other.value;
    }

    @Override
    public String toString() {
        return "MyTestingClass{" +
                "value=" + value +
                '}';
    }
}
