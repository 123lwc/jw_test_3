package cn.jbolt.index;
import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

import cn.jbolt.common.model.User;

/**
 * IndexController 指向系统访问首页
 * @author jbolt.cn
 * @email 909854136@qq.com
 * @date 2018年11月4日 下午9:02:52
 */
public class IndexController extends Controller {
	public IndexController() {
		super();
	}
	/**
	 * 首页Action
	 */
	public void index() {
		render("login.html");
	}
	public void regest() {
    	User user = getBean(User.class,"u");
    	System.out.println(user.getUsername());
    	setAttr("u", user);
    	setSessionAttr("us", user);
    	System.out.println(user.getUsername()+" "+user.getPwd()+" "+user.getPhone());
    	user.set("username", user.getUsername());
    	user.set("pwd", user.getPwd());
    	user.set("phone", user.getPhone());
    	user.set("user_icon_src", "N/A");
    	boolean b = user.save();
    	if (b) {
    		render("index.html");
		}else {
			render("login.html");
		}
    }
    
    public void login() {
    	User user = getBean(User.class,"u");
    	setAttr("u", user);
    	setSessionAttr("us", user);
    	List<User> users = User.dao.find("select * from user where username = '"
				+user.getUsername()+"' or phone = '"+user.getUsername()+"' and pwd = '"+user.getPwd()+"'");
    	System.out.println(users.size());
    	if (users.size()>0) {
    		render("index.html");
		}else {
			render("login.html");
		}
    }
    
    public void uploadImages() {
    	UploadFile file = getFile();
    	renderText(file.getFileName());
    }
}