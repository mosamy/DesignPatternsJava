package CCardApp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.controller.AppLoader;
import framework.controller.IApp;
import framework.model.*;
import CCardApp.controller.*;
import CCardApp.view.*;
import CCardApp.model.*;



public class CCreditApplication extends FinCo implements IApp{
	
	private  ICustomer cust;
	private IAccount acct;
	public static void main(String args[])
	{
			AppLoader app = new AppLoader();
			app.execute(new CCreditApplication());
	}
	
	public void addAccount(String name, IAddress address, String value,
          String acctNo, AcctType acctType, CustomerType custType, String expDate, String email) {

        CreditCardFactory factory = new CreditCardFactory();
        cust = factory.createCustomer(name, custType, address, email, value);
        super.customerList.add(cust);

        acct = factory.createAccount(cust, acctNo, acctType, expDate);

        super.accountList.add(acct);

    }

    public List<String[]> generateReport() {
        List<String[]> report = new ArrayList<String[]>();
        Iterator<IAccount> it = super.accountList.iterator();
        IAccount acct;
        while (it.hasNext()) {
            acct = it.next();
            //sreport.add(acct.generateReport());

        }

        return report;
    }

	@Override
	public void execute() {
		CCreditApplication creditCardProcessingSystem = new CCreditApplication();
        CreditCardController control = CreditCardController.getInstance();
        control.setCreditcardProcessor(creditCardProcessingSystem);
        CreditcardFrame mainFrame = new CreditcardFrame(
                "Creditcard processing Application");
        control.setCreditcardForm(mainFrame);

        mainFrame.setVisible(true);	
		
	}
}
