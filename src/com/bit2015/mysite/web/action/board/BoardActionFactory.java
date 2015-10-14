package com.bit2015.mysite.web.action.board;

import com.bit2015.web.action.Action;
import com.bit2015.web.action.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if( "view".equals( actionName ) ) {
			
		} else {
			action = new ListAction();
		}
		
		return action;
	}

}
