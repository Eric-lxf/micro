package org.micro.mi.sys.service;

import javax.servlet.http.HttpServletRequest;

import org.micro.mi.sys.entity.User;

/**
 * 登录service
 * @author xifeng.liu
 *
 */
public interface LoginService {
	String checkUserPassword(User user,HttpServletRequest request);
	boolean checkUserExist(User user);
	String registUser(User user);
}
