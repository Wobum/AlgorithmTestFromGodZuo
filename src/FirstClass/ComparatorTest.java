package FirstClass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ComparatorTest {
/**
 * @Auther: 81421
 * @Date: 2018/11/11 11:38
 * @Description: 比较器练习。
 */
    public static class Student{
        public String name;
        public int age;
        public int id; // 表示班级

        public Student(String name, int id, int age){
            this.name = name;
            this.age = age;
            this.id = id;

        }
    }

    // 按照学生 id 升序的比较器
    public static class IdCendingComparator implements Comparator<Student> {
        @Override
        //比较器，如果返回是正数，则后一个放在前面，
        //如果返回是负数，前一个放在前面，
        //如果返回是零，则认为两个相等，哪个放在前面都可以。
        public int compare(Student o1, Student o2){
            return o1.id - o2.id;
        }
    }

    // 按照学生 age 降序的比较器
    public static class AgeDecendingComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2){
            return o2.age - o1.age;
        }
    }

    //不同 id 按照 id 升序排序，同一 id 按照 age 升序排序
    public static class IdAgeCendingComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2){
            if (o1.id != o2.id){
                return o1.id - o2.id;
            }else{
                return o1.age - o2.age;
            }
        }
    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
        System.out.println("===========================");
    }

    public static void main(String[] args) {
        //优先队列底层就是比较器

        PriorityQueue<Student> heap = new PriorityQueue<>(new AgeDecendingComparator());

        Student student1 = new Student("A", 1, 23);
        Student student2 = new Student("B", 2, 21);
        Student student3 = new Student("C", 2, 25);
        Student student4 = new Student("D", 2, 24);
        Student student5 = new Student("E", 3, 21);
        Student student6 = new Student("F", 3, 22);

        heap.add(student1);
        heap.add(student2);
        heap.add(student3);
        heap.add(student4);
        heap.add(student5);
        heap.add(student6);

        while (!heap.isEmpty()){
            Student s = heap.poll();
            System.out.println("Name:" + s.name + " id: " + s.id + " age: " + s.age);
            System.out.println("========================");
        }

        Student[] students = new Student[] { student3, student2, student1, student4, student5, student6};
        printStudents(students);

        Arrays.sort(students, new IdCendingComparator());
        printStudents(students);

        Arrays.sort(students, new AgeDecendingComparator());
        printStudents(students);

        Arrays.sort(students, new IdAgeCendingComparator());
        printStudents(students);

    }

}
