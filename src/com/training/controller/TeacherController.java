package com.training.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.training.dao.TeacherDAO;
import com.training.model.Teacher;



/**
 * Servlet implementation class TeacherController
 */

public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private TeacherDAO teacherDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherController() {
        super();
        teacherDao = new TeacherDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action == null) {
			action = "list";
		}

		System.out.println("action=" + action);
		switch (action) {
		case "new":
			newTeacher(request, response);
			break;
		case "insert":
			insertTeacher(request, response);
			break;
		case "edit":
			editTeacher(request, response);
			break;
		case "update":
			updateTeacher(request, response);
			break;
		case "delete":
			deleteTeacher(request, response);
			break;

		case "list":
			listTeacher(request, response);
			break;

		default:
			listTeacher(request, response);
			break;
		}
	}

	private void newTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("teacher-form.jsp");
		rd.forward(request, response);

	}

	private void insertTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String emailAddress = request.getParameter("emailaddress");
		String phoneNumber = request.getParameter("phonenumber");

		if (firstName != null) {

			teacherDao.createTeacher(new Teacher(firstName, lastName, emailAddress, phoneNumber));

		}

		response.sendRedirect(request.getContextPath() + "/Teachers");

	}

	private void updateTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String emailAddress = request.getParameter("emailaddress");
		String phoneNumber = request.getParameter("phonenumber");

		if (id != null) {

			teacherDao.updateTeacher(new Teacher(Integer.parseInt(id), firstName, lastName, emailAddress, phoneNumber));

		}

		response.sendRedirect(request.getContextPath() + "/Teachers");

	}

	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
		Boolean subjectClassNotExists = true;

		System.out.println("deleteTeacher");

		if (id != null) {
			Teacher teacher = teacherDao.getTeacher(Integer.parseInt(id));
			if (teacher != null) {
				subjectClassNotExists = teacher.getSubjectClassSet().isEmpty();

				if (subjectClassNotExists == true) {
					teacherDao.deleteTeacher(Integer.parseInt(id));
				}

			}

		}
		
		if (subjectClassNotExists==false) {
			
			request.setAttribute("teacherErrorMessage", "Could not delete teacher as they are mapped to subjects and classes");
		}

		
		listTeacher(request, response);

	}

	private void editTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {

			Teacher teacher = teacherDao.getTeacher(Integer.parseInt(id));
			request.setAttribute("teacher", teacher);

		}

		RequestDispatcher rd = request.getRequestDispatcher("teacher-form.jsp");
		rd.forward(request, response);

	}

	private void listTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Teacher> teacherList = teacherDao.getAllTeachers();

		request.setAttribute("teacherList", teacherList);

		RequestDispatcher rd = request.getRequestDispatcher("teacher-list.jsp");

		rd.forward(request, response);

	}

}
