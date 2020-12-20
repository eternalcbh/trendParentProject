package cn.how2j.trend.pojo;

/**
 * @author cbh
 * @PackageName:cn.how2j.trend.pojo
 * @ClassName:IndexData
 * @Description:
 * @date 2020-12-20 15:15
 */
public class IndexData {
	String date;
	float closePoint;


	public IndexData() {
	}

	public IndexData(String date, float closePoint) {
		this.date = date;
		this.closePoint = closePoint;
	}

	/**
	 * 获取
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * 设置
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * 获取
	 * @return closePoint
	 */
	public float getClosePoint() {
		return closePoint;
	}

	/**
	 * 设置
	 * @param closePoint
	 */
	public void setClosePoint(float closePoint) {
		this.closePoint = closePoint;
	}

	public String toString() {
		return "IndexData{date = " + date + ", closePoint = " + closePoint + "}";
	}
}
