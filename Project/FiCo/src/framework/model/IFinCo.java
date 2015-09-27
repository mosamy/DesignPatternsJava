package framework.model;
import java.util.*;

/**
 * 
 */
public interface IFinCo extends IFinCoSubject {

	public void addNewAccount(String custType);

	public void deposit(String acctNum, String name, Double amount);

	public void addInterest();


}