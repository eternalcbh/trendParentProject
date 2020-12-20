package cn.how2j.trend;


import cn.hutool.core.convert.Convert;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.NetUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author cbh
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class TrendTradingBackTestServiceApplication {
	public static void main(String[] args) {
		int port = 0;
		int defaultPort = 8051;
		int eurekaServerPort = 8761;

		if (NetUtil.isUsableLocalPort(eurekaServerPort)){
			System.out.printf("检测到端口%d未启用,判断eureka服务器未启动,本服务无法使用,故退出%n",eurekaServerPort);
			System.exit(1);
		}

		if (null != args && 0 != args.length){
			for (String arg : args) {
				if (arg.startsWith("port=")){
					String strPort = StrUtil.subAfter(arg, "port=", true);
					if (NumberUtil.isNumber(strPort)){
						port = Convert.toInt(strPort);
					}
				}
			}
		}

		if (0 == port){
			Future<Integer> future = ThreadUtil.execAsync(() -> {
				int p = 0;
				System.out.printf("请玉5s内输入端口号,推荐 %d ,超过5s将使用默认 %d ", defaultPort, defaultPort);
				Scanner scanner = new Scanner(System.in);
				while (true) {
					String strPort = scanner.nextLine();
					if (!NumberUtil.isInteger(strPort)) {
						System.out.println("只能是数字");
						continue;
					} else {
						p = Convert.toInt(strPort);
						scanner.close();
						break;
					}
				}
				return p;
			});
			try{
				port = future.get(5, TimeUnit.SECONDS);
			} catch (InterruptedException | ExecutionException | TimeoutException e) {
				port = defaultPort;
			}

			if (!NetUtil.isUsableLocalPort(port)){
				System.out.printf("端口%d被占用了,无法启动%n",port);
				System.exit(1);
			}
			new SpringApplicationBuilder(TrendTradingBackTestServiceApplication.class).properties("server.port=" + port).run(args);
		}
	}
}
