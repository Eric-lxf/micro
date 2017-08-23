package org.micro.mi.logic.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.micro.mi.sys.entity.User;
import org.micro.mi.sys.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户注册controller
 * @author xifeng.liu
 *
 */
@RequestMapping("regist")
@Controller
public class RegistController {

	private static final Logger logger = Logger.getLogger(RegistController.class);
	@Autowired
	private LoginService loginService;
	/**
	 * 注册用户
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "in",method=RequestMethod.GET)
	@ResponseBody
	public String regist(HttpServletRequest request,User user){
		/*user = new User();
		user.setUserName("liu");
		user.setEmail("email@qq.com");
		user.setNickName("测试");
		user.setPassword("222222");
		user.setIsValid(0);
		user.setSex(0);
		user.setStatus(1);
		user.setUserType(1);*/
		String returnMessage = loginService.registUser(user);
		return returnMessage;
	}
}
