package cn.how2j.trend.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author cbh
 * @PackageName:cn.how2j.trend.web
 * @ClassName:ViewController
 * @Description:
 * @date 2020-12-22 9:05
 */
@Controller
public class ViewController {
	@GetMapping("/")
	public String view(){
		return "view";
	}
}
