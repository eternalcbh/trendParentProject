package cn.how2j.trend.service;

import cn.how2j.trend.pojo.IndexData;
import cn.hutool.core.collection.CollUtil;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.how2j.trend.service
 * @ClassName:IndexDataService
 * @Description:
 * @date 2020-12-16 16:33
 */
@Service
@CacheConfig(cacheNames = "index_datas")
public class IndexDataService {
	@Cacheable(key = "'indexData-code-' + #p0")
	public List<IndexData> get(String code){
		return CollUtil.toList();
	}
}
