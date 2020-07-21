import java.util.*;
class Employee{
    int empId;
    String empName;
    String email;
    String gender;
    float salary;
    public void GetEmployeeDetails(){
        System.out.println("Employee Details - ");
        System.out.println("Employee id:"+empId+"\nEmployee Name:"+empName+"\nEmployee email:"+email+"\nEmployee gender:"+gender+"\nSalary:"+salary);
    }
}
class EmployeeDB{
    ArrayList<Employee> list = new ArrayList<>();
    boolean AddEmployee(Employee k){
        Employee e1 = k;
        if(list.add(e1)){
            return true;
        }
        return false;
    }
    boolean deleteEmployee(int empId){
        Iterator itr = list.iterator();
        Employee e1 = new Employee();
        while(itr.hasNext()){
            e1 = (Employee)itr.next();
            if(e1.empId==empId){
                break;
            }
        }
        if(e1.empId==empId){
            list.remove(e1);
            return true;
        }
        else{
            return false;
        }
    }
    String showPaySlip(int empId){
        System.out.println("Employee payslip:");
        System.out.println("------------------");
        Iterator itr = list.iterator();
        Employee e1 = new Employee();
        String val = "";
        while(itr.hasNext()){
            e1 = (Employee)itr.next();
            if(e1.empId==empId){
                break;
            }
        }
        if(e1.empId==empId){
           val+="Employee Id:"+e1.empId;
           val += "\nEmployee name:"+e1.empName;
           val+="\nEmployee Email:"+e1.email;
           val+="\nEmployee gender:"+e1.gender;
           val+="\n------------------------";
           val+="\nSalary:\t"+e1.salary;
           val+="\n------------------------";
           return val;
        }
        else{
            return val;
        }
    }
    public static void main(String[] args) {
        Employee e1 = new Employee();
        Scanner sc = new Scanner(System.in);
        System.out.print("Employee id:");
        e1.empId = sc.nextInt();
        sc.nextLine();
        System.out.print("Employee name:");
        e1.empName = sc.nextLine();
        System.out.print("Employee email:");
        e1.email = sc.nextLine();
        System.out.print("Employee gender:");
        e1.gender= sc.nextLine();
        System.out.print("Employee salary:");
        e1.salary = sc.nextFloat();
        //Adding Employee
        EmployeeDB emp = new EmployeeDB();
        if(emp.AddEmployee(e1)){
            System.out.println("Employee Added Successfully!");
            System.out.println("---------------------------");
            e1.GetEmployeeDetails();     
        }
        else{
            System.out.println("Error Adding element!!");
        }
        //payslip
        System.out.println(emp.showPaySlip(e1.empId));
        //deleting employee
        System.out.println("Deleting Employee:"+e1.empId);
        if(emp.deleteEmployee(e1.empId)){
            System.out.println("Employee Deleted Successfully!");
            System.out.println("---------------------------");
        }
    }
}