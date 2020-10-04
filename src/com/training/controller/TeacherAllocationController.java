package com.training.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.training.dao.SubjectClassDAO;
import com.training.dao.TeacherDAO;
import com.training.model.SubjectClass;
import com.training.model.Teacher;

/**
 * Servlet implementation class TeacherAllocationController
 */

public class TeacherAllocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDAO teacherDAO;
	private SubjectClassDAO subjectClassDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherAllocationController() {
        super();
        teacherDAO = new TeacherDAO();
		subjectClassDAO = new SubjectClassDAO();
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
		case "edit":

			editTeacherSubjectClass(request, response);
			break;
		case "update":

			updateTeacherSubjectClass(request, response);
			break;
		case "delete":

			deleteTeacherSubjectClass(request, response);
			break;

		case "list":

			listTeacherSubjectClass(request, response);

			break;

		default:
			listTeacherSubjectClass(request, response);
			break;
		}
	}

	private void editTeacherSubjectClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		List<Teacher> teacherList = teacherDAO.getAllTeachers();
		SubjectClass subjectClass = null;

		if (id != null) {

			subjectClass = subjectClassDAO.getSubjectClass(Integer.parseInt(id));
		}

		request.setAttribute("teacherList", teacherList);
		request.setAttribute("subjectClass", subjectClass);

		RequestDispatcher rd = request.getRequestDispatcher("teacherallocation-form.jsp");
		rd.forward(request, response);

	}

	private void updateTeacherSubjectClass(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String teacherid = request.getParameter("teacherid");

		String subjectClassId = request.getParameter("id");

		if (teacherid != null && subjectClassId != null) {
			Teacher teacher = teacherDAO.getTeacher(Integer.parseInt(teacherid));
			SubjectClass subjectClass = subjectClassDAO.getSubjectClass(Integer.parseInt(subjectClassId));
			subjectClass.setTeacher(teacher);
			subjectClassDAO.updateSubjectClass(subjectClass);

		}
		response.sendRedirect(request.getContextPath() + "/TeacherAllocation");

	}

	private void deleteTeacherSubjectClass(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String subjectClassId = request.getParameter("id");

		if (subjectClassId != null) {

			SubjectClass subjectclass = subjectClassDAO.getSubjectClass(Integer.parseInt(subjectClassId));
			subjectclass.setTeacher(null);
			subjectClassDAO.updateSubjectClass(subjectclass);
		}

		response.sendRedirect(request.getContextPath() + "/TeacherAllocation");
	}

	private void listTeacherSubjectClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<SubjectClass> subjectClassList = subjectClassDAO.getAllSubjectClass();

		request.setAttribute("subjectClassList", subjectClassList);
		RequestDispatcher rd = request.getRequestDispatcher("teacherallocation-list.jsp");
		rd.forward(request, response);

	}


}
