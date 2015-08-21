package com.vv.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.vv.base.pojo.AppNews;
import com.vv.base.pojo.AppNewsExample;
import com.vv.base.pojo.PageForm;
import com.vv.dao.inter.AppNewsMapper;

/**
 * appnews 
 * @author WangWei
 *
 * 2015年4月7日
 */
@Service("appNewsService")
public class AppNewsService {
	
	private Log log = LogFactory.getLog(AppNewsService.class);
	
	@Autowired
	private AppNewsMapper appNewsMapper;
	
	
	
	
	/**
	 * 查询appnews
	 * @param name
	 * @param categoryName
	 * @param currentPage
	 * @return
	 */
	public PageForm getList(Integer pageNo,Integer number){
		PageHelper.startPage(pageNo, number);
		AppNewsExample example = new AppNewsExample();
		example.createCriteria();
		PageForm page = PageForm.getPageForm((Page<AppNews>)appNewsMapper.selectByExample(example));
		return page;
	}
	
	
	public List<AppNews> getList2(Integer pageNo,Integer number){
		return appNewsMapper.selectByPrimaryKey2(pageNo, number);
	}
	
	public List<AppNews> getList3(Integer pageNo,Integer number){
		return appNewsMapper.selectByPrimaryKey2(pageNo, number);
	}
	
	
	
	
	
}
