package createDB;


	interface selectcolor
	{
	int blue=4;
	int yellow=5;
	int pink=6;
	public void choose(int color);
	}
	class Demo implements selectcolor
	{
	public void choose(int color)
	{
	switch(color)
	{
	case blue:
	   System.out.println("The color selected is blue");
	   break;
	case yellow:
	   System.out.println("The color selected is yellow");
	   break;
	case pink:
	   System.out.println("The color selected is pink");
	   break;
	}
	}
	public static void main(String aa[])
	{
	int a1,b1,c1;
	a1=Integer.parseInt(aa[0]);
	b1=Integer.parseInt(aa[1]);
	c1=Integer.parseInt(aa[2]);
	//a1=4;
	//b1=5;
	//c1=6;
	Demo st=new Demo();
	st.choose(a1);
	st.choose(b1);
	st.choose(c1);
	}
	}
