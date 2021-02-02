package Assignment12;
import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

class Student {
    int id;
    String name;
    int age;
    String gender;
    String engDepartment;
    int yearOfEnrollment;
    double perTillDate;

    public Student(int id, String name, int age, String gender, String engDepartment, int yearOfEnrollment, double perTillDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.engDepartment = engDepartment;
        this.yearOfEnrollment = yearOfEnrollment;
        this.perTillDate = perTillDate;
    }

    public double getPerTillDate() {
        return perTillDate;
    }

    public int getAge() {
        return age;
    }
}

public class Main {
    public static void main(String args[]) {
        List<Student> students = Arrays.asList(
                new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8),
                new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2),
                new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3),
                new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80),
                new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70),
                new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70),
                new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70),
                new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80),
                new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85),
                new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82),
                new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83),
                new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4),
                new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6),
                new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8),
                new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4),
                new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4),
                new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5)
        );

        System.out.println("Print the name of all departments in the college?");
        List<String> departments = students.stream().map(x -> x.engDepartment).distinct().collect(Collectors.toList());
        departments.forEach(x -> System.out.println(x));
        System.out.println("--------------------------------------------------------------");

        System.out.println("Get the names of all students who have enrolled after 2018?");
        List<Student> yof2018 = students.stream().filter(x -> x.yearOfEnrollment > 2018).collect(Collectors.toList());
        yof2018.forEach(x -> System.out.println(x.name));
        System.out.println("--------------------------------------------------------------");

        System.out.println("Get the details of all male student in the computer sci department?");
        List<Student> details = students.stream().filter(x -> x.engDepartment.equals("Computer Science")).filter(x -> x.gender.equals("Male")).collect(Collectors.toList());
        details.forEach(x -> System.out.println(x.name));
        System.out.println("--------------------------------------------------------------");

        System.out.println("How many male and female student are there ? (HINT:use Collectors.groupingBy() for grouping based on gender)");
        Map<String, List<Student>> maleFemale = students.stream().collect(Collectors.groupingBy(x -> x.gender));
        maleFemale.forEach((t, x) -> System.out.println(t + ": " + x.size()));
        System.out.println("--------------------------------------------------------------");

        System.out.println("What is the average age of male and female students?");
        maleFemale.forEach((t, x) -> System.out.println(t + ": " + x.stream().collect(Collectors.averagingInt(p -> p.age))));
        System.out.println("--------------------------------------------------------------");

        System.out.println("Get the details of highest  student having highest percentage ?");
        Student maxByPercentage = students.stream().max(Comparator.comparing(Student::getPerTillDate)).get();
        System.out.println("id:" + maxByPercentage.id + "," + "Name:" + maxByPercentage.name + "," + "Age:" + maxByPercentage.age + "," + "Gender:" + maxByPercentage.gender + "," + "Department:" + maxByPercentage.engDepartment + "," + "yearOfEnrollment:" + maxByPercentage.yearOfEnrollment + "," + "perTillDate:" + maxByPercentage.perTillDate);
        System.out.println("--------------------------------------------------------------");

        System.out.println("Count the number of students in each department? (Hint :use Collectors.groupingBy())");
        Map<String, List<Student>> dptsGrps = students.stream().collect(Collectors.groupingBy(x -> x.engDepartment));
        dptsGrps.forEach((t, x) -> System.out.println(t + ": " + x.size()));
        System.out.println("--------------------------------------------------------------");

        System.out.println("What is the average percentage achieved in each department?");
        dptsGrps.forEach((t, x) -> System.out.println(t + ": " + x.stream().collect(Collectors.averagingDouble(p -> p.perTillDate))));
        System.out.println("--------------------------------------------------------------");

        System.out.println("Get the details of youngest male student in the Electronic department?(Hint :Use Collectors.minBy)");
        Student minByAge = students.stream().filter(p -> p.gender.equals("Male")&&p.engDepartment.equals("Electronic")).min(Comparator.comparing(Student::getAge)).get();
        System.out.println("id:" + minByAge.id + "," + "Name:" + minByAge.name + "," + "Age:" + minByAge.age + "," + "Gender:" + minByAge.gender + "," + "Department:" + minByAge.engDepartment + "," + "yearOfEnrollment:" + minByAge.yearOfEnrollment + "," + "perTillDate:" + minByAge.perTillDate);
        System.out.println("--------------------------------------------------------------");

        System.out.println("How many male and female students are there in the computer science department?");
        Map<String, List<Student>> csMaleFemale = students.stream().filter(p -> p.engDepartment.equals("Computer Science")).collect(Collectors.groupingBy(x -> x.gender));
        csMaleFemale.forEach((t, x) -> System.out.println(t + ": " + x.size()));
    }
}