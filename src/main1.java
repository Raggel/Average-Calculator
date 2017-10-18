import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class main1 {
	public static void main( String[] args) {
		int num[][] = new int[1000][1000];
		for (int x = 0; x < num.length; x++)
			for (int y = 0; y < num[x].length; y++)
				num[x][y] = (int)(Math.random()*899 + 100);	
		
		double srAr = sredLinOtkl( num);
		double srKv = sredKvadOtkl( num);
		
		System.out.println( "Srednee arifmeticheskoe po vsemu massivu =                      " + sredArif( num));
		System.out.println( "Srednee lineinoe(arifmeticheskoe) otklonenie po vsemu massivu = " + srAr);
		System.out.println( "Srednee kvadraticheskoe otklonenie po vsemu massivu =           " + srKv);
		System.out.println( "" );
		
		System.out.println("Otkloneniya po massivu: ");

		int count = 0;
		for (int x = 0; x < num.length; x++)
			for (int y = 0; y < num[x].length; y++)
				if (num[x][y] >= srAr - srKv && num[x][y] <= srAr + srKv)
					count++;
		System.out.println( "I = " + (1.0 *(int)((1.0 * count / (1000*1000)) * 1000))/10 + "%" + ",  ");
		
		int count2 = 0;
		for (int x = 0; x < num.length; x++)
			for (int y = 0; y < num[x].length; y++)
				if ( ( num[x][y] >= srAr - 2*srKv && num[x][y] < srAr - srKv) || ( num[x][y] > srAr + srKv && num[x][y] <= srAr + 2*srKv))
					count2++;
		System.out.println( "II = " + (1.0 *(int)((1.0 * count2 / (1000*1000)) * 1000))/10 + "%" + ",  ");
		
		int count3 = 0;
		for (int x = 0; x < num.length; x++)
			for (int y = 0; y < num[x].length; y++)
				if ( ( num[x][y] >= srAr - 3*srKv && num[x][y] < srAr - 2*srKv) || ( num[x][y] > srAr + 2*srKv && num[x][y] <= srAr + 3*srKv))
					count3++;
		System.out.println( "III = " + (1.0 *(int)((1.0 * count3 / (1000*1000)) * 1000))/10 + "%" + ",  ");
		
		int count4 = 0;
		for (int x = 0; x < num.length; x++)
			for (int y = 0; y < num[x].length; y++)
				if ( ( num[x][y] >= 99 && num[x][y] < srAr - 3*srKv) || ( num[x][y] > srAr + 3*srKv && num[x][y] <= 1000))
					count4++;
		System.out.println( "IV = " + (1.0 *(int)((1.0 * count4 / (1000*1000)) * 1000))/10 + "%" + ",  ");
		
		System.out.println("");
		System.out.println("Otkloneniya po strochkam: ");
		
		for (int x = 0; x < num.length; x++)
		{
		
		int count1 = 0;
			for (int y = 0; y < num[x].length; y++)
				if (num[x][y] >= srAr - srKv && num[x][y] <= srAr + srKv)
					count1++;
		System.out.print( "I = " + (1.0 *(int)((1.0 * count1 / (1000)) * 1000))/10 + "%" + ",  ");
		
		int count12 = 0;
			for (int y = 0; y < num[x].length; y++)
				if ( ( num[x][y] >= srAr - 2*srKv && num[x][y] < srAr - srKv) || ( num[x][y] > srAr + srKv && num[x][y] <= srAr + 2*srKv))
					count12++;
		System.out.print( "II = " + (1.0 *(int)((1.0 * count12 / (1000)) * 1000))/10 + "%" + ",  ");
		
		int count13 = 0;
			for (int y = 0; y < num[x].length; y++)
				if ( ( num[x][y] >= srAr - 3*srKv && num[x][y] < srAr - 2*srKv) || ( num[x][y] > srAr + 2*srKv && num[x][y] <= srAr + 3*srKv))
					count13++;
		System.out.print( "III = " + (1.0 *(int)((1.0 * count13 / (1000)) * 1000))/10 + "%" + ",  ");
		
		int count14 = 0;
			for (int y = 0; y < num[x].length; y++)
				if ( ( num[x][y] >= 99 && num[x][y] < srAr - 3*srKv) || ( num[x][y] > srAr + 3*srKv && num[x][y] <= 1000))
					count14++;
		System.out.println( "IV = " + (1.0 *(int)((1.0 * count14 / (1000)) * 1000))/10 + "%" + ",  ");
		}
		
		System.out.println();
		System.out.println( "Srednee lineinoe(arifmeticheskoe) otklonenie po strochkam: "); 
		
		for (int y = 0; y < num.length; y++)
		{
			if (y % 10 == 0 && y != 0)
				System.out.println("");
			System.out.print( (int)sredLinOtkl( num[y]) + " ");
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println( "Srednee kvadraticheskoe otklonenie po strochkam: "); 
		
		for (int y = 0; y < num.length; y++)
		{
			if (y % 10 == 0 && y != 0)
				System.out.println("");
			System.out.print( (int)sredKvadOtkl( num[y]) + " ");
		}
	}
	
	public static double sredArif(int[] num) {
		double sum = 0;
		for (int i = 0; i < num.length; i++)
			sum += num[i];
		
		return sum / num.length;
	}
	
	public static double sredKvadOtkl( int[] num) {
		double srAr = sredArif( num);
		
		int sum = 0;
		for (int i = 0; i < num.length; i++)
			sum += Math.pow( num[i] - srAr, 2);
		
		return Math.sqrt( sum / num.length);
	}
	
	public static double sredLinOtkl( int[] num) {
		double srAr = sredArif( num);
		
		int sum = 0;
		for (int i = 0; i < num.length; i++)
			sum += Math.abs( num[i] - srAr);
		
		return sum / num.length;
	}
	
	public static double sredArif(int[][] num) {
		int sum = 0;
		for (int[] y: num)
			for (int x: y)
				sum += x;
		
		return sum / (num.length*num[0].length);
	}
	
	public static double sredKvadOtkl( int[][] num) {
		double srAr = sredArif( num);
		
		double sum = 0;
		for (int[] y: num)
			for (int x: y)
			sum += Math.pow( x - srAr, 2);
		
		return Math.sqrt( sum / (num.length*num[0].length));
	}
	
	public static double sredLinOtkl( int[][] num) {
		double srAr = sredArif( num);
		
		int sum = 0;
		for (int[] y: num)
			for (int x: y)
			sum += Math.abs( x - srAr);
		
		return sum / (num.length*num[0].length);
	}
	
	/*public static double sredKvad(double[] num) {
		float sum = 0;
		for (int i = 0; i < num.length; i++)
			sum += Math.pow( num[i], 2);
		
		return (float)Math.sqrt( sum / num.length);
	}
	
	public static double sredGarm(double[] num) {
		float sum = 0;
		for (int i = 0; i < num.length; i++)
			sum += 1 / num[i];
		
		return num.length / sum;
	}
	
	public static double sredGeom(double[] num) {
		float mult = 1;
		for (int i = 0; i < num.length; i++)
			mult *= num[i];
		
		return (float)Math.pow(mult, 1.0 / num.length);
	}*/
	
	
	
	
	
}
