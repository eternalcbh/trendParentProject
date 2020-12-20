package cn.how2j.trend.client;

import cn.how2j.trend.pojo.IndexData;
import cn.hutool.core.collection.CollectionUtil;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.how2j.trend.client
 * @ClassName:IndexDataClientFeignHystrix
 * @Description:
 * @date 2020-12-20 15:20
 */
@Component
public class IndexDataClientFeignHystrix implements IndexDataClient{
	@Override
	public List<IndexData> getIndexData(String code) {
		IndexData indexData = new IndexData();
		indexData.setClosePoint(0);
		indexData.setDate("0000-00-00");
		return CollectionUtil.toList(indexData);
	}
}
