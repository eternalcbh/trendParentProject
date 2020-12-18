package cn.how2j.trend.pojo;

/**
 * @author cbh
 * @PackageName:cn.how2j.trend.pojo
 * @ClassName:Index
 * @Description:用来存储指数信息
 * @date 2020-12-13 14:33
 */
public class Index {
	String code;
	String name;

	public Index() {
	}

	public Index(String code, String name) {
		this.code = code;
		this.name = name;
	}

	/**
	 * 获取
	 * @return code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获取
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "Index{code = " + code + ", name = " + name + "}";
	}
}
