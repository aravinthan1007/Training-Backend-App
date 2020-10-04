package com.training.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.dao.StudentDAO;
import com.training.model.Student;


/**
 * Servlet implementation class StudentController
 */

public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private StudentDAO studentDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        studentDao = new StudentDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			action = "list";
		}
		switch (action) {
		case "new":
			newStudent(request, response);
			break;
		case "insert":
			insertStudent(request, response);
			break;
		case "edit":
			editStudent(request, response);
			break;
		case "update":
			updateStudent(request, response);
			break;
		case "delete":
			deleteStudent(request, response);
			break;
		case "list":
			listStudent(request, response);
			break;

		default:
			listStudent(request, response);
			break;
		}
	}

	private void newStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("student-form.jsp");
		rd.forward(request, response);

	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String emailAddress = request.getParameter("emailaddress");
		String phoneNumber = request.getParameter("phonenumber");

		if (firstName != null) {

			studentDao.createStudent(new Student(firstName, lastName, emailAddress, phoneNumber));

		}

		response.sendRedirect(request.getContextPath() + "/Students");

	}

	private void editStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		if (id != null) {

			Student student = studentDao.getStudent(Integer.parseInt(id));
			request.setAttribute("student", student);
		}

		RequestDispatcher rd = request.getRequestDispatcher("student-form.jsp");
		rd.forward(request, response);

	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String emailAddress = request.getParameter("emailaddress");
		String phoneNumber = request.getParameter("phonenumber");

		if (id != null) {

			studentDao.updateStudent(new Student(Integer.parseInt(id), firstName, lastName, emailAddress, phoneNumber));

		}

		response.sendRedirect(request.getContextPath() + "/Students");

	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");

		if (id != null) {

			studentDao.deleteStudent(Integer.parseInt(id));

		}

		response.sendRedirect(request.getContextPath() + "/Students");

	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Student> studentList = studentDao.getAllStudent();

		request.setAttribute("studentList", studentList);

		RequestDispatcher rd = request.getRequestDispatcher("student-list.jsp");
		rd.forward(request, response);

	}

}
