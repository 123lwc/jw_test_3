package com.lwc.upload;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lwc.upload.*;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class ImgList
 */
@WebServlet("/ImgList")
public class ImgList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImgList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 声明四个参数
		long rows = 0; // 数据总数（可能比较长，就定义为了long）
		int size = 10; // 每一页显示的记录条数
		int page = 1; // 当前第几页
		int pageCount = 0;// 一共有多少页
		String pn = request.getParameter("page");// 通过参数获取page（当前是第几页）
		// 得到当前是第几页
		if (pn != null && pn.length() > 0) {
			try {
				page = Integer.parseInt(pn); // 进行类型转换（得到的是一个字符串）
			} catch (NumberFormatException e) {
				e.printStackTrace();
				page = 1; // 如过又错，就返回第一页得到信息
			}
		}

		// 使用连接池
		try {
//					Connection conn = DBUtil.getConn();
			DBUtil db = new DBUtil();
			Connection conn = db.getConn();
			Statement stmt = (Statement) conn.createStatement();
			PreparedStatement stat = conn.prepareStatement("select count(*) as rows from img_table");// 先从数据库中取到所有的数据

			ResultSet rs = stat.executeQuery();// 将查询到的结果放到结果集中

			// 有下一条
			if (rs.next()) {
				rows = rs.getLong("rows");// 得到数据总数
			}

			// 计算pageCount（总页数）
			if (rows % size == 0) {
				pageCount = (int) (rows / size);
			} else {
				pageCount = (int) (rows / size) + 1;
			}

			// 将查询到的数据放到List集合中
			List<Img> list = new ArrayList<Img>();

			// 使用SQL进行分页(两个问号分别代表每一页的开头和结尾)
			stat = conn.prepareStatement("select * from img_table limit ?,?");
			stat.setInt(1, (page - 1) * size);// 每一页的开头
			stat.setInt(2, size);// 每一页的结尾

			rs = stat.executeQuery();

			while (rs.next()) {
				Img c = new Img();
				c.setFirstName(rs.getString(1));
				c.setLastName(rs.getNString(2));
				c.setTime(rs.getNString(3));
				c.setImg(rs.getNString(4));
				list.add(c);
				System.out.print(list);
			}
			conn.close();

			// 将数据发送给JSP页面，并实现转发
			request.setAttribute("imglist", list);
			request.setAttribute("pageCount", pageCount);// 总页数
			request.setAttribute("page", page);// 当前显示页

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/imglist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
