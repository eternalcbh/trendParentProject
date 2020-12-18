package cn.how2j.trend.web;

import cn.how2j.trend.pojo.IndexData;
import cn.how2j.trend.service.IndexDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.how2j.trend.web
 * @ClassName:IndexDataController
 * @Description:
 * @date 2020-12-15 22:50
 */
@RestController
public class IndexDataController {
	@Autowired
	public IndexDataService indexDataService;

	@GetMapping("/freshIndexData/{code}")
	public String fresh(@PathVariable("code") String code){
		indexDataService.fresh(code);
		return "fresh index data successfully";
	}

	@GetMapping("/getIndexData/{code}")
	public List<IndexData> get(@PathVariable("code") String code){
		List<IndexData> indexDataList = indexDataService.get(code);
		return indexDataList;
	}

	@GetMapping("/removeIndexData/{code}")
	public String remove(@PathVariable("code") String code){
		indexDataService.remove(code);
		return "remove index data successfully";
	}
}
