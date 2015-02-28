package org.heng.mode.main.impl;

import org.heng.mode.bean.HelpRequest;
import org.heng.mode.main.ChainHandler;
import org.heng.mode.model.ChainRequest;

/**
 * 2015年2月28日
 * 
 * @author wangdi5
 *
 */
public class ConcreteHandler implements ChainHandler {

	private ChainHandler successor;

	public ConcreteHandler(ChainHandler successor){
	   this.successor = successor;
	}

	@Override
	public void handleRequest(ChainRequest request) {
		
		  if (request instanceof HelpRequest){
			  request.execute();
		  }else{
			  System.out.println("else");
			  successor.handleRequest(request);
		  }

	}

}
