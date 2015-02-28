package org.heng.mode.model;
/**
 * 责任链model
 * @author wangdi5
 *
 */
public class ChainRequest {

	private String type;

	public ChainRequest(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void execute() {
		//request真正具体行为代码
	}

}
