package com.windyoffice.o2o.web.superadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.windyoffice.o2o.entity.Area;
import com.windyoffice.o2o.service.AreaService;

@Controller
@RequestMapping("/superadmin")
public class AreaController {

	Logger logger=LoggerFactory.getLogger(AreaController.class);
	
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value="/listarea",method=RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> listArea(){
		logger.info("=======start=========");
		long starttime=System.currentTimeMillis();
		Map<String,Object> modelMap=new HashMap<String,Object>();
		List<Area> list=new ArrayList<Area>();
		try {
			list=areaService.getAreaList();
			modelMap.put("rows",list);
			modelMap.put("total",list.size());
			modelMap.put("success",true);
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("success",false);
			modelMap.put("errMsg", e.getMessage());
		}
		logger.error("test error!");
		long endtime=System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",endtime-starttime);
		logger.info("=======end=========");
		return modelMap;
	}
}
