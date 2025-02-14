import java.util.List;

public interface EmployeeService {

	List<Employee> getAllEmployee();
	
	Employee getEmployeeById(int id);
	
	boolean addEmployee(Employee employee);
	
	boolean updateEmployeeById(Employee employee);
	boolean removeEmployeeById(int id);
	
}
