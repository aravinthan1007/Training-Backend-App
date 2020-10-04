package com.training.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.training.dao.SclassDAO;
import com.training.model.Sclass;
import com.training.model.Student;



/**
 * Servlet implementation class ClassesController
 */

public class ClassesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SclassDAO sclassDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassesController() {
        super();
        sclassDao = new SclassDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ClassServlet");
		String action = request.getParameter("action");

		if (action == null) {
			action = "list";
		}

		switch (action) {
		case "new":
			newClass(request, response);
			break;
		case "insert":
			insertClass(request, response);
			break;
		case "edit":
			editClass(request, response);
			break;
		case "update":
			updateClass(request, response);
			break;
		case "delete":
			deleteClass(request, response);
			break;

		case "list":
			listClass(request, response);
			break;

		default:
			listClass(request, response);
			break;
		}

	}

	private void newClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("class-form.jsp");
		rd.forward(request, response);
	}

	private void insertClass(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String sclassName = request.getParameter("sclassname");
		if (sclassName != null) {

			sclassDao.createClass(new Sclass(sclassName));

		}

		response.sendRedirect(request.getContextPath() + "/Classes");

	}

	private void deleteClass(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String id = request.getParameter("id");
		boolean isstudentsetEmpty = true;
		if (id != null) {
			Sclass sclass = sclassDao.getSClass(Integer.parseInt(id));

			Set<Student> studentSet = sclass.getStudentSet();

			if (studentSet.isEmpty()) {
				sclassDao.deleteSClass(Integer.parseInt(id));
			} else {
				isstudentsetEmpty = false;
			}

		}

		if (isstudentsetEmpty) {
			response.sendRedirect(request.getContextPath() + "/Classes");
		} else {

			String couldnotDeleteClass = " Could not delete class as students still exist";
			request.setAttribute("CouldnotDeleteClass", couldnotDeleteClass);
			listClass(request, response);
		}

	}

	private void updateClass(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String sclassName = request.getParameter("sclassname");

		if (id != null && sclassName != null) {

			sclassDao.updateSClass(new Sclass(Integer.parseInt(id), sclassName));

		}

		response.sendRedirect(request.getContextPath() + "/Classes");

	}

	private void editClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		String path = null;
		if (id != null) {

			Sclass sclass = sclassDao.getSClass(Integer.parseInt(id));
			request.setAttribute("sclass", sclass);

			path = "class-form.jsp";

		} else {
			path = "Classes";
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

	private void listClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("listClass");

		List<Sclass> sclassList = sclassDao.getAllSClass();

		request.setAttribute("sclassList", sclassList);
		RequestDispatcher rd = request.getRequestDispatcher("class-list.jsp");
		rd.forward(request, response);

	}

}
