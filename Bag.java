import java.util.Scanner;

public class Bag 
{
	String maker;
	int price;
	
	void storeBagData()
	{
		Scanner s1 = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		
		System.out.print("Input maker of bag: ");
		maker = s1.nextLine();
		
		System.out.print("Input price for bag: ");
		price = s2.nextInt();
	}
	
	void showBagsData()
	{
		System.out.println("maker is "+maker);
		System.out.println("price is "+price+" INR");
	}
	
	public static void main(String[] args) 
	{
		Bag b1 = new Bag();
		
		b1.storeBagData();
		
		b1.showBagsData();
		
	}
}
