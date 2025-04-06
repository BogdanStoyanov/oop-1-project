//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ServiceStaff firstEmployee = new ServiceStaff(new Cleaner("Jane Does"));
        System.out.println(firstEmployee.perform());

        ServiceStaff secondEmployee= new ServiceStaff(new Driver("John Doe"));
        System.out.println(secondEmployee.perform());
    }
}