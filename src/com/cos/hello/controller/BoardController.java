package com.cos.hello.controller;

import java.io.IOException;

import javax.servlet.ServletException;
// javax로 시작하는 패키지는 톰캣이 들고 있는 라이브러리
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BoardController 실행됨 !!");

		String gubun = req.getParameter("gubun");
		System.out.println(gubun);

		if (gubun.equals("deleteOne")) {
			resp.sendRedirect("board/deleteOne.jsp");
		} else if (gubun.equals("selectAll")) {
			resp.sendRedirect("board/selectAll.jsp");
		} else if (gubun.equals("updateOne")) {
			resp.sendRedirect("board/updateOne.jsp");
		} else if (gubun.equals("insertOne")) {
			resp.sendRedirect("board/insertOne.jsp");
		}
	}
}
