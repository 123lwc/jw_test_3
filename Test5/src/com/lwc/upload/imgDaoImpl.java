package com.lwc.upload;

import com.lwc.upload.*;

public class imgDaoImpl {
	public boolean add(Img img) {
		boolean flag = false; //标志
		DBUtil db = new DBUtil();//创建连接数据库实体
		String firstName = img.getFirstName();
		String lastName = img.getLastName();
		String time = img.getTime();
		String photo = img.getImg();
		String sql = "insert into img_table(firstName,lastName,imgTime,img)"
				+ "values('"+ firstName +"', '"+ lastName +"', '"+ time +"', '"+ photo +"')";
		System.out.println(sql);
		int n = db.update(sql);
		if(n > 0) {
			flag = true;
		}
		return flag;
	}

}
