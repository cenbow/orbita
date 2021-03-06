/**
 * @Title:  SalesReturnGoodsNoticeService.java
 * @Package:  com.cloud.erp.service
 * @Description:  
 * Copyright:  Copyright(C) 2015
 * @author:  bollen bollen@live.cn
 * @date:  2015年7月6日 下午4:44:57
 * @version:  v1.0
 *
 * History:
 * Date		Author		Version
 * ---------------------------------------------
 * <reasons>
 */
package com.cloud.erp.service;

import java.util.List;
import java.util.Map;

import com.cloud.erp.entities.shareentry.SalesShareEntry;
import com.cloud.erp.entities.table.SalesOutStock;
import com.cloud.erp.entities.table.SalesOutStockEntry;
import com.cloud.erp.service.common.AutoNumber;
import com.cloud.erp.service.common.GeneralService;
import com.cloud.erp.service.common.ShareEntryService;
import com.cloud.erp.service.common.SingleEntryService;

/**
 * @ClassName  SalesReturnGoodsNoticeService
 * @Description  
 * @author  bollen bollen@live.cn
 * @date  2015年7月6日 下午4:44:57
 *
 */
public interface SalesReturnGoodsNoticeService extends
	GeneralService<SalesOutStock>,
	AutoNumber<SalesOutStockEntry>,
	SingleEntryService<SalesOutStock>,
	ShareEntryService<SalesShareEntry, SalesOutStockEntry>{
	
	boolean persistence(SalesOutStock salesOutStock, Map<String, List<SalesOutStockEntry>> entries) throws Exception;
	
	boolean deleteToUpdateAll(Integer pid) throws Exception;

} 
