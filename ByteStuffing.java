package computernetworkslab;
import java.util.*;
public class ByteStuffing {
	public static void print(String arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+"  ");
		}
	}
	public static void main(String[] args) {
		//Scanner sc=new Scanner(System.in);
		
		String arr[]=new String[10];
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter elements");
		System.out.println(arr.length);
		for(int i=0;i<arr.length;i++)
		{
			if(i==0)
			{
				arr[i]="FLAG";
			}
			else if(i==1)
			{
				arr[i]="HEADER";
			}
			else if(i==arr.length-1)
			{
				arr[i]="FLAG";
			}
			else if(i==arr.length-2)
			{
				arr[i]="TAILOR";
			}
			else
			{
				arr[i]=s.next();
			}
		}
		System.out.println("\nBefore Stuffing");
		print(arr);
		System.out.println();
		//STUFFING
		int count=0;
		for(int i=2;i<arr.length-2;i++)
		{
			
			if(arr[i].equals("FLAG"))
			{
				//System.out.println("FOund");
				count++;
			}
		}
		
		String newarr[]=new String[arr.length+count];
		if(count!=0)
		{
			int j=0;
			for(int i=0;i<arr.length;i++)
			{
				if(arr[i].equals("FLAG") && i>1 && i<arr.length-1 )
				{
					newarr[j]=arr[i];
					j++;
					newarr[j]="ESC";
					j++;
				}
				else {
					newarr[j]=arr[i];
					j++;
				}
				
			}
		}
		System.out.println("\nAfter Stuffing");
		print(newarr);
		
		//destuffing
		int counts=0;
		for(int i=1;i<newarr.length-1;i++)
		{
			if(newarr[i].equals("FLAG") && newarr[i+1].equals("ESC"))
			{
				counts++;
			}
		}
		//System.out.println(counts);
		//System.out.println(newarr.length);
		String str[]=new String[newarr.length-counts];
		int i=0;
		int m=0;
		for( i=0;i<newarr.length-1;i++)
		{
			
			if(newarr[i].equals("FLAG") && newarr[i+1].equals("ESC") && i>1 && i<newarr.length-1)
			{
				str[m]=newarr[i];
				i=i+1;
				m++;
			}
			else
			{
				str[m]=newarr[i];
				m++;
			}
		}
		while(i<newarr.length)
		{
			str[m]=newarr[i];
			m++;
			i++;
		}
			
		System.out.println("\n\nAfter Destuffing  -----  ");
		print(str);
		//System.out.println(str.length);
	}
	

	

}
