package com.bit2015.mysite.web.action.main;

import com.bit2015.web.action.Action;
import com.bit2015.web.action.ActionFactory;

public class MainActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = new IndexAction(); 
		return action;
	}

}
