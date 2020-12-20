package cn.how2j.trend.client;

import cn.how2j.trend.pojo.IndexData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.how2j.trend.pojo
 * @ClassName:IndexDataClient
 * @Description:
 * @date 2020-12-20 15:16
 */
@FeignClient(value = "INDEX-DATA-SERVICE",fallback = IndexDataClientFeignHystrix.class)
public interface IndexDataClient {
	@GetMapping("/data/{code}")
	public List<IndexData> getIndexData(@PathVariable("code") String code);
}
