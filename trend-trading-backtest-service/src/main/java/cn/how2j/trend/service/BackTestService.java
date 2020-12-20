package cn.how2j.trend.service;

import cn.how2j.trend.client.IndexDataClient;
import cn.how2j.trend.pojo.IndexData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.how2j.trend.service
 * @ClassName:BacnTestService
 * @Description:
 * @date 2020-12-20 15:52
 */
@Service
public class BackTestService {

	@Autowired
	IndexDataClient indexDataClient;

	public List<IndexData> listIndexData(String code) {
		List<IndexData> result = indexDataClient.getIndexData(code);
		Collections.reverse(result);

		for (IndexData indexData : result) {
			System.out.println(indexData.getDate());
		}
		return result;
	}
}
