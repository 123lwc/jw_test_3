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
		// �����ĸ�����
		long rows = 0; // �������������ܱȽϳ����Ͷ���Ϊ��long��
		int size = 10; // ÿһҳ��ʾ�ļ�¼����
		int page = 1; // ��ǰ�ڼ�ҳ
		int pageCount = 0;// һ���ж���ҳ
		String pn = request.getParameter("page");// ͨ��������ȡpage����ǰ�ǵڼ�ҳ��
		// �õ���ǰ�ǵڼ�ҳ
		if (pn != null && pn.length() > 0) {
			try {
				page = Integer.parseInt(pn); // ��������ת�����õ�����һ���ַ�����
			} catch (NumberFormatException e) {
				e.printStackTrace();
				page = 1; // ����ִ��ͷ��ص�һҳ�õ���Ϣ
			}
		}

		// ʹ�����ӳ�
		try {
//					Connection conn = DBUtil.getConn();
			DBUtil db = new DBUtil();
			Connection conn = db.getConn();
			Statement stmt = (Statement) conn.createStatement();
			PreparedStatement stat = conn.prepareStatement("select count(*) as rows from img_table");// �ȴ����ݿ���ȡ�����е�����

			ResultSet rs = stat.executeQuery();// ����ѯ���Ľ���ŵ��������

			// ����һ��
			if (rs.next()) {
				rows = rs.getLong("rows");// �õ���������
			}

			// ����pageCount����ҳ����
			if (rows % size == 0) {
				pageCount = (int) (rows / size);
			} else {
				pageCount = (int) (rows / size) + 1;
			}

			// ����ѯ�������ݷŵ�List������
			List<Img> list = new ArrayList<Img>();

			// ʹ��SQL���з�ҳ(�����ʺŷֱ����ÿһҳ�Ŀ�ͷ�ͽ�β)
			stat = conn.prepareStatement("select * from img_table limit ?,?");
			stat.setInt(1, (page - 1) * size);// ÿһҳ�Ŀ�ͷ
			stat.setInt(2, size);// ÿһҳ�Ľ�β

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

			// �����ݷ��͸�JSPҳ�棬��ʵ��ת��
			request.setAttribute("imglist", list);
			request.setAttribute("pageCount", pageCount);// ��ҳ��
			request.setAttribute("page", page);// ��ǰ��ʾҳ

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
