public interface SampleInterface01 {
    String name = "Hello world!";

    // the same
    public static final String name_01 = "cant change";

    void say();
    // the same
    //    public abstract void say();
    // public abstract is redundant for interface members

    //Interface abstract methods cannot have body
//    void say2() {
//        System.out.println("Hello 2");
//    }

    // Khong dc phep override do static method -> goc bang ten interface.method();
    //it works
    static void say3() {
        System.out.println("say 3");
    }

    public abstract void say4(); // default, bat buoc override khi imp


    //mac dinh public default : Khong can override nhung neu imp 2 cái có chung say5 thì phải override trong Person
    // call qua instance person.say5();
    default void say5() {
        System.out.println("xin chao");
    }
}
