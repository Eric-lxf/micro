package org.micro.mi.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.micro.mi.sys.entity.User;

public interface LoginMapper {

	List<User> queryByUserName(@Param("userName") String userName);
	
	int regist(User user);
}
