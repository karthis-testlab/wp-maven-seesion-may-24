package wp.week12.session2;

import wp.week12.session01.Employees;

public class EmploeeExample {

	public static void main(String[] args) {
		
		Employees employee = new Employees();
		Employees employee1 = new Employees();
		
		employee.setEmp_number(1);
		employee.setEmp_name("Karthi");
		
		System.out.println(employee.getEmp_number());
		System.out.println(employee.getEmp_name());
		
		employee1.setEmp_number(2);
		employee1.setEmp_name("Kumar");
		
		System.out.println(employee1.getEmp_number());
		System.out.println(employee1.getEmp_name());

	}

}
