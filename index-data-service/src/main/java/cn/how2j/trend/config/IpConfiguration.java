package cn.how2j.trend.config;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.stereotype.Component;

/**
 * @author cbh
 * @PackageName:cn.how2j.trend.config
 * @ClassName:IpConfiguration
 * @Description:
 * @date 2020-12-16 16:28
 */
@Component
public class IpConfiguration {
	private int serverPort;

	public void onApplicationEvent(WebServerInitializedEvent event){
		this.serverPort = event.getWebServer().getPort();
	}

	public int getPort(){
		return this.serverPort;
	}
}
