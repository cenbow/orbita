/**
 * @Title:  MeasureUnitService.java
 * @Package:  com.cloud.erp.service
 * @Description:  
 * Copyright:  Copyright(C) 2015
 * @author:  bollen bollen@live.cn
 * @date:  2015年5月20日 下午2:27:09
 * @version:  v1.0
 *
 * History:
 * Date		Author		Version
 * ---------------------------------------------
 * <reasons>
 */
package com.cloud.erp.service;

import java.util.List;

import com.cloud.erp.entities.table.MeasureUnit;
import com.cloud.erp.service.common.GeneralService;

/**
 * @ClassName  MeasureUnitService
 * @Description  
 * @author  bollen bollen@live.cn
 * @date  2015年5月20日 下午2:27:09
 *
 */
public interface MeasureUnitService extends GeneralService<MeasureUnit>{

	List<MeasureUnit> findMeasureUnits();
	
	long getCount();

}
