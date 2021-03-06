package com.cloud.erp.service.common;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.erp.dao.common.BaseDao;
import com.cloud.erp.utils.Commons;
import com.cloud.erp.utils.Constants;
import com.cloud.erp.utils.Reflect;

@Service("checkService")
public class CheckServiceSupport implements CheckService {
	
	private static final String METHOD_RESULT = "result";
	private static final String METHOD_CHECKER = "checker";
	private static final String METHOD_CHECK_DATE = "checkDate";
	private static final String METHOD_CHILDREN = "children";
	
	private String result = METHOD_RESULT;
	private String checker = METHOD_CHECKER;
	private String checkDate = METHOD_CHECK_DATE;
	private String children = METHOD_CHILDREN;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private BaseDao baseDao;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	
	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	@SuppressWarnings("unchecked")
	private boolean updateStatus(Object master, int expect) {
		
	/*	if ((int)Reflect.invokeGetMethod(master, getResult()) != expect - 1) {
			return false;
		}*/
		Reflect.invokeSetMethod(master, getResult(), expect);
		if (Constants.RESULT_CHECK_OK == expect) {
			Reflect.invokeSetMethod(master, getChecker(), Commons.getCurrentUser().getUserId());
			Reflect.invokeSetMethod(master, getCheckDate(), new Date());
		}
		baseDao.update(master);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean commit(Class<?> clazz, Integer id) {
		Object master = baseDao.get(clazz, id);
	    return updateStatus(master, Constants.RESULT_CHECK_PENDING);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean check(Class<?> clazz, Integer id) {
		Object master = baseDao.get(clazz, id);
	    return updateStatus(master, Constants.RESULT_CHECK_OK);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean changeCommit(Class<?> clazz, Integer id) {
		Object master = baseDao.get(clazz, id);
	    return updateStatus(master, Constants.RESULT_CHECK_CHANGE);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean cancelCheck(Class<?> clazz, Integer id) {
		Object master = baseDao.get(clazz, id);
		//int result = (int) Reflect.invokeGetMethod(master, getResult());
		int children = (int) Reflect.invokeGetMethod(master, getChildren());
		if(/*result != Constants.RESULT_CHECK_OK ||*/ children != 0){
			return false;
		}
		
		Reflect.invokeSetMethod(master, getResult(), Constants.RESULT_NONE);
		Reflect.invokeSetMethodAllowNull(master, getChecker(), Integer.class, (Integer)null);
		Reflect.invokeSetMethodAllowNull(master, getCheckDate(), Date.class, (Date)null);
		baseDao.update(master);
		return true;
	}

}
