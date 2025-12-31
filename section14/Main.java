import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer a = 5;
        Integer b = 0;
        try {
            Integer res = a / b;
            System.out.printf("res" + res);
        } catch (ArithmeticException ex) {
            System.out.println("Oce");
        }
        System.out.printf("Pro");

//        add(0,3);

        Person person01 = new Person(1L, "username_01", "password_01", Gender.FEMALE, "Ho Chi Minh");
        Person person02 = new Person(2L, "username_01", "password_01", Gender.FEMALE, "Ha Noi");
        Person person03 = new Person(3L, "username_01", "password_01", Gender.FEMALE, "Da Nang");

        List<Person> listPerson = List.of(
                new Person(1L, "username_01", "password_01", Gender.FEMALE, "Ho Chi Minh"),
                new Person(2L, "username_02", "password_02", Gender.MALE, "Ha Noi"),
                new Person(3L, "username_03", "password_03", Gender.OTHER, "Da Nang"),
                new Person(4L, "username_04", "password_04", Gender.MALE, "Binh Chanh"));

        System.out.println(listPerson);

        listPerson.stream()
                .filter(person -> person.getAddress().contains("a"))
                .forEach(System.out::println);

        List<String> passwords = listPerson.stream()
                .filter(per -> per.getGender().equals(Gender.MALE))
                .map(Person::getAddress)
                .toList();
        System.out.println(passwords); // [Ha Noi, Binh Chanh]

        Student student = new Student("212123");
        System.out.println(student);
    }

    static class Student {
        private String mssv;

        public Student(String mssv) {
            this.mssv = mssv;
        }

        public String getMssv() {
            return mssv;
        }

        public void setMssv(String mssv) {
            this.mssv = mssv;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "mssv='" + mssv + '\'' +
                    '}';
        }
    }

//    static int add (int a, int b) {
//        if(a == 0) {
//            throw new CustomHandler("Tu so khong dc bang 0");
//        }
//        return a + b;
//    }
}
