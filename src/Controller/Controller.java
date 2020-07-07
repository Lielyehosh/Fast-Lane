package Controller;

import Command.ICommand;
import Command.OpenMainPageCommand;
import Model.IModel;
import View.IView;



/**
 *	- The Controller behavior dependent on the user inputs.
 *	- Each 'Command' is a dynamic class that executed the required instruction
 *	- The Command's classes interacted with each other, 
 *		mean that a new Command can be invoked from an other Command
 *	- The Command's of the type "OpenPageCommand" are specific.
 *	- Each of the "OpenPageCommand" Holds an instance of the IModel and the IView, same as the controller.
 *
 */
public class Controller implements IController {
	protected IView V;
	protected IModel M;

	public Controller(IModel model, IView view) {
		M = model;
		V = view;
	}

	public void start() {
		ICommand open_main_page = new OpenMainPageCommand(V, M);
		V.addMainBtnListener(e -> (new OpenMainPageCommand(V, M)).execute());
		V.addMainBtnListener(e -> M.save());
		open_main_page.execute();
	}


}
