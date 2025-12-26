public interface ChimUng extends DaiBang {
    void bay();
    default void xinChao() {
        System.out.println("Hello world!");
    }
    Integer tuoi = 29;
}
