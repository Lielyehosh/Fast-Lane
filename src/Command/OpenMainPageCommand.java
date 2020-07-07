package Command;


import Model.IModel;
import View.MainPage.MainPage;
import View.IView;

/**
 *	- This command creates a new main page, intialize the listeners and display it to the frame (V)
 *
 */
public class OpenMainPageCommand extends OpenPageCommand {
	
	public OpenMainPageCommand(IView view,IModel model) {
		super(view,model);
	}
	
	
	@Override
	public void execute() {
		MainPage Page = new MainPage();
		Page.setTitle("Main Page");
		Page.addClientListBtnListener(e -> new OpenClientListPageCommand(V, M).execute());
		Page.addVehicleListBtnListener(e -> new OpenVehicleListPageCommand(V,M).execute());
		Page.addTravelListBtnListener(e -> new OpenTravelListPageCommand(V, M).execute());
		Page.addCreateNewClientBtnListener(e -> new OpenNewClientPageCommand(V, M).execute());
		V.setCenterPanel(Page);
	}

}
