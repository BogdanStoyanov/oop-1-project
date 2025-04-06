public abstract class Employee {
    private Worker worker;

    public Employee(Worker worker) {
        this.worker = worker;
    }

    public Worker getWorker() {
        return worker;
    }

    public abstract String perform();
}
