import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EmployeeServiceImpl implements EmployeeService{

	private DataSource dataSource;
	
	public EmployeeServiceImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<Employee> getAllEmployee() {
		Connection connection;
		List<Employee> employees = new ArrayList();
		try {
			connection = dataSource.getConnection();
		
		
		String query = "select * from Employees";
		
		Statement statement =  connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(query);

		while(resultSet.next()) {
			Employee employee = new Employee(resultSet.getInt("EMPLOYEE_ID"),
					resultSet.getString("FIRST_NAME") ,
					resultSet.getString("LAST_NAME") 
			);
			employees.add(employee);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployeeById(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeEmployeeById(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
