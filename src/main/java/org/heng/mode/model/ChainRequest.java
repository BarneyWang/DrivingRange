package org.heng.mode.model;


/**
 * 责任链model
 * @author wangdi5
 *
 */
public abstract class ChainRequest {

	private String type;

	public ChainRequest(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	/**
	 * 处理流程
	 */
	public  abstract void execute();

}
