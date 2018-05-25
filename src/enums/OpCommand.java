package enums;

import java.util.HashMap;
import java.util.Map;

public class OpCommand implements Command{
	public static Map<String ,String> comandos = new HashMap<String,String>(); 
	static {
		comandos.put("1", new Status().PRIVATE());
		comandos.put("2", new Status().UNDER_REVIEW());
		comandos.put("3", new Status().PUBLIC());
		comandos.put("4", new Status().ENDED());
	
	}
	
	public String execute(String op) {
		return comandos.get(op);
	}
	
}
