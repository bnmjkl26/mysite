package com.bit2015.mysite.web.action.guestbook;

import com.bit2015.web.action.Action;
import com.bit2015.web.action.ActionFactory;

public class GuestbookActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if( "deleteform".equals( actionName ) ) {
			action = new DeleteFormAction();
		} else if( "delete".equals( actionName ) ) {
			action = new DeleteAction();
		} else if( "insert".equals( actionName ) ) {
			action = new InsertAction();
		} else {
			action = new IndexAction();
		}
		
		return action;
	}

}
