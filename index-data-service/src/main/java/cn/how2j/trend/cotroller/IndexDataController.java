package cn.how2j.trend.cotroller;

import cn.how2j.trend.config.IpConfiguration;
import cn.how2j.trend.pojo.IndexData;
import cn.how2j.trend.service.IndexDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.how2j.trend.cotroller
 * @ClassName:IndexDataController
 * @Description:
 * @date 2020-12-16 16:36
 */
@RestController
public class IndexDataController {
	@Autowired
	IndexDataService indexDataService;

	@Autowired
	IpConfiguration ipConfiguration;

	@GetMapping("/data/{code}")
	public List<IndexData> get(@PathVariable("code") String code) {
		System.out.println("current instance is:" + ipConfiguration.getPort());
		return indexDataService.get(code);
	}
}
