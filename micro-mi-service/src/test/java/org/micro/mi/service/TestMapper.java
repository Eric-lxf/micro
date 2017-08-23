package org.micro.mi.service;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.micro.mi.sys.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sun.istack.internal.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:dataSource/spring-mybatis.xml"}) 
public class TestMapper {

	private static Logger logger = Logger.getLogger(TestMapper.class);
	
	@Test
	public void test(){
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);
	}
}
