package com.lwc.upload;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lwc.upload.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class Uploadimg
 */
@WebServlet("/upload")
public class Uploadimg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Uploadimg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> list= upload.parseRequest(request);
			for(FileItem item : list) {
				if(item.isFormField()) {
					System.out.println(item.getFieldName()+":"+item.getString());
				}else {
					imgDaoImpl imgDaoImpl = new imgDaoImpl();
					String path = this.getServletContext().getRealPath("/upload");
					String name = ""+System.currentTimeMillis();
					String ext = item.getName().substring(item.getName().lastIndexOf("."), item.getName().length());
					item.write(new File(path+"/"+name+ext));
					Date date = new Date();
					SimpleDateFormat time = new SimpleDateFormat("YYYY-MM-DD");					
					Img img = new Img(item.getFieldName(),name,time.format(date),name+ext);
					imgDaoImpl.add(img);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().print("upload ok");
	}

}
