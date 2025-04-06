public class Driver implements Worker {
    private String fullName;

    public Driver(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String workDescription() {
        return "Driver " + fullName + " is driving";
    }
}
