import java.util.ArrayList;
//import java.util.Scanner;

public class Stove {
	private ArrayList<Burner> burners;
	private static int SimTime;
	
	public Stove() {
		burners=new ArrayList<Burner>();
	}

	public void displayStove(){
		System.out.println("Stove -------------");
		boolean REDLIGHT= false;
		for (Burner b:burners){
			Burner.display(b);
			System.out.print(".....");
			if (b.getTemperature()==Burner.Temperature.COLD){
				System.out.println("cooool");
			}else if (b.getTemperature()==Burner.Temperature.WARM){
				System.out.println("CAREFUL");		
			}else if (b.getTemperature()==Burner.Temperature.HOT){
				System.out.println("HOT SURFACE! DON'T TOUCH");
				REDLIGHT=true;
			}
		}
		if (REDLIGHT==true){
			System.out.println("RED LIGHT - HOT BURNER ALERT");
		}
	}
	
	public void timePassage(int SimTime){
/*		Scanner scan=new Scanner(System.in);
		System.out.println("Enter simulation time:");
		try {
			SimTime=scan.nextInt();
		} catch(NumberFormatException e)
		{
			System.out.println("This is not an integer of time");
		}*/
		for (int i=SimTime;i>0;i--){
			for (Burner b:burners){
				b=Burner.updateTemperature(b);
			}
		}
		
	}
	
	public void addBurner(){		
		for (int i = 0;i<4;i++){
			Burner burner=new Burner();
			burners.add(burner);
		}	
	}
	
	public void changeSettings1(){
		Burner tl=burners.get(0);
		tl=Burner.increaseSetting(tl);
		tl=Burner.increaseSetting(tl);
		tl=Burner.increaseSetting(tl);
		burners.add(1,tl);
		burners.remove(0);
		
		Burner tr=burners.get(1);
		tr=Burner.increaseSetting(tr);
		tr=Burner.increaseSetting(tr);
		burners.add(2,tr);
		burners.remove(1);
		
		Burner bl=burners.get(2);
		bl=Burner.increaseSetting(bl);
		burners.add(3,bl);
		burners.remove(2);
	}
	
	public void changeSettings2(){
		Burner tl=burners.get(0);
		tl=Burner.decreaseSetting(tl);
		tl=Burner.decreaseSetting(tl);
		burners.add(1,tl);
		burners.remove(0);
		
		Burner tr=burners.get(1);
		tr=Burner.increaseSetting(tr);
		burners.add(2,tr);
		burners.remove(1);
		
		Burner bl=burners.get(2);
		bl=Burner.decreaseSetting(bl);
		burners.add(3,bl);
		burners.remove(2);
	}
	
	public void changeSettings3(){
		Burner tl=burners.get(0);
		tl=Burner.decreaseSetting(tl);
		burners.add(1,tl);
		burners.remove(0);
		
		Burner tr=burners.get(1);
		tr=Burner.decreaseSetting(tr);
		burners.add(2,tr);
		burners.remove(1);
	}
	
	public static void main(String[] args){
		Stove stove=new Stove();
		stove.addBurner();
		stove.displayStove();//Display 1
		
		stove.changeSettings1();
		stove.timePassage(6);
		System.out.println();
		stove.displayStove();//Display 2
		
		stove.changeSettings2();
		stove.timePassage(5);
		System.out.println();
		stove.displayStove();//Display 3
		
		stove.changeSettings3();
		stove.timePassage(2);
		System.out.println();
		stove.displayStove();//Display 4
	}
}
