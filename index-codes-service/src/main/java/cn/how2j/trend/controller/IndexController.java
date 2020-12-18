package cn.how2j.trend.controller;

import cn.how2j.trend.config.IpConfiguration;
import cn.how2j.trend.pojo.Index;
import cn.how2j.trend.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.how2j.trend.controller
 * @ClassName:IndexController
 * @Description:
 * @date 2020-12-16 15:02
 */
@RestController
public class IndexController {
	@Autowired
	IndexService indexService;

	@Autowired
	IpConfiguration ipConfiguration;

	@GetMapping("/codes")
	@CrossOrigin
	public List<Index> codes(){
		System.out.println("current instance's port is" + ipConfiguration.getPort());
		return indexService.get();
	}
}
