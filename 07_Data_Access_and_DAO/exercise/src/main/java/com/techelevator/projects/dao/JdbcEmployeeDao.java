package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;


public class JdbcEmployeeDao implements EmployeeDao {

	private JdbcTemplate jdbcTemplate = null;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date FROM employee;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			employeeList.add(mapRowToEmployee(results));
		}
		return employeeList;
	}


	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employeeName = new ArrayList<>();
		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date FROM employee" +
				" WHERE first_name iLIKE ? AND last_name iLIKE ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + firstNameSearch + "%", "%" + lastNameSearch +"%");
		while (results.next()){
			employeeName.add(mapRowToEmployee(results));
		}
		return employeeName;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List<Employee> employeeID = new ArrayList<>();
		String sql = "SELECT employee.employee_id, department_id, first_name, last_name, birth_date, hire_date FROM employee" +
				" JOIN project_employee using(employee_id)" +
				" JOIN project using(project_id)" +
				" WHERE project_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		while (results.next()){
			Employee employee = mapRowToEmployee(results);
			employeeID.add(employee);
		}
		return employeeID;
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sql = "INSERT INTO project_employee(project_id, employee_id) " +
				" VALUES (?, ?)";
		 int results = jdbcTemplate.update(sql, projectId, employeeId);
		}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sql = "DELETE FROM project_employee WHERE project_id = ?" +
				" And employee_id = ?;";
		int results = jdbcTemplate.update(sql, projectId, employeeId);
		if (results == 1) {
			System.out.println("Success!");
		}else{
			System.out.println("No Success!");

		}
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employeeWithoutProjects = new ArrayList<>();
		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date" +
				" FROM employee" +
				" LEFT JOIN project_employee USING (employee_id) WHERE project_id is null;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Employee employee = mapRowToEmployee(results);
			employeeWithoutProjects.add(employee);
		}
		return employeeWithoutProjects;
	}

	private Employee mapRowToEmployee(SqlRowSet results) {
		Employee employee = new Employee();
		employee.setId(results.getLong("employee_id"));
		employee.setDepartmentId(results.getLong("department_id"));
		employee.setFirstName(results.getString("first_name"));
		employee.setLastName(results.getString("last_name"));
		employee.setBirthDate(results.getDate("birth_date").toLocalDate());
		employee.setHireDate(results.getDate("hire_date").toLocalDate());
		return employee;
	}
}