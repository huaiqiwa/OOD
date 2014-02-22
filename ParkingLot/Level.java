public class Level {
	private int floor;
	private ParkingSpot[] spots;
	private int availableSpots = 0;
	private static final int SPOTS_PER_ROW = 10;
	
	public Level(int flr, int numberSpots) {
		floor = flr;
		spots = new ParkingSpot[numberSpots];
		int largeSpots = numberSpots / 4;
		int bikeSpots = numberSpots / 4;
		int compactSpots = numberSpots - largeSpots - bikeSpots;
		for(int i = 0; i < numberSpots; i++) {
			VehicleSize sz = VehicleSize.Motorcycle;
			if(i < largeSpots) sz = VehicleSize.Large;
			else if(i < largeSpots+compactSpots) sz = VehicleSize.Compact;
			int row = i / SPOTS_PER_ROW;
			spots[i] = new ParkingSpot(this, row, i, sz);
		}
		availableSpots = numberSpots;
	}
	
	public int availableSpots() {
		return availableSpots;
	}
	
	public boolean parkVehicle(Vehicle vehicle) {
		if(availableSpots() < vehicle.getSpotsNeeded()) return false;
		int spotNumber = findAvailableSpots(vehicle);
		if(spotNumber < 0) return false;
		return parkStartingAtSpot(spotNumber, vehicle);
	}
	
	private boolean parkStartingAtSpot(int spotNumber, Vehicle vehicle) {
		vehicle.clearSpots();
		boolean success = true;
		for(int i = spotNumber; i < spotNumber+vehicle.spotsNeeded; i++) {
			success &= spots[i].park(vehicle);
		}
		availableSpots -= vehicle.spotsNeeded;
		return success;
	}
	
	private int findAvailableSpots(Vehicle vehicle) {
		...
	}
	
	public void print() {
		...
	}
	
	public void spotFreed() {
		availableSpots++;
	}
}























