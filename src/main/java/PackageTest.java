import com.example.Employ;
// the Employee class is defined in that package

import static java.lang.System.*;

public class PackageTest {
    public static void main(String... args) {
        // because of the import statement, we don't have to use
        // com.example.Employee here
        Employ harry = new Employ("Harry Hacker", 50000, 1989, 10, 1);

        harry.raiseSalary(5);

        // because of the static import statement, we don't have to use System.out here
        out.println("name=" + harry.getName() + ",salary=" + harry.getSalary());
    }
}