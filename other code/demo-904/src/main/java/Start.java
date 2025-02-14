

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


/**
 * Servlet implementation class Start
 */
@WebServlet("/Start")
public class Start extends HttpServlet {
	   
	
	@Resource(name = "testConnection")
	private DataSource dataSource;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Start() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			EmployeeService employeeService = new EmployeeServiceImpl(dataSource);
			List<Employee> employees= employeeService.getAllEmployee();
			response.getWriter().append("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Simple Table</title>\r\n"
					+ "    <style>\r\n"
					+ "        table {\r\n"
					+ "            width: 50%;\r\n"
					+ "            border-collapse: collapse;\r\n"
					+ "            margin: 20px 0;\r\n"
					+ "            font-size: 18px;\r\n"
					+ "            text-align: left;\r\n"
					+ "        }\r\n"
					+ "        th, td {\r\n"
					+ "            padding: 10px;\r\n"
					+ "            border: 1px solid #ddd;\r\n"
					+ "        }\r\n"
					+ "        th {\r\n"
					+ "            background-color: #f4f4f4;\r\n"
					+ "        }\r\n"
					+ "    </style>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "\r\n"
					+ "    <table>\r\n"
					+ "        <tr>\r\n"
					+ "            <th>ID</th>\r\n"
					+ "            <th>First Name</th>\r\n"
					+ "            <th>Last Name</th>\r\n"
					+ "        </tr>");

			for(Employee employee: employees) {
				/*response.getWriter().append("<h1>" + resultSet.getInt("EMPLOYEE_ID") +"</h1>");
				response.getWriter().append("<h1>" + resultSet.getString("FIRST_NAME") +"</h1>");
				response.getWriter().append("<h1>" + resultSet.getString("LAST_NAME") +"</h1>");
*/		
				response.getWriter().append(" <tr>\r\n"
						+ "            <td>" + employee.getId() + "</td>\r\n"
						+ "            <td>" + employee.getFirstName() +"</td>\r\n"
						+ "            <td>"+ employee.getLastName()+"</td>\r\n"
						+ "        </tr>");
			}
			
			response.getWriter().append("</table>\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "</html>");
		} catch (Exception  e) {
			response.getWriter().append("<h1>==>"+ e.getMessage() +"</h1>");
	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
