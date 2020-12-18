package cn.how2j.trend.service;

import cn.how2j.trend.pojo.Index;
import cn.hutool.core.collection.CollUtil;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.how2j.trend.service
 * @ClassName:IndexService
 * @Description:
 * @date 2020-12-16 12:20
 */
@Service
@CacheConfig(cacheNames = "indexes")
public class IndexService {
	private List<Index> indexes;

	@Cacheable(key = "'all_codes'")
	public List<Index> get(){
		Index index = new Index();
		index.setName("无效指数代码");
		index.setCode("0000000");
		return CollUtil.toList(index);
	}
}
