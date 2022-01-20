package com.mk.springtuto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mk.springtuto.model.Employee;
import com.mk.springtuto.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeServicess;

	// Display list of employees
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexPage(Model model) {

		// model.addAttribute("employees", this.employeeServicess.getAllEmployees());
		// return "index";
		return findPage(1, "firstName", "asc", model);

	}

	// Add a new Employees
	// Name in link on page index "/addEmployee"
	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String addEmployee(Model model) {

		Employee employee = new Employee();
		model.addAttribute("sendemployee", employee);
		// Name Page
		return "newemployee";
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// Save Employee to DataBase:
		employeeServicess.saveEmployee(employee);
		return "redirect:/";

	}

	// Update Employees
	@RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.GET)
	public String updateEmployee(@PathVariable(value = "id") Long id, Model model) {

		// Get Employee from service
		Employee employee = this.employeeServicess.getEmployeeById(id);

		// Set employee as a model attribute to pre-populate the form
		model.addAttribute("updateById", employee);
		return "updateemployee";
	}

	// Delete Employee
	@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable(value = "id") Long id) {

		this.employeeServicess.deleteEmployeeById(id);
		return "redirect:/";
	}

	// Pagination:
	@RequestMapping(value = "/page/{pageNo}", method = RequestMethod.GET)
	public String findPage(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {

		int pageSize = 5;
		Page<Employee> page = this.employeeServicess.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Employee> listEmployees = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listEmployees", listEmployees);
		return "index";

	}

}
