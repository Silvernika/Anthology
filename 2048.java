import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class 2048
{
	public static int[][] mat = new int[4][4];
	static int count1=0;

	public static void displaygrid()
	{
		for(int i=0;i<4;i++)
		{
			System.out.println();
			for(int j=0;j<4;j++)
			{
				System.out.print(mat[i][j]+" ");
			}
		}
	}
	public static int hasWon()
	{
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(mat[i][j]==2048)
				{
					return 1;
				}
			}
		}
		return 0;
	}
	public static int checkTermination()
	{
		int count=0;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(mat[i][j]==0)
				{
					count++;
				}
			}
		}
		if(count==0)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	public static void right()
	{
		for(int j=3;j>0;j--)
		{
			for(int i=0;i<4;i++)
			{
				while((mat[i][j]==0)&&(mat[i][j-1]!=0))
				{
					mat[i][j]=mat[i][j-1];
					mat[i][j-1]=0;
					j=3;
				}
				if(mat[i][j]==mat[i][j-1])
				{
					mat[i][j]=mat[i][j]*2;
					mat[i][j-1]=0;
				}
			}
		}	
		displaygrid();	
	}
	public static void left()
	{
		for(int j=0;j<3;j++)
		{
			for(int i=0;i<4;i++)
			{
				while((mat[i][j+1]!=0)&&(mat[i][j]==0))
				{
					mat[i][j]=mat[i][j+1];
					mat[i][j+1]=0;
					j=0;
				}
				if(mat[i][j+1]==mat[i][j])
				{
					mat[i][j]=mat[i][j+1]*2;
					mat[i][j]=0;
				}
			}
		}
		displaygrid();
	}
	public static void upper()
	{
		for(int i=3;i>0;i--)
		{
			for(int j=0;j<4;j++)
			{
				while((mat[i-1][j]==0)&&(mat[i][j]!=0))
				{
					mat[i-1][j]=mat[i][j];
					mat[i][j]=0;
					i=3;
				}
				if(mat[i-1][j]==mat[i][j])
				{
					mat[i-1][j]=mat[i][j]*2;
					mat[i][j]=0;
				}
			}
		}
		displaygrid();
	}
	public static void down()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=3;j>0;j--)
			{
				while((mat[i+1][j]==0)&&(mat[i][j]!=0))
				{
					mat[i+1][j]=mat[i][j];
					mat[i][j]=0;
					j=3;
				}
				if(mat[i+1][j]==mat[i][j])
				{
					mat[i+1][j]=mat[i][j]*2;
					mat[i][j]=0;
				}
			}
		}
	  displaygrid();	
	}
	public static void generateTile()
	{
		int t,h;
		for(int i=0;;i++)
		{
			Random r = new Random();
			int r1 = r.nextInt(4);
			int r2 = r.nextInt(4);
			if(mat[r1][r2]!=0)
			{
				continue;
			}
			else
			{
				t=r1;
				h=r2;
				break;
			}
		}
		if(count1%2==0)
			{
				mat[t][h]=2;
				count1++;
			}
		else
			{
				mat[t][h]=4;
				count1++;
			}	
			
		}
	public static void main(String[] args) throws IOException
	{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		Scanner s =  new Scanner(System.in);
		int l=1;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				mat[i][j]=0;
			}
		}
		while(l==1)
		{
			generateTile();
			System.out.println(" ");
			char ch = s.next().charAt(0);
			if(ch=='R'||ch=='r')
			{
				right();
			}
			else if(ch=='Q'||ch=='q')
			{
				System.out.println("Thank You");
				System.exit(0);
			}
			else if(ch=='L'||ch=='l')
			{
				left();
			}
			else if(ch=='U'||ch=='u')
			{
				upper();
			}
			else 
			{
				down();
			}
			int k=checkTermination();
			if(k==1)
			{
				System.out.println("GAME OVER");
				System.exit(0);
			}
			else
			{
				continue;
			}
			int d=hasWon();
			if(d==1)
			{
				System.out.println("Congrats");
				System.exit(0);
			}
		}
	}
}
