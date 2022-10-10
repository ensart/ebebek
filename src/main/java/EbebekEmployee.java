import java.math.BigDecimal;

public class EbebekEmployee {

    public static void main(String[] args) {
        Employee employee = new Employee("Ali", new BigDecimal(1500), 44, 2011);

        System.out.println(employee);
        System.out.println("Vergi : " + employee.tax());
        System.out.println("Bonus : " + employee.bonus());
        BigDecimal salary = employee.getSalary();
        salary = salary.subtract(employee.tax()).add(new BigDecimal(employee.bonus()));
        System.out.println("Maaş : " + salary);
        BigDecimal artis = employee.raiseSalary();
        System.out.println("Maaş Artışı : " + artis);
        BigDecimal salarySum = salary.add(artis);
        System.out.println("Maaş Artışı ile birlikte maaş : " + salarySum);


    }

}
