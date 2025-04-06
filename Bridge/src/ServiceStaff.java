public class ServiceStaff extends Employee{
    public ServiceStaff(Worker worker) {
        super(worker);
    }

    public  String perform(){
        return super.getWorker().workDescription();
    }
}
