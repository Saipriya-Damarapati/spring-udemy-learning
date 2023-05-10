package learn.mockito.mockitodemo.business;

public class SomeBusinessImpl {

	public DataService dataService;
	
	public SomeBusinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}

	public int findTheGreatestFromAllData() {
		int[] data = dataService.retrieveAllData();
		int greatestValue = Integer.MIN_VALUE;
		for(int value : data) {
			if(value > greatestValue) {
				greatestValue = value;
			}
		}
		return greatestValue;
	}
}

interface DataService {
	int[] retrieveAllData();
}