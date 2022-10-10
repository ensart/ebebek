import java.math.BigDecimal;

public class Employee {

    private String name = " ";
    private BigDecimal salary = BigDecimal.ZERO;
    private int workHours = 0;
    private int hireYear = 0;

    public Employee() {
    }

    public Employee(String name, BigDecimal salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public int getHireYear() {
        return hireYear;
    }

    public void setHireYear(int hireYear) {
        this.hireYear = hireYear;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", workHours=" + workHours +
                ", hireYear=" + hireYear +
                '}';
    }

    public BigDecimal tax() {
        BigDecimal result = BigDecimal.ZERO;

        if (getSalary().compareTo(new BigDecimal("1000")) < 0) {
            return result;
        } else {
            result = getSalary().multiply(new BigDecimal("3")).divide(new BigDecimal("100"));
            return result;
        }
    }

    public int bonus() {
        int result = 0;

        if (getWorkHours() <= 40) {
            return result;
        } else {
            int fazlaMesai = getWorkHours() - 40;
            result = fazlaMesai * 30;
            return result;
        }
    }

    public BigDecimal raiseSalary() {
        BigDecimal result = BigDecimal.ZERO;
        int toYear = 2021;

        BigDecimal vergiMiktari = tax();
        result = getSalary().subtract(vergiMiktari);
        setSalary(result);

        result = getSalary().add(new BigDecimal(bonus()));
        setSalary(result);

        int sure = toYear - getHireYear();
        BigDecimal artimMiktari = BigDecimal.ZERO;

        if (sure < 10) {
            artimMiktari = getSalary().multiply(new BigDecimal("5")).divide(new BigDecimal("100"));
        } else if (sure < 20) {
            artimMiktari = getSalary().multiply(new BigDecimal("10")).divide(new BigDecimal("100"));
        } else {
            artimMiktari = getSalary().multiply(new BigDecimal("15")).divide(new BigDecimal("100"));
        }

        result = result.add(artimMiktari);
        setSalary(result);

        return artimMiktari;
    }

}
