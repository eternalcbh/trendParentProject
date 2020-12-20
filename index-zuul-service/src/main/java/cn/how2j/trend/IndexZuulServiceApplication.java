package cn.how2j.trend;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author cbh
 * @PackageName:cn.how2j
 * @ClassName:trend
 * @Description:
 * @date 2020-12-18 21:44
 */
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class IndexZuulServiceApplication {
	public static void main(String[] args) {
		int port = 8031;
		if (!NetUtil.isUsableLocalPort(port)){
			System.err.printf("端口%d被占用了,无法启动%n",port);
			System.exit(1);
		}
		new SpringApplicationBuilder(IndexZuulServiceApplication.class).properties("server.port="+port).build().run(args);
	}
}
