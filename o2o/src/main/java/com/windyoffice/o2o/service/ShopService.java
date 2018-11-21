package com.windyoffice.o2o.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.windyoffice.o2o.dto.ShopExecution;
import com.windyoffice.o2o.entity.Shop;

public interface ShopService {

	/**
	 * 创建商铺
	 * 
	 * @param Shop
	 *            shop
	 * @return ShopExecution shopExecution
	 * @throws Exception
	 */
	ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg) throws RuntimeException;
}
