package com.itbank.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.CovidService;

@Controller
public class CovidController {
	
	@Autowired private CovidService cs;
	
	@GetMapping("/ex01")
	public ModelAndView ex01() throws IOException {
		ModelAndView mav = new ModelAndView();
		String data = cs.getData();
		
		JSONObject test = XML.toJSONObject(data);			// XML -> JSON
		JSONObject response = test.getJSONObject("response");	
		JSONObject body = response.getJSONObject("body");
		JSONObject items = body.getJSONObject("items");
		JSONArray item = items.getJSONArray("item");		// item 배열꺼내오기
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		
		for(int i = 0; i < item.length(); i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			JSONObject ob = item.getJSONObject(i);
			map.put("gubun", ob.get("gubun"));				// 시도 이름 구분
			map.put("localOccCnt", ob.get("localOccCnt"));	// 지역 발생자 수
			list.add(map);
		}
		mav.addObject("list", list);
		return mav;
	}

	@GetMapping("/ex02")
	public ModelAndView ex02() throws IOException {
		ModelAndView mav = new ModelAndView();
		String data = cs.getData();
		String json = XML.toJSONObject(data).toString(); // XML -> JSON
		mav.addObject("json", json);
		return mav;
	}

}
