/**
 * @Title:  AuxiliaryResTypeDao.java
 * @Package:  com.cloud.erp.dao
 * @Description:  TODO
 * Copyright:  Copyright(C) 2015
 * @author:  bollen bollen@live.cn
 * @date:  2015年4月30日 下午2:18:04
 * @version:  v1.0
 *
 * History:
 * Date		Author		Version
 * ---------------------------------------------
 * <reasons>
 */
package com.cloud.erp.dao;

import java.util.List;

import com.cloud.erp.entities.table.AuxiliaryResType;

/**
 * @ClassName  AuxiliaryResTypeDao
 * @Description  TODO
 * @author  bollen bollen@live.cn
 * @date  2015年4月30日 下午2:18:04
 *
 */
public interface AuxiliaryResTypeDao {

	List<AuxiliaryResType> findAuxiliaryResTypes();
	
	boolean persistenceAuxiliaryResType(AuxiliaryResType auxiliaryResType);
	
	boolean delAuxiliaryResType(Integer id);
}
