package org.micro.mi.sys.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.micro.mi.common.entity.ErrorCode;
import org.micro.mi.common.entity.SuccessCode;
import org.micro.mi.sys.dao.LoginMapper;
import org.micro.mi.sys.entity.User;
import org.micro.mi.sys.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.micro.mi.common.util.CodeDetail;
import com.micro.mi.common.util.SHA;

@Service
public class LoginServiceImpl implements LoginService{
	private static Logger logger = Logger.getLogger(LoginServiceImpl.class);
	@Autowired
	private LoginMapper loginMapper;

	@Override
	public String checkUserPassword(User userInfo, HttpServletRequest request) {
		String returnMessage = null;
		ErrorCode errCode = new ErrorCode();
		if(userInfo == null){
			errCode.setErrorCode(CodeDetail.ERROE_LOGIN_USER_FAIL);
			errCode.setErrorMsg("invalid login or password");
			return JSON.toJSONString(errCode);
		}
		List<User> users = loginMapper.queryByUserName(userInfo.getUserName());
		if(users != null && users.size() > 0){
			User user = users.get(0);
			if(user == null){
				errCode.setErrorCode(CodeDetail.ERROE_LOGIN_USER_FAIL);
				errCode.setErrorMsg("invalid login");
				returnMessage = JSON.toJSONString(errCode);
			}else{
				boolean isSuccess = validatePassword(userInfo.getPassword(),user.getPassword());
				if(isSuccess){
					returnMessage = JSON.toJSONString(user);
					System.out.println(user.getUserName()+" " + user.getNickName());
					request.getSession().setAttribute("currentUser", user);
				}else{
					errCode.setErrorCode(CodeDetail.ERROE_LOGIN_USER_FAIL);
					errCode.setErrorMsg("invalid login or password");
					returnMessage = JSON.toJSONString(errCode);
				}
			}
		}else{
			errCode.setErrorCode(CodeDetail.ERROE_LOGIN_USER_FAIL);
			errCode.setErrorMsg("invalid login or password");
			returnMessage = JSON.toJSONString(errCode);
		}
		return returnMessage;
	}

	private boolean validatePassword(String loginPassword,String password) {
		try {
			String loginPasswordEncrypt = SHA.encryptSHA(loginPassword);
			if(password.equals(loginPasswordEncrypt)){
				return true;
			}
		} catch (NoSuchAlgorithmException e) {
			logger.error("method validatePassword:NoSuchAlgorithm");
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean checkUserExist(User user) {
		String userName = null;
		if(user != null){
			userName = user.getUserName();
		}
		List<User> users = loginMapper.queryByUserName(userName);
		if(users != null && users.size() > 0)
			return true;
		return false;
	}

	@Override
	public String registUser(User user) {
		ErrorCode errCode = new ErrorCode();
		SuccessCode successCode = new SuccessCode();
		String returnMessage = null;
		try {
			boolean isExist = checkUserExist(user);
			if(isExist){
				errCode.setErrorCode(CodeDetail.ERROE_REGIST_USER_EXIST);
				errCode.setErrorMsg("user is exist!");
				returnMessage = JSON.toJSONString(errCode); 
			}else{
				user.setPassword(SHA.encryptSHA(user.getPassword()));
				int num = loginMapper.regist(user);
				if( num > 0 ){
					successCode.setSuccessCode(CodeDetail.SUCCESS_CODE);
					successCode.setSuccessMsg("regist success!");
					returnMessage = JSON.toJSONString(successCode);
				}else{
					errCode.setErrorCode(CodeDetail.FAIL_CODE);
					errCode.setErrorMsg("regist fail!");
					returnMessage = JSON.toJSONString(errCode);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			errCode.setErrorCode(CodeDetail.FAIL_CODE);
			errCode.setErrorMsg("regist fail!");
			returnMessage = JSON.toJSONString(errCode);
		}
		
		return returnMessage;
	}
	

}
