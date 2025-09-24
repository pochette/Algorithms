package CollectionsMethods;

public class Student implements Comparable <Student> {
    private final String name;
    private final int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public int compareTo(Student o) {
        final int nameComparison = String.CASE_INSENSITIVE_ORDER.compare(this.name, o.name);
        if(nameComparison != 0) {
            return nameComparison;
        } else {
            return Integer.compare(this.age, o.age);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
