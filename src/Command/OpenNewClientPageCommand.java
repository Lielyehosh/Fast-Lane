package Command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DataObject.Exceptions.IllegalClientDataException;
import DataObject.Exceptions.IllegalDataException;
import Model.IModel;
import View.NewClientPage.NewClientPage;
import View.IView;

public class OpenNewClientPageCommand extends OpenPageCommand {

	public OpenNewClientPageCommand(IView view, IModel model) {
		super(view, model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		NewClientPage Page = new NewClientPage();
		Page.addSaveBtnListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String client_data_input = Page.getInputDetails();
				try {
					String client_id = M.addNewClient(client_data_input);
					(new OpenClientPageCommand(V, M, client_id)).execute();
				} catch (IllegalClientDataException ex) {
					Page.clearIllegalMsgs();
					Page.displayIllegalInputMsg(ex.getField(), ex.getMessage());
				} catch (IllegalDataException d_ex) {
					d_ex.printStackTrace();
				}
			}
		});
		Page.addBackBtnListener(e -> new OpenMainPageCommand(V, M).execute());
		V.setCenterPanel(Page);
	}

}
