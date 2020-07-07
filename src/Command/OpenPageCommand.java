package Command;

import Model.IModel;
import View.IView;

public abstract class OpenPageCommand implements ICommand {
	protected IView V;
	protected IModel M;
	
	public OpenPageCommand(IView view,IModel model) {
		V = view;
		M = model;
	}
}
