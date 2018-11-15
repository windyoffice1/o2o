package com.windyoffice.o2o.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.windyoffice.o2o.BaseTest;
import com.windyoffice.o2o.entity.Area;

public class AreaServiceTest extends BaseTest {

	@Autowired
	private AreaService areaService;
	@Test
	public void testQueryArea() {
		List<Area> areaList=areaService.getAreaList();
		assertEquals(2, areaList.size());
	}
}
