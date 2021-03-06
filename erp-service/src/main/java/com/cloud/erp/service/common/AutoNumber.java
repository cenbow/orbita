package com.cloud.erp.service.common;

import java.util.List;

import com.cloud.erp.dao.exception.NumberIncrementException;

/**
 * Auto number interface
 * @author Administrator
 *
 * @param <T> entry type
 */
public interface AutoNumber<T> {

	String getNumber(List<T> list);
	
	boolean isThisType(String number, int classId);
		
    void increment(Integer classId) throws NumberIncrementException;

}
