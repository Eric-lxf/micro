package org.micro.mi.home.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 活动列表
 * @author pc
 *
 */
@Controller
@RequestMapping("activity")
public class ActivityItemController {

	/**
	 * 使用solr
	 * @param request
	 * @param cityId
	 * @param keyword
	 * @return
	 */
	@RequestMapping("items")
	public String activityItems(HttpServletRequest request,Integer cityId,String keyword){
		
		return null;
	}
}
