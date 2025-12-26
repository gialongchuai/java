public class Person {
    private String name;
    private Address address;

    public Person(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    void sayHello() {
        System.out.println(this.name + " say hello!");
    }

    static class Address {
        private String street;

        public Address(String s) {
            this.street = s;
        }

        String sayStreet() {
            return this.street;
        }
    }

    @Override
    public String toString() {
        return "Xin chao " + this.name + " " + address.sayStreet();
    }
}
