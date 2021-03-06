package com.windyoffice.o2o.dao;

import com.windyoffice.o2o.entity.Shop;

public interface ShopDao {

	/**
	 * 新增店铺
	 * 
	 * @param shop
	 * @return effectedNum
	 */
	int insertShop(Shop shop);

	/**
	 * 更新店铺信息
	 * 
	 * @param shop
	 * @return effectedNum
	 */
	int updateShop(Shop shop);

}
