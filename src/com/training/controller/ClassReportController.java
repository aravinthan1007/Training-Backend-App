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
import com.training.model.SubjectClass;



/**
 * Servlet implementation class ClassReportController
 */

public class ClassReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SclassDAO sclassDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassReportController() {
        super();
        sclassDAO = new SclassDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action == null ? "list" : action) {

		case "createreport":
			createReport(request, response);
			break;
		case "list":
			listCourseForm(request, response);

			break;

		default:
			listCourseForm(request, response);

			break;
		}

	}

	private void createReport(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int sclassId = Integer.parseInt(request.getParameter("sclassid"));

		Sclass sclass = sclassDAO.getSClass(sclassId);
		Set<SubjectClass> subjectClassSet = sclass.getSubjectClassSet();
		Set<Student> studentSet = sclassDAO.getSClass(sclassId).getStudentSet();

		request.setAttribute("studentSet", studentSet);
		request.setAttribute("subjectClassSet", subjectClassSet);
		request.setAttribute("sclass", sclass);

		RequestDispatcher rd = request.getRequestDispatcher("classreport-list.jsp");
		rd.forward(request, response);

	}

	private void listCourseForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Sclass> sclassList = sclassDAO.getAllSClass();

		request.setAttribute("sclassList", sclassList);

		RequestDispatcher rd = request.getRequestDispatcher("classreport-form.jsp");
		rd.forward(request, response);

	}
}


