package cn.how2j.trend.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author cbh
 * @PackageName:cn.how2j.trend.util
 * @ClassName:SpringContextUtil
 * @Description:
 * @date 2020-12-14 20:43
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

	private SpringContextUtil(){
		System.out.println("SpringContextUtil()");
	}

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("applicationContext" + applicationContext);
		SpringContextUtil.applicationContext = applicationContext;
	}

	public static <T> T getBean(Class<T> clazz){
		return applicationContext.getBean(clazz);
	}
}
