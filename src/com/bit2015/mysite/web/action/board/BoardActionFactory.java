package com.bit2015.mysite.web.action.board;

import com.bit2015.web.action.Action;
import com.bit2015.web.action.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if( "view".equals( actionName ) ) {
			action = new ViewAction();
		} else if( "write".equals( actionName ) ) {
			action = new WriteAction();
		} else if( "modify".equals( actionName ) ) {
			action = new ModifyAction();
		} else if( "insert".equals( actionName ) ) {
			action = new InsertAction();
		} else if( "delete".equals( actionName ) ) {
			action = new DeleteAction();
		} else if( "update".equals( actionName ) ) {
			action = new UpdateAction();
		} else {
			action = new ListAction();
		}
		
		return action;
	}

}
