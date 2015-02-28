package org.heng.mode.bean;

import org.heng.mode.model.ChainRequest;

public class HelpRequest extends ChainRequest{

	public HelpRequest(String type) {
		super(type);
		
	}

	@Override
	public void execute() {
		System.out.println("helpRequest");		
	}
	
	

}
