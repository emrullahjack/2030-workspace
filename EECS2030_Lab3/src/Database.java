import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* READ THE PDF INSTRUCTION BEFORE GETTING STARTED!
 * 
 * Resources:
 * 	- Tutorial Series on Java Collections (ArrayList and HashMap):
 * 		https://www.eecs.yorku.ca/~jackie/teaching/tutorials/index.html#java_collections
 *	- Recording of lecture on implementing compareTo and using Arrays.sort(...):
 *		https://youtu.be/mDpDRLEy-7Y
 */

public class Database {
	/*
	 * Each entry in a 'departments' map contains
	 * a unique department id and its associated information object.
	 */
	HashMap<Integer, DepartmentInfo> departments;

	/*
	 * Each entry in a 'employees' map contains
	 * a unique employee id and its associated information object.
	 */
	HashMap<String, EmployeeInfo> employees;

	/**
	 * Initialize an empty database.
	 */
	public Database() {
		departments = new HashMap<Integer, DepartmentInfo>();
		employees = new HashMap<String, EmployeeInfo>();
	}

	/**
	 * Add a new employee entry.
	 * @param id id of the new employee
	 * @param info information object of the new employee
	 * @throws IdAlreadyExistsExceptoin if 'id' is an existing employee id
	 */
	public void addEmployee(String id, EmployeeInfo info) throws IdAlreadyExistsExceptoin {

		if (employees.containsKey(id)) {
			throw new IdAlreadyExistsExceptoin("Id Already Exists");
		} else {
			employees.put(id, info);
		}

	}

	/**
	 * Remove an existing employee entry.
	 * @param id id of some employee
	 * @throws IdNotFoundException if 'id' is not an existing employee id
	 */
	public void removeEmployee(String id) throws IdNotFoundException {

		if (!employees.containsKey(id)) {
			throw new IdNotFoundException("Id Not Found");
		} else {
			employees.remove(id);
		}

	}

	/**
	 * Add a new department entry.
	 * @param id id of the new department
	 * @param info information object of the new department
	 * @throws IdAlreadyExistsExceptoin if 'id' is an existing department id
	 */
	public void addDepartment(Integer id, DepartmentInfo info) throws IdAlreadyExistsExceptoin {

		if (departments.containsKey(id)) {
			throw new IdAlreadyExistsExceptoin("Id Already Exists");
		} else {
			departments.put(id, info);
		}

	}

	/**
	 * Remove an existing department entry.
	 * @param id id of some employee
	 * @throws IdNotFoundException if 'id' is not an existing employee id
	 */
	public void removeDepartment(Integer id) throws IdNotFoundException {

		if (!departments.containsKey(id)) {
			throw new IdNotFoundException("Id Not Found");
		} else {
			departments.remove(id);
		}

	}

	/**
	 * Change the department of employee with id 'eid' to a new department with id 'did'.
	 * 
	 * You can assume that 'did' denotes a department different from
	 * the current department of the employee denoted by 'eid'.
	 * @param eid id of some employee
	 * @param did id of some department
	 * @throws IdNotFoundException if either eid is a non-existing employee id or did is a non-existing department id.
	 */
	public void changeDepartment(String eid, Integer did) throws IdNotFoundException {

		if (!employees.containsKey(eid) || !departments.containsKey(did)) {
			throw new IdNotFoundException("Id Not Found");
		} else {
			employees.get(eid).setDepartmentId(did);
		}

	}

	/**
	 * Retrieve the name of employee with id 'id'.
	 * @param id id of some employee
	 * @return name of the employee with id 'id'
	 * @throws IdNotFoundException if 'id' is not an existing employee id
	 */
	public String getEmployeeName(String id) throws IdNotFoundException {

		if (!employees.containsKey(id)) {
			throw new IdNotFoundException("Id Not Found");
		} else {
			return employees.get(id).getName();
		}

	}

	/**
	 * Retrieve the names of all employees of the department with id 'id'.
	 * If 'id' a non-existing department id, then return an empty list.
	 * @param id id of some department
	 * @return List of names of employees whose home department has id 'id'
	 */
	public ArrayList<String> getEmployeeNames(Integer id) {
		ArrayList<String> arrayList = new ArrayList<String>();

		for (String k : employees.keySet()) {

			if (employees.get(k).getDepartmentId().equals(id)) {
				arrayList.add(employees.get(k).getName());
			}

		}

		return arrayList;
	}

	/**
	 * Retrieve an employee's department's information object.  
	 * @param id id of some existing employee
	 * @return The information object of the employee's home department
	 * @throws IdNotFoundException if 'id' is not an existing employee id
	 */
	public DepartmentInfo getDepartmentInfo(String id) throws IdNotFoundException {

		if (!employees.containsKey(id)) {
			throw new IdNotFoundException("");
		} else {
			return departments.get(employees.get(id).getDepartmentId());
		}

	}

	/**
	 * Retrieve a list, sorted in increasing order, 
	 * the information objects of all stored employees.
	 * 
	 * Hints: 
	 * 1. Override the 'comareTo' method in EmployeeInfo class. 
	 * 2. Look up the Arrays.sort method in Java API. 
	 * @return A sorted list of information objects of all employees.
	 */
	public EmployeeInfo[] getSortedEmployeeInfo() {
		EmployeeInfo[] employeeInfos = new EmployeeInfo[employees.size()];
		int i = 0;

		for (String k : employees.keySet()) {
			employeeInfos[i] = employees.get(k);
			i++;
		}

		Arrays.sort(employeeInfos);
		return employeeInfos;
	}

	/**
	 * Retrieve the average salary of all employees in department with id 'id'.
	 * @param id id of some department 
	 * @return average salary of all employees in department with id 'id'
	 * @throws IdNotFoundException if id is not an existing department id
	 */
	public double getAverageSalary(Integer id) throws IdNotFoundException {

		if (!departments.containsKey(id)) {
			throw new IdNotFoundException("Id Not Found");
		} else {
			double sum = 0;
			int counter = 0;

			for (String k : employees.keySet()) {

				if (employees.get(k).getDepartmentId().equals(id)) {
					sum += employees.get(k).getSalary();
					counter++;
				}

			}

			return sum / counter;
		}

	}
	
	/**
	 * Retrieve the information object of the department with the highest average salary among its employees.
	 * @return the information object of the department with the highest average salary among its employees
	 * 
	 * Hint: Use 'getAverageSalary(Integer id)' as a helper method.
	 */
	public DepartmentInfo getDepartmentOfHighestAverageSalary() {
		double highestAverageSalary = 0;
		int highestSalaryDepartmentId = 0;

		for (String k : employees.keySet()) {

			try {

				if (highestAverageSalary < getAverageSalary(employees.get(k).getDepartmentId())) {
					highestAverageSalary = getAverageSalary(employees.get(k).getDepartmentId());
					highestSalaryDepartmentId = employees.get(k).getDepartmentId();
				}

			} catch (IdNotFoundException e) {
				System.out.println("IdNotFoundException Occured");
			}

		}

		return departments.get(highestSalaryDepartmentId);
	}
}
