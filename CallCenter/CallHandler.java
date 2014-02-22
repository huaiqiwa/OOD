public class CallHandler {
	private static CallHandler = new CallHandler();
	private final int LEVELS = 3;
	private final int NUM_RESPONDENTS = 10;
	private final int NUM_MANAGERS = 4;
	private final int NUM_DIRECTORS = 2;
	
	List<List<Employee>> employeeLevels;
	List<List<Call>> callQueues;
	
	private CallHandler() {
		employeeLevels = new ArrayList<List<Employee>>(LEVELS);
		callQueues = new ArrayList<List<Call>>(LEVELS);
		
		ArrayList<Employee> respondents = new ArrayList<Employee>(NUM_RESPONDENTS);
		for()
	}
	
	public static CallHandler getInstance() {
		return instance;
	}
	
	public Employee getHandlerForCall(Call call) {
		
	}
	
	public void dispatchCall(Caller caller) {
		Call call = new Call(caller);
		dispatchCall(call);
	}
	
	public void dispatchCall(Call call) {
		Employee emp = getHandlerForCall(call);
		if(emp != null) {
			emp.receiveCall(call);
			call.setHandler(emp);
		} else {
			call.reply("Please wait for free employee to reply");
			callQueues.get(call.getRank().getValue()).add(call);
		}
	}
	
	public boolean assignCall(Employee emp) {
		for()
	}
}















