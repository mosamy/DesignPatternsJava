import java.util.Stack;

import com.sun.org.apache.bcel.internal.generic.CPInstruction;
import com.sun.org.apache.bcel.internal.generic.POP;

public class CommandManager {
	
	private ICommand  pop;
	private ICommand push;
	private VStack inStack;
	
	private int commandhistorypointer = 0;
	private Stack<ICommand> commandHistory;
	public CommandManager (VStack stack)
	{
		commandHistory = new Stack<ICommand>();
		
		inStack = stack;
		//pop = new PopCommand(inStack);
		//push = new PushCommand(inStack);
		
	}
	
	public CommandManager(ICommand command)
	{
		command.execute();
	}
	
	public void Execute(ICommand c)
	{
		c.execute();
	}
	
	public void Execute(CommandType ct)
	{
		switch (ct) {
		case Pop:
			pop =  new PopCommand(inStack);
			
			pop.execute();
			commandHistory.push(pop);
			//commandhistorypointer++;
			break;

		case Push:
			push =  new PushCommand(inStack);
			push.execute();
			commandHistory.push(push);
			//commandhistorypointer++;
			break;
		
			
		case Undo:
		//commandHistroy.pop().
			
			//ICommand cmdun = (ICommand) commandHistory.elementAt(commandhistorypointer);
			if (commandhistorypointer < commandHistory.size()){
				ICommand cmdun = (ICommand) commandHistory.elementAt(commandhistorypointer);
			commandhistorypointer++;
			cmdun.undo();
			}
			else
			{
				commandhistorypointer = commandHistory.size();
			}
			
			break;
			
		case Redo:
			
			commandhistorypointer--;
				
				if (commandhistorypointer >= 0){
					ICommand cmdre = (ICommand) commandHistory.elementAt(commandhistorypointer);
					cmdre.redo();
					}
				else
				{
					commandhistorypointer = 0;
				}
				
				
				break;
				
		case Clear:
			
			break;
			
		default:
			break;
		}
	}
	
	//8663934608
	

}
