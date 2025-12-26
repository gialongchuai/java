public interface DaiBang {
    void bay();
    default void xinChao() {
        System.out.println("Xin chao the gioi");
    }
    Integer tuoi = 18;
}
