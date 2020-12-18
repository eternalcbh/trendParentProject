package cn.how2j.trend;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.NetUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//springBoot启动器
@SpringBootApplication
//开启
@EnableEurekaClient
//开启断路器
@EnableHystrix
//开启reids
@EnableCaching
/**
 * @author cbh
 * @PackageName:cn.how2j.trend
 * @ClassName:IndexGatherStoreApplication
 * @Description:用来获取第三方的数据
 * @date 2020-12-13 16:16
 */
public class IndexGatherStoreApplication {
	public static void main(String[] args) {
		int port = 0;
		int defautlPort = 8001;
		int eurekaServerPort = 8761;
		int reidsPort = 6379;

		port = defautlPort;

		if (NetUtil.isUsableLocalPort(eurekaServerPort)) {
			System.err.printf("检测到端口%d未启用,判断eureka服务器未启动，本服务无法使用，故退出%n", eurekaServerPort);
			System.exit(1);
		}

		if (NetUtil.isUsableLocalPort(reidsPort)){
			System.err.printf("检测到端口%d未启用,判断reids服务器未启动,本服务无法启动,故退出%n", reidsPort);
			System.exit(1);
		}

		if (null != args && 0 != args.length) {
			for (String arg : args) {
				if (arg.startsWith("port=")){
					String strPort = StrUtil.subAfter(arg, "port=", true);
					if (NumberUtil.isNumber(strPort)){
						port = Convert.toInt(strPort);
					}
				}
			}
		}

		if (!NetUtil.isUsableLocalPort(port)){
			System.err.printf("端口%d被占用了,无法启动%n",port);
			System.exit(1);
		}
		new SpringApplicationBuilder(IndexGatherStoreApplication.class).properties("server.port=" + defautlPort).run(args);
	}

	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
