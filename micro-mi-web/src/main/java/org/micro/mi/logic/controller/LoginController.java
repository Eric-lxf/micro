package org.micro.mi.logic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.micro.mi.sys.entity.User;
import org.micro.mi.sys.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * login controller
 * @author xifeng.liu
 *
 */
@Controller
@RequestMapping("login")
public class LoginController {

	private static Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	private LoginService loginService;
	/**
	 * 登录接口
	 * @param request
	 * @param response
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping(value="in",method=RequestMethod.GET)
	@ResponseBody
	public String login(HttpServletRequest request,HttpServletResponse response,User user){
		//1.根据用户名验证密码
		logger.info("login in start!");
		String returnMessage = loginService.checkUserPassword(user,request);
		return returnMessage;
	}
}
