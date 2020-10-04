package com.training.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.dao.SubjectDAO;
import com.training.model.Subject;


/**
 * Servlet implementation class SubjectController
 */

public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubjectDAO subjectDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectController() {
        super();
        subjectDao = new SubjectDAO();
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
			newSubject(request, response);
			break;
		case "create":
			createSubject(request, response);
			break;
		case "edit":
			editSubject(request, response);
			break;
		case "update":
			updateSubject(request, response);
			break;
		case "delete":
			deleteSubject(request, response);
			break;
		case "list":
			listSubject(request, response);
			break;

		default:
			listSubject(request, response);
			break;
		}

	}

	private void newSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("newSubject");

		RequestDispatcher rd = request.getRequestDispatcher("subject-form.jsp");
		rd.forward(request, response);

	}

	private void createSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("createSubject");
		String subjectName = (String) request.getParameter("subjectname");

		System.out.println(subjectName);

		if (subjectName != null) {

			subjectDao.createSubject(new Subject(subjectName.trim()));
		}

		response.sendRedirect(request.getContextPath() + "/Subjects");

	}

	private void editSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		if (id != null) {
			Subject subject = subjectDao.getSubject(Integer.parseInt(id));
			request.setAttribute("subject", subject);
		}

		RequestDispatcher rd = request.getRequestDispatcher("subject-form.jsp");
		rd.forward(request, response);
	}

	private void updateSubject(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("UpdateSubject");

		int id = Integer.parseInt(request.getParameter("id"));
		String subjectName = request.getParameter("subjectname");
		System.out.println("id:" + id);
		System.out.println("SubjectName:" + subjectName);
		Subject subject = new Subject(id, subjectName);

		subjectDao.updateSubject(subject);

		response.sendRedirect(request.getContextPath() + "/Subjects");

	}

	private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {

			subjectDao.deleteSubject(Integer.parseInt(id));

		}

		response.sendRedirect(request.getContextPath() + "/Subjects");

	}

	private void listSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Subject> subjectList = subjectDao.getAllSubjects();

		request.setAttribute("subjectList", subjectList);

		RequestDispatcher rd = request.getRequestDispatcher("subject-list.jsp");
		rd.forward(request, response);

	}

}
