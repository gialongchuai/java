public class BimBip implements ChimUng {
    private String name;

    int getTuoi() {
        return DaiBang.tuoi;
    }

    public BimBip(String name) {
        this.name = name;
    }

    @Override
    public void bay() {
        System.out.printf(this.name + " dang bay!");
    }
}
