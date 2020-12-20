package cn.how2j.trend.web;

import cn.how2j.trend.pojo.IndexData;
import cn.how2j.trend.service.BackTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cbh
 * @PackageName:cn.how2j.trend.web
 * @ClassName:BackTestController
 * @Description:
 * @date 2020-12-20 15:57
 */
@RestController
public class BackTestController {
	@Autowired
	BackTestService backTestService;

	@GetMapping("/simulate/{code}")
	@CrossOrigin
	public Map<String,Object> backTest(@PathVariable("code") String code){
		List<IndexData> allIndexDatas = backTestService.listIndexData(code);
		HashMap<String, Object> result = new HashMap<>();
		result.put("indexDatas",allIndexDatas);
		return result;
	}
}
