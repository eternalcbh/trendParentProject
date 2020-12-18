package cn.how2j.trend.web;

import cn.how2j.trend.pojo.Index;
import cn.how2j.trend.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.how2j.trend.web
 * @ClassName:IndexController
 * @Description:
 * @date 2020-12-13 16:13
 */
@RestController
public class IndexController {
	@Autowired
	IndexService indexService;

	@GetMapping("/getCodes")
	public List<Index> get() throws Exception{
		return indexService.get();
	}

	@GetMapping("/freshCodes")
	public List<Index> fresh() throws Exception{
		return indexService.fresh();
	}

	@GetMapping("/removeCodes")
	public String remove() throws Exception{
		indexService.remove();
		return "remove codes successfully";
	}
}
