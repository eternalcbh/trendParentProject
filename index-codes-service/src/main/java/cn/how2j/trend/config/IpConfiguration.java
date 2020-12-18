package cn.how2j.trend.config;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author cbh
 * @PackageName:cn.how2j.trend.config
 * @ClassName:IpConfiguration
 * @Description:
 * @date 2020-12-16 11:19
 */
@Component
public class IpConfiguration implements ApplicationListener<WebServerInitializedEvent> {

	private int serverPort;

	@Override
	public void onApplicationEvent(WebServerInitializedEvent webServerInitializedEvent) {
		this.serverPort = webServerInitializedEvent.getWebServer().getPort();
	}

	public int getPort(){
		return this.serverPort;
	}
}
