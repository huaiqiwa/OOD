abstract class Employee {
	private Call currentCall = null;
	protected Rank rank;
	
	public Employee() {}
	
	public void receiveCall(Call call) {
		currentCall = call;
	}
	
	public void callCompleted() {
		if(currentCall != null) {
			currentCall.disconnect();
			currentCall = null;
		}
		assignNewCall();
	}
	
	public void escalateAndReassign() {
		if(currentCall != null) {
			currentCall.incrementRank();
			CallHandler.getInstance().dispatchCall(currentCall);
			currentCall = null;
		}
		assignNewCall();
	}
	
	public boolean assignNewCall() {
		if(!isFree()) return false;
		return CallHandler.getInstance().assignCall(this);
	}
	
	public boolean isFree() {
		return currentCall == null;
	}
	
	public Rank getRank() {
		return rank;
	}
}