package org.heng.mode.main;

import org.heng.mode.model.ChainRequest;

/**
 * 责任链模式
 * @author wangdi5
 *
 */
public interface ChainHandler {
	
	public void handleRequest(ChainRequest request);

}
