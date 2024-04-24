//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee();

        // in first example, the attribute of class in not volatile

        Thread thread1 = new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            emp.goodStudent = true;
        });

        Thread thread2 = new Thread(()->{
            while(emp.goodStudent == false){
                System.out.println("Student is progressing...");
            }
            System.out.println("Student has become a good student");
        });

        thread1.start();
        thread2.start();
    }
}

// volatile is a keyword that can be used with an attribute of class
// if an attribute of a class is volatile, the changes made by
// one thread will be visible to other threads as well
// please go step by step:

// Creating a class Employee
class Employee{
    boolean goodStudent = false;
}