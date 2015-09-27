package framework.model;

import java.util.*;

/**
 * 
 */
public interface IAccount {

    /**
     * @return
     */
    public String getAcctNo();

    /**
     * @return
     */
    public double getBalance();

    /**
     * @param double amount
     */
    public void deposit(double amount);
    
    public void deposit(double amount,String date);
    
    public void withdraw(double amount,String date);

    /**
     * @return
     */
    public List<String> generateReport();

    /**
     * @return
     */
    public ICustomer getAcctOwner();

    /**
     * @return
     */
    public double getInterestRate();

    
}