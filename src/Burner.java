
public class Burner {
	public enum Temperature{HOT,WARM,COLD};
	public final static int TIME_DURATION=2;
	public int timer;
	private Temperature myTemperature;
	private Setting mySetting;
	
	
	public Burner(){
		super();
		timer=0;
		myTemperature=Temperature.COLD;
		mySetting=Setting.OFF;
	}

/*	public Burner(int timer, Temperature myTemperature, Setting mySetting) {
		super();
		this.timer = timer;
		this.myTemperature = myTemperature;
		this.mySetting = mySetting;
	}*/

	public Temperature getTemperature(){
		return myTemperature;
	}
	
	public Setting getMySetting(){
		return mySetting;
	}
	
	
	@Override
	public String toString() {
		//return "[" + timer + mySetting + "]";
		return "[" + mySetting + "]";
	}

	public static Burner increaseSetting(Burner b){
		Setting s=b.getMySetting();
		switch(s){
		case HIGH: b.mySetting=Setting.HIGH;
		b.timer=b.timer;
		break;
		case MEDIUM: b.mySetting=Setting.HIGH;
		b.timer+=TIME_DURATION;
		break;
		case LOW: b.mySetting=Setting.MEDIUM;
		b.timer+=TIME_DURATION;
		break;
		case OFF: b.mySetting=Setting.LOW;
		b.timer+=TIME_DURATION;
		break;
		}
		return b;
	}
	
	public static Burner decreaseSetting(Burner b){
		Setting s=b.getMySetting();
		switch(s){
		case OFF: b.mySetting=Setting.OFF;
		b.timer=b.timer;
		break;
		case LOW: b.mySetting=Setting.OFF;
		b.timer+=TIME_DURATION;
		break;
		case MEDIUM: b.mySetting=Setting.LOW;
		b.timer+=TIME_DURATION;
		break;
		case HIGH: b.mySetting=Setting.MEDIUM;
		b.timer+=TIME_DURATION;
		break;
		}
		return b;
	}
	
	public static Burner updateTemperature(Burner b){
		if (b.timer>0){
			b.timer--;
		}
		Setting s=b.getMySetting();
		if (b.timer==0){	
			if (s==Setting.OFF){
				b.myTemperature=Temperature.COLD;
			}else if (s==Setting.LOW){
				b.myTemperature=Temperature.WARM;
			}else if (s==Setting.MEDIUM){
				b.myTemperature=Temperature.WARM;
			}else if (s==Setting.HIGH){
				b.myTemperature=Temperature.HOT;
			}
		}		
		return b;
	}
	
	public static void display(Burner b){
		System.out.print(b);
	}
		
}
