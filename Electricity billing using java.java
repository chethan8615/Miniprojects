package mini;
import java.sql.*;
import java.util.Scanner;
class Admin
{
	
	String user=new String("chethan");
	String password=new String("rmpcrmpc");
	int Adlogin() throws Exception
	{   
		int m=1;
		String us;
		String pas;
		Scanner adlg=new Scanner(System.in);
	    System.out.println("LOADING PLEASE WAIT");
        
		System.out.println("*****  ADMIN LOGIN  *****");
		System.out.println("USER NAME:");
		us =adlg.next();
		System.out.println("PASSWORD:");
		pas=adlg.next();
		int usercmp=user.compareTo(us);
		int passcmp=password.compareTo(pas);
		if(usercmp ==0 && passcmp==0)
		{
			int opt_loop=1;
			Scanner opt=new Scanner(System.in);
			System.out.println("LOGIN SUCCESSFUL");
			while(opt_loop==1)
			{
	          //clear screen
			  System.out.println("**************OPTIONS*************");
			  System.out.println("1.VIEW ALL THE CUSTOMERS BILLS");
			  System.out.println("2.SEARCH FOR CUSTOMER BILL");
			  System.out.println("3.VIEW ALL THE CUSTOMERS CONNECTION FORMS");
			  System.out.println("4.SEARCH FOR CUSTOMER CONNECTION FORM");
			  System.out.println("5.EXIT");
			  System.out.println("ENTER YOUR CHOICE:");
			  int variable_option=opt.nextInt();
			   if(variable_option==1)
			   {
				 allRecords();
			   }
			   else if(variable_option==2)
			   {
				   search_customer();
			   }
			   else if(variable_option==3)
			   {
				   allRecord();
			   }
			   else if(variable_option==4)
			   {
				   search_form();
			   }

			   else if(variable_option==5)
			   {
				   System.out.println("GOING BACK TO LOGIN PAGE");
				   // for desing
			        try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   
				   m=0;
				   break;
			   }
		    }
		}
		else
		{
			System.out.println("LOGIN UNSUCCESSFUL");
			System.out.println("WORNG USERNAME OR PASSWORD");
			System.out.println("GOING BACK TO MAIN LOGIN MENU");
			 m=0;
		}
		return m;
	}
	//METHOD FOR VIEWING ALL THE RECORDS
	void allRecords() throws SQLException 
	{
		String url="jdbc:mysql://localhost:3306/miniproject";
		String uname="root";
		String pass="rmpcrmpc";
		String query="select * from customer";
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection con = DriverManager.getConnection(url,uname,pass);
		
        Statement st = con.createStatement();
        ResultSet rs =st.executeQuery(query);
        System.out.println("ALL BILL RECORDS ");
       while(rs.next())
        {
    	 
    	   System.out.println("********************************************* ");
    	   System.out.println("--------------------------------------------- ");
    	   System.out.println("CustomerId     :"+rs.getString(1));
    	   System.out.println("CustomerName   :"+rs.getString(2));
    	   System.out.println("TotalUnits     :"+rs.getString(3));    	  
    	   System.out.println("Type           :"+rs.getString(4));
    	   System.out.println("TotalAmount    :"+rs.getString(5)+"RS-/-");
    	   System.out.println("PaymentStatus  :"+rs.getString(6));
    	   System.out.println("--------------------------------------------- ");
           System.out.println("********************************************* ");
           System.out.println(" ");  
           
        }
       st.close();
       con.close();
	}
	void allRecord() throws SQLException 
	{
		String url="jdbc:mysql://localhost:3306/miniproject";
		String uname="root";
		String pass="rmpcrmpc";
		String query="select * from registeration";
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection con = DriverManager.getConnection(url,uname,pass);
		
        Statement st = con.createStatement();
        ResultSet rs =st.executeQuery(query);
        System.out.println("ALL CONNECTION RECORDS ");
       while(rs.next())
        {
    	   
 	        	
 	        	System.out.println("***********----------REGISTERED FORM----------***********");
 	        	System.out.println("CUSTOMERID    :\t"+rs.getString(1));
 	        	System.out.println("CUSTOMER NAME :\t"+rs.getString(2));
 	        	System.out.println("FATHERNAME    :\t"+rs.getString(3));
 	        	System.out.println("MOTHERNAME    :\t"+rs.getString(4));
 	        	System.out.println("DOB           :\t"+rs.getString(5));
 	        	System.out.println("ADDRESS       :\t"+rs.getString(6));
 	        	System.out.println("ADHAAR NO     :\t"+rs.getString(7));
 	        	System.out.println("PAN NO        : "+rs.getString(8));
 	        	System.out.println("ELECTION ID   :\t"+rs.getString(9));
 	        	System.out.println("OCCUPATION    :\t"+rs.getString(10));
 	        	System.out.println("STATE         :\t"+rs.getString(11));
 	        	System.out.println("DISTRICT      : "+rs.getString(12));
 	        	System.out.println("TALUK         : "+rs.getString(13));
 	        	System.out.println("VILLAGE       : "+rs.getString(14));
 	        	System.out.println("SURVEY NO     : "+rs.getString(15));
 	        	System.out.println("HISSA NO      : "+rs.getString(16));    	
 	        	System.out.println("APPROVED     : "+rs.getString(17));
    	  
        }
       st.close();
       con.close();
	}
	//METHOD FOR VIEWING THE RECORD OF A PARTICULAR CUSTOMER
	void search_form()throws SQLException
	{    
		Boolean z=true;
		while(z)
		{
		String P_N;
		String query="select * from registeration where CUSTOMERID = ?";
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER THE CUSTOMERID OF THE CUSTOMER :");
		P_N=sc.next();
		String url="jdbc:mysql://localhost:3306/miniproject";
		String uname="root";
		String pass="rmpcrmpc";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con =DriverManager.getConnection(url,uname,pass);
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1, P_N);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			    System.out.println("***********----------REGISTERED FORM----------***********");
	        	System.out.println("CUSTOMERID    :\t"+rs.getString(1));
	        	System.out.println("CUSTOMER NAME :\t"+rs.getString(2));
	        	System.out.println("FATHERNAME    :\t"+rs.getString(3));
	        	System.out.println("MOTHERNAME    :\t"+rs.getString(4));
	        	System.out.println("DOB           :\t"+rs.getString(5));
	        	System.out.println("ADDRESS       :\t"+rs.getString(6));
	        	System.out.println("ADHAAR NO     :\t"+rs.getString(7));
	        	System.out.println("PAN NO        : "+rs.getString(8));
	        	System.out.println("ELECTION ID   :\t"+rs.getString(9));
	        	System.out.println("OCCUPATION    :\t"+rs.getString(10));
	        	System.out.println("STATE         :\t"+rs.getString(11));
	        	System.out.println("DISTRICT      : "+rs.getString(12));
	        	System.out.println("TALUK         : "+rs.getString(13));
	        	System.out.println("VILLAGE       : "+rs.getString(14));
	        	System.out.println("SURVEY NO     : "+rs.getString(15));
	        	System.out.println("HISSA NO      : "+rs.getString(16));    	
	        	System.out.println("APPROVED     : "+rs.getString(17));
	  
     	       System.out.println("DO YOU WANT TO SEARCH MORE ");
		       System.out.println("PRESS 1 TO COUNTINUE AND 0 EXIT:");
     	   int loop_control=sc.nextInt();
     	    if(loop_control==0)
     	    {
     		  break;
         	}
		}
		else
		{
			System.out.println("THERE IS NO CUSTOMER WITH THAT CUSTOMERID!");
			System.out.println("GOING BACK TO OPTION PAGE.....");	
			break;
		}
     	pst.close();
        con.close();
		}
	}

void search_customer()throws SQLException
{    
	Boolean z=true;
	while(z)
	{
	String P_N;
	String query="select * from customer where CUSTOMERID = ?";
	Scanner sc=new Scanner(System.in);
	System.out.println("ENTER THE CUSTOMERID OF THE CUSTOMER :");
	P_N=sc.next();
	String url="jdbc:mysql://localhost:3306/miniproject";
	String uname="root";
	String pass="rmpcrmpc";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Connection con =DriverManager.getConnection(url,uname,pass);
	PreparedStatement pst=con.prepareStatement(query);
	pst.setString(1, P_N);
	ResultSet rs=pst.executeQuery();
	if(rs.next())
	{
	       System.out.println("********************************************* ");
    	   System.out.println("--------------------------------------------- ");
    	   System.out.println("CUSTOMERID     :"+rs.getString(1));
    	   System.out.println("CUSTOMERNAME   :"+rs.getString(2));
    	   System.out.println("TOTALUNITS     :"+rs.getString(3));   	  
    	   System.out.println("TYPE           :"+rs.getString(4));
    	   System.out.println("TOTALAMOUNT    :"+rs.getString(5)+"RS-/-");
    	   System.out.println("PAYMENT_STATUS :"+rs.getString(6));
    	   System.out.println("--------------------------------------------- ");
           System.out.println("********************************************* ");
           System.out.println(" ");
 	       System.out.println("DO YOU WANT TO SEARCH MORE ");
	       System.out.println("PRESS 1 TO COUNTINUE AND 0 EXIT:");
 	   int loop_control=sc.nextInt();
 	    if(loop_control==0)
 	    {
 		  break;
     	}
	}
	else
	{
		System.out.println("THERE IS NO CUSTOMER WITH THAT CUSTOMERID!");
		System.out.println("GOING BACK TO OPTION PAGE.....");	
		break;
	}
 	pst.close();
    con.close();
	}
}
}
class Customer
{
	
///////////////////////////////////////////////////////////////////////////////////////
	void create_id()throws SQLException
	{
		String p_n,Name,password;
		Boolean loop=true;
		while (loop)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("ENTER YOUR CUSTOMERID:");
			p_n=sc.next();
			String url="jdbc:mysql://localhost:3306/miniproject";
			String uname="root";
			String pass="rmpcrmpc";
			String query="select * from login_details where CUSTOMERID=?";
	        String query2="insert into login_details(CUSTOMERID,LOGINPASSWORD) values(?,?)";
			String query3="insert into customer(CUSTOMERID,CUSTOMERNAME) values(?,?)";
			
	        try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        Connection con= DriverManager.getConnection(url,uname,pass);
		    PreparedStatement pst=con.prepareStatement(query);
		    pst.setString(1, p_n);
		    ResultSet rs=pst.executeQuery();
		    if(rs.next())
		    {
		    	System.out.println("CUSTOMER ID ALREADY EXISTS!");
		    	System.out.println("PLEASE TRY CREATING ACCOUNT WITH A NEW ID NO");
		    	System.out.println("GOING BACK!");
		    	pst.close();
		    	con.close();
		    	
		    	break;
		    	
		    }
		    else
		    {
		    	try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    	System.out.println("ENTER YOUR NAME:");
		    	Name=sc.next();
		    	System.out.println("ENTER YOUR LOGIN PASSWORD:");
		    	password=sc.next();
		    	Connection con2= DriverManager.getConnection(url,uname,pass);
		        PreparedStatement pst2=con2.prepareStatement(query2);
		    	pst2.setString(1, p_n);
		    	pst2.setString(2, password);
		    	pst2.execute();
		    	PreparedStatement pst3=con2.prepareStatement(query3);
		    	pst3.setString(1,p_n);
		    	pst3.setString(2,Name);
		    	pst3.execute();
		    	
		    	System.out.println("Account Created");
	            System.out.println("Enter 1 to go back:");
		    	int y=sc.nextInt();
	            pst2.close();
		    	pst3.close();
		    	con2.close();
		    	break;
		    }
		    
		}
		
	}
	void cret_id()throws SQLException
	{
		String p_n,Name,password;
		Boolean loop=true;
		while (loop)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("ENTER YOUR CUSTOMERID:");
			p_n=sc.next();
			String url="jdbc:mysql://localhost:3306/miniproject";
			String uname="root";
			String pass="rmpcrmpc";
			String query="select * from login_details where CUSTOMERID=?";
	        String query2="insert into login_details(CUSTOMERID,LOGINPASSWORD) values(?,?)";
			
			String query3="insert into registeration(CUSTOMERID,CUSTOMERNAME) values(?,?)";
	        try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        Connection con= DriverManager.getConnection(url,uname,pass);
		    PreparedStatement pst=con.prepareStatement(query);
		    pst.setString(1, p_n);
		    ResultSet rs=pst.executeQuery();
		    if(rs.next())
		    {
		    	System.out.println("CUSTOMER ID ALREADY EXISTS!");
		    	System.out.println("PLEASE TRY CREATING ACCOUNT WITH A NEW ID NO");
		    	System.out.println("GOING BACK!");
		    	pst.close();
		    	con.close();
		    	
		    	break;
		    	
		    }
		    else
		    {
		    	try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    	System.out.println("ENTER YOUR NAME:");
		    	Name=sc.next();
		    	System.out.println("ENTER YOUR LOGIN PASSWORD:");
		    	password=sc.next();
		    	Connection con2= DriverManager.getConnection(url,uname,pass);
		        PreparedStatement pst2=con2.prepareStatement(query2);
		    	pst2.setString(1, p_n);
		    	pst2.setString(2, password);
		    	pst2.execute();
		    	PreparedStatement pst3=con2.prepareStatement(query3);
		    	pst3.setString(1,p_n);
		    	pst3.setString(2,Name);
		    	pst3.execute();
		    	
		    	System.out.println("Account Created");
	            System.out.println("Enter 1 to go back:");
		    	int y=sc.nextInt();
	            pst2.close();
		    	pst3.close();
		    	con2.close();
		    	break;
		    }
		    
		}
		
	}
///////////////////////////////////////////////////////////////////////////////////////
	
	void cust_login() throws SQLException
	{
		int qs;
		String p_n;
		String pass_word;
		Boolean loop_control=true;
		String url="jdbc:mysql://localhost:3306/miniproject";
		String uname="root";
		String pass="rmpcrmpc";
		String query="select CUSTOMERID,LOGINPASSWORD from login_details where CUSTOMERID=? AND LOGINPASSWORD=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the CustomerId:");
		p_n=sc.next();
		System.out.println("Enter the password :");
		pass_word=sc.next();
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        Connection con= DriverManager.getConnection(url,uname,pass);
		    PreparedStatement pst=con.prepareStatement(query);
		    pst.setString(1, p_n);
		    pst.setString(2,pass_word);
		    ResultSet rs=pst.executeQuery();
		    Boolean b=true;
		     if(rs.next())
		    {
		    	while(b==true)
		    	{
		   
		    	  System.out.println("******LOGIN SUCCESSFUL******");
		    	  System.out.println("------OPTIONS-------");
		    	  System.out.println("1.ELECTRICITY BILLING PLATFORM  ");
		    	  System.out.println("2.SET CAPTCHA");
		    	  System.out.println("3.E-METER REGISTERATION");
		    	  System.out.println("4.BILL");
		    	  System.out.println("5.E-METER NEW CONNECTION FORM");
		    	  System.out.println("6.EXIT");
		    	 

		    	  System.out.println("ENTER YOUR CHOICE:");
		    	  int choice=sc.nextInt();
		    	 if(choice<=6&&choice>=1)
		    	 { 
		    	  switch (choice) 
		    	  {
				    case 1:
				    {
				    	electric(p_n);
				    	break;
				    }
				    case 2:
				    {
				    captcha(p_n);
				    	break;
				    } 
				    case 3:
				    {
				    	regest(p_n);
				    	break;
				    }
				    case 4:
				    {
				    	bill(p_n);
				    	break;
				    }
				    case 5:
				    {
				    	meter(p_n);
				    	break;
				    }
				    
				    case 6:
				    {
				    	 System.out.println("Going back!!!");
			    		 try {
							Thread.sleep(1500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    		 b=false;
			    		 break;
				    }
		    	  }
				}
		    	 else
		    	 {
		    		 System.out.println("please enter a valid input!");
		    	 }
		      }
		    }
		     else
		     {
		    	 System.out.println("LOGIN UNSUCCESSFUL");
		    	 System.out.println("<<<<<CUSTOMER ID OR PASSWORD IS WRONG>>>>");

	 	            
		    	 System.out.println("GOING BACK TO MENU");
		     }	
	}
///////////////////////////////////////////////////////////////////////////////////////
	 void electric(String x) throws SQLException 
	 	{
		    Scanner sc=new Scanner(System.in);
	 		String cust_id=x;
	 		
	 		
	 		System.out.println("********SELECT TYPE OF ELECTRICITY BOARD******************");
	 		System.out.println("1.COMMERCIAL");
	 		System.out.println("2.SEMI COMMERCIAL");
	 		System.out.println("3.DOMESTIC");
	 		System.out.println("ENTER YOUR CHOICE:");
	 		int ch=sc.nextInt();
	 		switch (ch)
	 		{
	 		    case 1:
	 		   {
	 			   String t="COMMERCIAL";
	 			   Scanner in = new Scanner(System.in);
	 			   Scanner ins = new Scanner(System.in);
	 			   double current,previous,tbill,units;
	 			   System.out.print ("\n\t Enter previous month reading  ");
	 			   previous= in.nextDouble();
	 			   System.out.print ("\n\t Enter current month reading  ");
	 			   current= in.nextDouble();
	 			   units=current-previous;
	 			   if (units<=100)
	 				 tbill= 2 * units;
	 				 else if(units>100 && units<=200)
	 				 tbill=4.50*units;
	 				 else if(units>200 && units<=500)
	 				 tbill= 6*units;
	 				 else
	 				 tbill= 7*units;
	 			     electric_set( t,units,cust_id,tbill);
	 			   break;
	 		   }
	 		    case 2:
	 		    {
	 		    	String t="SEMI COMMERCIAL";
	 		     	Scanner in = new Scanner(System.in);
		 			   Scanner ins = new Scanner(System.in);
		 			   double current,previous,tbill,units;
		 			   System.out.print ("\n\t Enter previous month reading  ");
		 			   previous= in.nextDouble();
		 			   System.out.print ("\n\t Enter current month reading  ");
		 			   current= in.nextDouble();
		 			   units=current-previous;
	 		     	if (units<=100)
		 				 tbill= 1.5 * units;
		 				 else if(units>100 && units<=200)
		 				 tbill=3*units;
		 				 else if(units>200 && units<=500)
		 				 tbill= 4.5*units;
		 				 else
		 				 tbill= 5.5*units;
	 		    	 electric_set( t,units,cust_id,tbill);
	 		    	break;
	 		    }
	 		    case 3:
	 		    {
	 		    	String t="DOMESTIC";
	 		    	Scanner in = new Scanner(System.in);
		 			   Scanner ins = new Scanner(System.in);
		 			   double current,previous,tbill,units;
		 			   System.out.print ("\n\t Enter previous month reading  ");
		 			   previous= in.nextDouble();
		 			   System.out.print ("\n\t Enter current month reading  ");
		 			   current= in.nextDouble();
		 			   units=current-previous;
	 		    	if (units<=100)
	 		    		tbill=1 * units;
	 		    		else if (units>100 && units<=200)
	 		    		tbill=2.50*units;
	 		    		else if(units>200 && units<=500)
	 		    		tbill= 4*units;
	 		    		else
	 		    		tbill= 6*units;
	 		    	 electric_set(t,units,cust_id,tbill);
	 		    	break;
	 		    }
	 		    
	 		    
	 	
	 		    default:
	 		    {
	 		    	System.out.println("PLEASE ENTER A VALID INPUT");
                 	System.out.println("GOING BACK TO OPTION MENU");
	 		    	
	 		    }
	 	} 		    
	 		

}
///////////////////////////////////////////////////////////////////////////////////////
	
	 void electric_set(String t,double U, String p_n, double T)throws SQLException
	 {
		 String type=t;
		 double units=U;
		 double tbill=T;
		 String cust_id=p_n;
		 String url="jdbc:mysql://localhost:3306/miniproject";
		 String uname="root";
		 String pass="rmpcrmpc";
		 String query="select CAPTCHA from login_details where CAPTCHA=? AND CUSTOMERID=?";
		 String query1="select CAPTCHA from login_details where CUSTOMERID=? AND CAPTCHA IS NOT NULL";
		 String query2="update customer set TYPE=?,UNITS=?,TOTALBILL=?,PAYMENTSTATUS=? where CUSTOMERID=?";
	     try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     Connection con= DriverManager.getConnection(url,uname,pass);
	     PreparedStatement pst1=con.prepareStatement(query1);
	     pst1.setString(1,cust_id);
	     ResultSet rs=pst1.executeQuery();
	     Scanner sc=new Scanner(System.in);
	     
	     if(rs.next())
	     {   
	    	 
	    	 System.out.println("TYPE:"+type);
	    	 System.out.println("UNITS:"+units);
	    	 System.out.println("TOTALAMOUNT:"+tbill);
	    	 System.out.println("1.PAYTM");
	    	 System.out.println("2.PHONEPE");
	    	 System.out.println("3.GPAY");
	    	 System.out.println("4.NET-BANKING");
	    	 System.out.println("ENTER YOUR PREFERED METHOD OF PAYMENT:");
	    	 int ch=sc.nextInt();
	    	 String pay;
	    	 if(ch<=4&&ch>0)
	    	 {
	    		 System.out.println("ENTER YOUR CAPTCHA:");
    		     pay=sc.next();
	    	     PreparedStatement pst=con.prepareStatement(query);
	             pst.setString(1,pay);
	             pst.setString(2,cust_id);
	             ResultSet rsc=pst.executeQuery();
	    	  if(rsc.next())
	    	  { 
	    		 
	    	      	PreparedStatement pst2=con.prepareStatement(query2);
	    	      	pst2.setString(1,type);
	    	      	pst2.setDouble(2,units);
	    	      	pst2.setDouble(3,tbill);
	    	      	pst2.setString(4,"PAID");
	    	      	pst2.setString(5,cust_id);
	    	      	pst2.executeUpdate();
	    	      	pst2.close();
	    	      
	    	
	    	      	System.out.println("TRANSCATION SUCCESSFUL");
	    	      	
	    	    	
	    	      	System.out.println("you have successfully completed the transaction!");
	    	    	
	    	      	System.out.println("GOING BACK!!!!!!");
	    	    	 
	    	      	
	    	      
	    	 }
	          else
	           {
	        	   System.out.println("YOU HAVE ENTERED WRONG CAPTCHA");
	 
	 	            
	        	    System.out.println("ENTER 1 GO BACK: ");
	        	    int shs=sc.nextInt();
	           }
	    	}
	    	 else
	    	 {
	    		 System.out.println("INVALID INPUT");
	    	 }
	     }
	     else
	     {
	    	   System.out.println("please set your captcha");
	    	    System.out.println("GOING BACK!!!!!!");
	    		     }
	     		 
	 }
	 
	 void captcha(String custid)throws SQLException
	 {
		 String p_n=custid;
		 Scanner sc=new Scanner(System.in);
		 String url="jdbc:mysql://localhost:3306/miniproject";
		 String uname="root";
		 String pass="rmpcrmpc";
		 String querry1="select CAPTCHA from login_details where CUSTOMERID=? AND CAPTCHA IS NOT NULL";
		 String querry2="update login_details set CAPTCHA=? where CUSTOMERID=?";
	     try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     Connection con= DriverManager.getConnection(url,uname,pass);
	     PreparedStatement pst=con.prepareStatement(querry1);
	     pst.setString(1,p_n); 
	     ResultSet rs=pst.executeQuery();
	     if(rs.next())
	     {
	    	 System.out.println("ENTER THE generated CAPTCHA:");
			 String pay_password=sc.next();
	    	 PreparedStatement pst2=con.prepareStatement(querry2);
	    	 pst2.setString(1, pay_password);
	    	 pst2.setString(2,p_n);
	    	 pst2.executeUpdate();
	    	    System.out.println("YOUR CAPTCHA is SUCCESFULLY CHANGED");

	            System.out.println("ENTER 1 TO GO BACK:");
	    	 int sdse=sc.nextInt();
	    	 pst2.close();
	     }
	     else
	     {
	    	 System.out.println("ENTER THE GENERATED CAPTCHA :");
			 String pay_password=sc.next();
			 PreparedStatement pst2=con.prepareStatement(querry2);
			 pst2.setString(1, pay_password);
	    	 pst2.setString(2,p_n);
	    	 pst2.executeUpdate();
	    	 System.out.println("YOU HAVE SUCCESSFULLY GENERATED CAPTCHA");
	    	 
	          System.out.println("ENTER 1 TO GO BACK");
			 pst2.close();
	     }
	     pst.close();
	     con.close();
	 }//end of payment password method
///////////////////////////////////////////////////////////////////////////////////////
	 



            void regest(String j) throws SQLException 
            {
{				Scanner sc=new Scanner(System.in);
            	String cust_id=j;


    	 		String father,mother,occ,adr,adhr,pan,id,dob,state,district,taluk,village,pro;
    	 		int sur,his;

    	 		System.out.println("STATE");
    	 		System.out.println("1.KARNATAKA");
    	 	
                System.out.println("ENTER YOUR CHOICE:");
    	 			 		int ch=sc.nextInt();
    	 			 		switch (ch)
    	 			 		{
    	 		                       case 1: {
    	 		                               state="KARNATAKA";
    	 		                             
    	 		                               System.out.println("Select DISTRICT in karnataka");
    	 		                               System.out.println("1.BANGALORE");
    	 		                               System.out.println("2.MANGALORE");
    	 		                               System.out.println("3.KOLAR");

    	 		                               System.out.println("ENTER YOUR CHOICE:");
    	 			 		             int eh=sc.nextInt();
    	 			 		             switch (eh)
    	 			 		             {
    	 		                                     case 1: {
    	 		                                            district="BANGALORE"; 
    	 		                                           
    	 		                                             System.out.println("Select TALUK in bangalore");
    	 		                                             System.out.println("1.BANGALORE EAST");
    	 		                                             System.out.println("2.BANGALORE NORTH");
    	 		                                             System.out.println("3.BANGALORE WEST");
    	 		                                             System.out.println("4.BANGALORE SOUTH");
    	 		                                             System.out.println("ENTER YOUR CHOICE:");
    	 			 		                           int uh=sc.nextInt();
    	 			 		                           switch (uh)
    	 		                                             {
    	 		                                     case 1:{
    	 		                                             taluk="BANGALORE EAST";
    	 		                                           
    	 		                                             System.out.println("Select VILLAGE in bangaloreeast");
    	 		                                             System.out.println("1.BANASAVADI");
    	 		                                             System.out.println("2.BASAVANAPURA");
    	 		                                             System.out.println("3.DEVASANDRA");
    	 		                                             System.out.println("4.KRISHNARAJAPURA");
    	 		                                             System.out.println("ENTER YOUR CHOICE:");
    	 			 		                           int h=sc.nextInt();
    	 			 		                           switch (h)
    	 		                                             {
    	 		                                      case 1: {
    	 		                                    	 state="KARNATAKA"; 
    	 		                                    	 district="BANGALORE"; 
    	 		                                              village="BANASAVADI";
    	 		                                             taluk="BANGALORE EAST";
    	 		                                             System.out.println("BANASAVADI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                  his=sc.nextInt();
    	 		                                            regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                      case 2: { state="KARNATAKA"; 
    	 		                                     district="BANGALORE"; 
    	 		                                    taluk="BANGALORE EAST";
    	 		                                    	  village="BASAVANAPURA";
      	 		                                    	  System.out.println("BASAVANAPURA");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                               
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                       case 3: {state="KARNATAKA"; 
    	 		                                    	   village="DEVASANDRA";
    	 		                                    	  district="BANGALORE"; 
    	 		                                    	 taluk="BANGALORE EAST";
    	 		                                    	   System.out.println("DEVASANDRA");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;} 
    	 		                                        case 4: {state="KARNATAKA"; 
    	 		                                        	village="KRISHNARAJAPURA";
    	 		                                        	 district="BANGALORE"; 
    	 		                                        	taluk="BANGALORE EAST";
    	 		                                        	System.out.println("KRISHNARAJAPURA");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                        default:
    	 			 		                              {
    	 			 		    	                          System.out.println("PLEASE ENTER A VALID INPUT");
    	 		                                                System.out.println("GOING BACK TO OPTION MENU");
    	 			 		    	
    	 			 		                               }
    	 		                                              }break;}
    	 		                                    case 2:
    	 		                                           {
    	 		                                        	  taluk="BANGALORE NORTH";
    	 		                                        	 
    	 		                                             System.out.println("BANGALORE NORTH");
    	 		                                             System.out.println("Select VILLAGE in bangalorenorth");
    	 		                                             System.out.println("1.JALAHAALI");
    	 		                                             System.out.println("2.LAGGERE");
    	 		                                             System.out.println("3.ABBAGERE");
    	 		                                             System.out.println("4.BAGALAGUNTE");
    	 		                                             System.out.println("ENTER YOUR CHOICE:");
    	 			 		                           int g=sc.nextInt();
    	 			 		                           switch (g)
    	 		                                             {
    	 		                                      case 1: {state="KARNATAKA"; 
    	 		                                     taluk="BANGALORE NORTH";
    	 		                                     district="BANGALORE"; 
    	 		                                    	 village="JALAHAALI";
    	 		                                    	  System.out.println("JALAHAALI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                      case 2:  {state="KARNATAKA"; 
    	 		                                     taluk="BANGALORE NORTH";
    	 		                                     district="BANGALORE"; 
    	 		                                    	 village="LAGGERE";
    	 		                                    	  System.out.println("LAGGERE");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                       case 3: {state="KARNATAKA"; 
    	 		                                      taluk="BANGALORE NORTH";
    	 		                                      district="BANGALORE"; 
    	 		                                    	  village="ABBAGERE";
    	 		                                    	   System.out.println("ABBAGERE");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break; }
    	 		                                        case 4:{
    	 		                                        	state="KARNATAKA"; 
    	 		                                        	 district="BANGALORE"; 
    	 		                                        	taluk="BANGALORE NORTH";
    	 		                                        	village="BAGALAGUNTE";
    	 		                                        	System.out.println("BAGALAGUNTE");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                        default:
    	 			 		                              {
    	 			 		    	                          System.out.println("PLEASE ENTER A VALID INPUT");
    	 		                                                System.out.println("GOING BACK TO OPTION MENU");
    	 			 		    	
    	 			 		                               }
    	 		                                              } break;  }
    	 		                                    case 3:{
    	 		                                    	taluk="BANGALORE WEST";
    	 		                                    	 
    	 		                                           System.out.println("BANGALORE WEST");
    	 		                                             System.out.println("Select VILLAGE in bangalorewest");
    	 		                                             System.out.println("1.BALAHALLI");
    	 		                                             System.out.println("2.BANAHALLI");
    	 		                                             System.out.println("3.BILLAPURA");
    	 		                                             System.out.println("4.KUGURU");
    	 		                                             System.out.println("ENTER YOUR CHOICE:");
    	 			 		                           int l=sc.nextInt();
    	 			 		                           switch (l)
    	 		                                             {
    	 		                                      case 1: {state="KARNATAKA"; 
    	 		                                     taluk="BANGALORE WEST";
    	 		                                     district="BANGALORE"; 
    	 		                                    	 village="BALAHALLI";
    	 		                                    	  System.out.println("BALAHALLI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                      case 2: { state="KARNATAKA"; 
    	 		                                     taluk="BANGALORE WEST"; 
    	 		                                     district="BANGALORE"; 
    	 		                                    	 village="BANAHALLI";
    	 		                                    	  System.out.println("BANAHALLI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                       case 3: {state="KARNATAKA"; 
    	 		                                      taluk="BANGALORE WEST";
    	 		                                      district="BANGALORE"; 
    	 		                                    	  village="BILLAPURA";
    	 		                                    	   System.out.println("BILLAPURA");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	                                                        break 	;} 
    	 		                                        case 4: {state="KARNATAKA"; 
    	 		                                       taluk="BANGALORE WEST";
    	 		                                       district="BANGALORE"; 
    	 		                                        	village="KUGURU";
    	 		                                        	System.out.println("KUGURU");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                        default:
    	 			 		                              {
    	 			 		    	                          System.out.println("PLEASE ENTER A VALID INPUT");
    	 		                                                System.out.println("GOING BACK TO OPTION MENU");
    	 			 		    	
    	 			 		                               }
    	 		                                              }break; }  
    	 		                                   case 4:{
    	 		                                	  taluk="BANGALORE SOUTH";
    	 		                                	
    	 		                                          System.out.println("BANGALORE SOUTH");
    	 		                                             System.out.println("Select VILLAGE in bangaloresouth");
    	 		                                             System.out.println("1.KENGERI");
    	 		                                             System.out.println("2.RAMASANDRA");
    	 		                                             System.out.println("3.NAGADEVANAHALLI");
    	 		                                             System.out.println("4.KOMMAGHATTA");
    	 		                                             System.out.println("ENTER YOUR CHOICE:");
    	 			 		                           int y=sc.nextInt();
    	 			 		                           switch (y)
    	 		                                             {
    	 		                                      case 1: {state="KARNATAKA"; 
    	 		                                     district="BANGALORE"; 
    	 		                                    	 taluk="BANGALORE SOUTH";
    	 		                                    	 village="KENGERI";
    	 		                                    	  System.out.println("KENGERI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                      case 2:  {state="KARNATAKA"; 
    	 		                                     district="BANGALORE"; 
    	 		                                    	 taluk="BANGALORE SOUTH";
    	 		                                    	 village="RAMASANDRA";
    	 		                                    	  System.out.println("RAMASANDRA");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                       case 3: {state="KARNATAKA"; 
    	 		                                      district="BANGALORE"; 
    	 		                                    	  taluk="BANGALORE SOUTH";
    	 		                                    	  village="NAGADEVANAHALLI";
    	 		                                    	   System.out.println("NAGADEVANAHALLI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break; }
    	 		                                        case 4: {state="KARNATAKA"; 
    	 		                                       district="BANGALORE"; 
    	 		                                        	taluk="BANGALORE SOUTH";
    	 		                                        	village="KOMMAGHATTA";
    	 		                                        	System.out.println("KOMMAGHATTA");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                        default:
    	 			 		                              {
    	 			 		    	                          System.out.println("PLEASE ENTER A VALID INPUT");
    	 		                                                System.out.println("GOING BACK TO OPTION MENU");
    	 			 		    	
    	 			 		                               }
    	 		                                              }break; }
    	 		                                  default:
 			 		                              {
 			 		    	                          System.out.println("PLEASE ENTER A VALID INPUT");
 		                                                System.out.println("GOING BACK TO OPTION MENU");
 			 		    	
 			 		                               }
    	 		                                   }break;}
    	 		                              case 2:{
    	 		                            	 district="MANGALORE";
    	 		                            	
    	 		                                            System.out.println("MANGALORE");
    	 		                                             System.out.println("Select TALUK in mangalore");
    	 		                                             System.out.println("1.KADUR");
    	 		                                             System.out.println("2.KOPPA");
    	 		                                             System.out.println("3.MUDIGERE");
    	 		                                             System.out.println("4.SRINGERI");
    	 		                                             System.out.println("ENTER YOUR CHOICE:");
    	 			 		                           int a=sc.nextInt();
    	 			 		                           switch (a)
    	 		                                             {
    	 		                                     case 1:{
    	 		                                    	taluk="KADUR";
    	 		                                    	 
    	 		                                             System.out.println("KADUR");
    	 		                                             System.out.println("Select VILLAGE in kadur");
    	 		                                             System.out.println("1.PATTANAGERE");
    	 		                                             System.out.println("2.RAMANAHALLI");
    	 		                                             System.out.println("3.MALLESHVARA");
    	 		                                             System.out.println("4.MACHCHERI");
    	 		                                             System.out.println("ENTER YOUR CHOICE:");
    	 			 		                           int u=sc.nextInt();
    	 			 		                           switch (u)
    	 		                                             {
    	 		                                      case 1: {
    	 		                                    	 state="KARNATAKA"; 
    	 		                                    	 district="MANGALORE";
    	 		                                    	 taluk="KADUR";
    	 		                                    	 village="PATTANAGERE";
    	 		                                    	  System.out.println("PATTANAGERE");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                              break; 
    	 		                                              }
    	 		                                      case 2:  {
    	 		                                    	 state="KARNATAKA"; 
    	 		                                    	 district="MANGALORE";
    	 		                                    	 taluk="KADUR";
    	 		                                    	 village="RAMANAHALLI";
    	 		                                    	  System.out.println("RAMANAHALLI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                       case 3: {
    	 		                                    	  state="KARNATAKA"; 
    	 		                                    	  district="MANGALORE";
    	 		                                    	  taluk="KADUR";
    	 		                                    	  village="MALLESHVARA";
    	 		                                    	   System.out.println("MALLESHVARA");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                        case 4: {
    	 		                                        	state="KARNATAKA"; 
    	 		                                        	district="MANGALORE";
    	 		                                        	taluk="KADUR";
    	 		                                        	village="MACHCHERI";
    	 		                                        	System.out.println("MACHCHERI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                                break;}
    	 		                                        default:
    	 			 		                              {
    	 			 		    	                          System.out.println("PLEASE ENTER A VALID INPUT");
    	 		                                                System.out.println("GOING BACK TO OPTION MENU");
    	 			 		    	
    	 			 		                               }
    	 		                                              }break;}
    	 		                                    case 2:{
    	 		                                    	
    	 		                                    
    	 		                                    	taluk="KOPPA";
    	 		                                    	 
    	 		                                      System.out.println("KOPPA");
    	 		                                             System.out.println("Select VILLAGE in koppa");
    	 		                                             System.out.println("1.KAGGA");
    	 		                                             System.out.println("2.NUGGI");
    	 		                                             System.out.println("3.TANUDI");
    	 		                                             System.out.println("4.UDANA");
    	 		                                             System.out.println("ENTER YOUR CHOICE:");
    	 			 		                           int n=sc.nextInt();
    	 			 		                           switch (n)
    	 		                                             {
    	 		                                      case 1:{ 
    	 		                                    	 state="KARNATAKA"; 
    	 		                                    	 district="MANGALORE";
    	 		                                    	 taluk="KOPPA";
    	 		                                    	 village="KAGGA";
    	 		                                    	  System.out.println("KAGGA");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                      case 2:  {
    	 		                                    	 state="KARNATAKA"; 
    	 		                                    	 district="MANGALORE";
    	 		                                    	 taluk="KOPPA";
    	 		                                    	 village="NUGGI";
    	 		                                    	  System.out.println("NUGGI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                       case 3: {
    	 		                                    	  state="KARNATAKA"; 
    	 		                                    	  district="MANGALORE";
    	 		                                    	  taluk="KOPPA";
    	 		                                    	  village="TANUDI";
    	 		                                    	   System.out.println("TANUDI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                              break;}
    	 		                                        case 4:{ 
    	 		                                        	state="KARNATAKA"; 
    	 		                                        	district="MANGALORE";
    	 		                                        	taluk="KOPPA";
    	 		                                        	village="UDANA";
    	 		                                        	System.out.println("UDANA");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;} 
    	 		                                        default:
    	 			 		                              {
    	 			 		    	                          System.out.println("PLEASE ENTER A VALID INPUT");
    	 		                                                System.out.println("GOING BACK TO OPTION MENU");
    	 			 		    	
    	 			 		                               }
    	 		                                             }break;}  
    	 		                                    case 3:{
    	 		                                    	taluk="MUDIGERE";
    	 		                                    	
    	 		                                           System.out.println("MUDIGERE");
    	 		                                             System.out.println("Select VILLAGE in mudigere");
    	 		                                             System.out.println("1.TATKOLA");
    	 		                                             System.out.println("2.MALAHALLI");
    	 		                                             System.out.println("3.LOKAVALLI");
    	 		                                             System.out.println("4.MUDIGERE");
    	 		                                             System.out.println("ENTER YOUR CHOICE:");
    	 			 		                           int m=sc.nextInt();
    	 			 		                           switch (m)
    	 		                                             {
    	 		                                      case 1: {
    	 		                                    	 state="KARNATAKA"; 
    	 		                                    	 district="MANGALORE";
    	 		                                    	 taluk="MUDIGERE";
    	 		                                    	 village="TATKOLA";
    	 		                                    	  System.out.println("TATKOLA");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                      case 2:  {
    	 		                                    	 state="KARNATAKA";  
    	 		                                    	 district="MANGALORE";
    	 		                                    	 taluk="MUDIGERE";
    	 		                                    	 village="MALAHALLI";
    	 		                                    	  System.out.println("MALAHALLI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                       case 3: {
    	 		                                    	  state="KARNATAKA"; 
    	 		                                    	  district="MANGALORE";
    	 		                                    	  taluk="MUDIGERE";
    	 		                                    	  village="LOKAVALLI";
    	 		                                    	   System.out.println("LOKAVALLI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break; }
    	 		                                        case 4: {
    	 		                                        	state="KARNATAKA"; 
    	 		                                        	district="MANGALORE";
    	 		                                        	taluk="MUDIGERE";
    	 		                                        	village="MUDIGERE";
    	 		                                        	System.out.println("MUDIGERE");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                        default:
    	 			 		                              {
    	 			 		    	                          System.out.println("PLEASE ENTER A VALID INPUT");
    	 		                                                System.out.println("GOING BACK TO OPTION MENU");
    	 			 		    	
    	 			 		                               }
    	 		                                              }break;  } 
    	 		                                   case 4:{
    	 		                                	  taluk="SRINGERI";
    	 		                                	 
    	 		                                            System.out.println("SRINGERI");
    	 		                                             System.out.println("Select VILLAGE in sringeri");
    	 		                                             System.out.println("1.KAVADI");
    	 		                                             System.out.println("2.KIKKARE");
    	 		                                             System.out.println("3.MASIGE");
    	 		                                             System.out.println("4.SHRUNGERI");
    	 		                                             System.out.println("ENTER YOUR CHOICE:");
    	 			 		                           int z=sc.nextInt();
    	 			 		                           switch (z)
    	 		                                             {
    	 		                                      case 1: {
    	 		                                    	 state="KARNATAKA"; 
    	 		                                    	 district="MANGALORE";
    	 		                                    	 taluk="SRINGERI";
    	 		                                    	 village="KAVADI";
    	 		                                    	  System.out.println("KAVADI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                      case 2: {
    	 		                                    	 state="KARNATAKA"; 
    	 		                                    	 district="MANGALORE";
    	 		                                    	 taluk="SRINGERI";
    	 		                                    	 village="KIKKARE";
    	 		                                    	  System.out.println("KIKKARE");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                       case 3: {
    	 		                                    	  state="KARNATAKA"; 
    	 		                                    	  district="MANGALORE";
    	 		                                    	  taluk="SRINGERI";
    	 		                                    	  village="MASIGE";
    	 		                                    	   System.out.println("MASIGE");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break; }
    	 		                                        case 4:{
    	 		                                        	state="KARNATAKA"; 
    	 		                                        	district="MANGALORE";
    	 		                                        	taluk="SRINGERI";
    	 		                                        	village="SHRUNGERI";
    	 		                                        	System.out.println("SHRUNGERI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                        default:
    	 			 		                              {
    	 			 		    	                          System.out.println("PLEASE ENTER A VALID INPUT");
    	 		                                                System.out.println("GOING BACK TO OPTION MENU");
    	 			 		    	
    	 			 		                               }
    	 		                                              }break; }
    	 		                             default:
		 		                              {
		 		    	                          System.out.println("PLEASE ENTER A VALID INPUT");
	                                                System.out.println("GOING BACK TO OPTION MENU");
		 		    	
		 		                               }}break;}
    	 		                                 case 3:{ 
    	 		                                	district="KOLAR";
    	 		                                	
    	 		                                             System.out.println("KOLAR");
    	 		                                             System.out.println("Select TALUK in kolar");
    	 		                                             System.out.println("1.BANGARPET");
    	 		                                             System.out.println("2.KOLAR");
    	 		                                             System.out.println("3.MALUR");
    	 		                                             System.out.println("4.MULBAGAL");
    	 		                                             System.out.println("ENTER YOUR CHOICE:");
    	 			 		                           int k=sc.nextInt();
    	 			 		                           switch (k)
    	 		                                             {
    	 		                                     case 1:{
    	 		                                    	taluk="BANGARPET";
    	 		                                   
    	 		                                             System.out.println("BANGARPET");
    	 		                                             System.out.println("Select VILLAGE in bangarpet");
    	 		                                             System.out.println("1.DESHIHALLI");
    	 		                                             System.out.println("2.GUTTAHALLI");
    	 		                                             System.out.println("3.HAROHALLI");
    	 		                                             System.out.println("4.HOSAKOTE");
    	 		                                             System.out.println("ENTER YOUR CHOICE:");
    	 			 		                           int q=sc.nextInt();
    	 			 		                           switch (q)
    	 		                                             {
    	 		                                      case 1:{ 
    	 		                                    	 state="KARNATAKA";
    	 		                                    	 district="KOLAR";
    	 		                                    	 taluk="BANGARPET";
    	 		                                    	 village="DESHIHALLI";
    	 		                                    	  System.out.println("DESHIHALLI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                      case 2: {
    	 		                                    	 state="KARNATAKA";
    	 		                                    	 district="KOLAR";
    	 		                                    	 taluk="BANGARPET";
    	 		                                    	 village="GUTTAHALLI";
    	 		                                    	 System.out.println("GUTTAHALLI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                       case 3: {
    	 		                                    	  state="KARNATAKA"; 
    	 		                                    	  district="KOLAR";
    	 		                                    	  taluk="BANGARPET";
    	 		                                    	  village="HAROHALLI";
    	 		                                    	   System.out.println("HAROHALLI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break; }
    	 		                                        case 4:{
    	 		                                        	state="KARNATAKA";
    	 		                                        	district="KOLAR";
    	 		                                        	taluk="BANGARPET";
    	 		                                        	village="HOSAKOTE";
    	 		                                        	System.out.println("HOSAKOTE");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                        default:
    	 			 		                              {
    	 			 		    	                          System.out.println("PLEASE ENTER A VALID INPUT");
    	 		                                                System.out.println("GOING BACK TO OPTION MENU");
    	 			 		    	
    	 			 		                               }
    	 		                                              }break;
    	 		                                     }  case 2:{
    	 		                                    	taluk="KOLAR";
    	 		                                    
    	 		                                                System.out.println("KOLAR");
    	 		                                             System.out.println("Select VILLAGE in kolar");
    	 		                                             System.out.println("1.BEGLI");
    	 		                                             System.out.println("2.CHINNAPURA");
    	 		                                             System.out.println("3.EEKAMBALLI");
    	 		                                             System.out.println("4.ARAHALLI");
    	 		                                             System.out.println("ENTER YOUR CHOICE:");
    	 			 		                           int r=sc.nextInt();
    	 			 		                           switch (r)
    	 		                                             {
    	 		                                      case 1:{
    	 		                                    	 state="KARNATAKA";
    	 		                                    	 district="KOLAR";
    	 		                                    	 taluk="KOLAR";
    	 		                                    	 village="BEGLI";
    	 		                                    	  System.out.println("BEGLI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                      case 2:{
    	 		                                    	 state="KARNATAKA";
    	 		                                    	 district="KOLAR";
    	 		                                    	 taluk="KOLAR";
    	 		                                    	 village="CHINNAPURA";
    	 		                                    	 
    	 		                                    	  System.out.println("CHINNAPURA");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                                break;}
    	 		                                       case 3: {
    	 		                                    	  state="KARNATAKA";
    	 		                                    	  district="KOLAR";
    	 		                                    	  taluk="KOLAR";
    	 		                                    	  village="EEKAMBALLI";
    	 		                                    	   System.out.println("EEKAMBALLI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break; }
    	 		                                        case 4: {
    	 		                                        	state="KARNATAKA";
    	 		                                        	district="KOLAR";
    	 		                                        	taluk="KOLAR";
    	 		                                        	village="ARAHALLI";
    	 		                                        	System.out.println("ARAHALLI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                        default:
    	 			 		                              {
    	 			 		    	                          System.out.println("PLEASE ENTER A VALID INPUT");
    	 		                                                System.out.println("GOING BACK TO OPTION MENU");
    	 			 		    	
    	 			 		                               }}break;}
    	 		                                                
    	 		                                    case 3:{
    	 		                                    	taluk="KOLAR";
    	 		                                    	
    	 		                                             System.out.println("MALUR");
    	 		                                             System.out.println("Select VILLAGE in malur");
    	 		                                             System.out.println("1.ARALERI");
    	 		                                             System.out.println("2.BELLAVI");
    	 		                                             System.out.println("3.CHANNAKAL");
    	 		                                             System.out.println("4.DYAPASANDRA");
    	 		                                             System.out.println("ENTER YOUR CHOICE:");
    	 			 		                           int t=sc.nextInt();
    	 			 		                           switch (t)
    	 		                                             {
    	 		                                      case 1:{ 
    	 		                                    	 state="KARNATAKA";
    	 		                                    	 district="KOLAR";
    	 		                                    	 taluk="KOLAR";
    	 		                                    	 village="ARALERI";
    	 		                                    	  System.out.println("ARALERI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                      case 2:{ 
    	 		                                    	 state="KARNATAKA";
    	 		                                    	 district="KOLAR";
    	 		                                    	 taluk="KOLAR";
    	 		                                    	 village="BELLAVI";
    	 		                                    	  System.out.println("BELLAVI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                       case 3: {
    	 		                                    	  state="KARNATAKA";
    	 		                                    	  district="KOLAR";
    	 		                                    	  taluk="KOLAR";
    	 		                                    	  village="CHANNAKAL";
    	 		                                    	   System.out.println("CHANNAKAL");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break; }
    	 		                                        case 4: {
    	 		                                        	state="KARNATAKA";
    	 		                                        	district="KOLAR";
    	 		                                        	 taluk="KOLAR";
    	 		                                        	village="DYAPASANDRA";
    	 		                                        	System.out.println("DYAPASANDRA");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                        default:
    	 			 		                              {
    	 			 		    	                          System.out.println("PLEASE ENTER A VALID INPUT");
    	 		                                                System.out.println("GOING BACK TO OPTION MENU");
    	 			 		    	
    	 			 		                               }}break;}
    	 		                                               
    	 		                                   case 4:{
    	 		                                	  taluk="MULBAGAL";
    	 		                                	 
    	 		                                          System.out.println("MULBAGAL");
    	 		                                             System.out.println("Select VILLAGE in mulbagal");
    	 		                                             System.out.println("1.BHATRAHALLI");
    	 		                                             System.out.println("2.ANEHALLI");
    	 		                                             System.out.println("3.DARENAHALLI");
    	 		                                             System.out.println("4.HOSAHALLI");
    	 		                                             System.out.println("ENTER YOUR CHOICE:");
    	 			 		                           int w=sc.nextInt();
    	 			 		                           switch (w)
    	 		                                             {
    	 		                                      case 1:{ 
    	 		                                    	 state="KARNATAKA";
    	 		                                    	 district="KOLAR";
    	 		                                    	  taluk="MULBAGAL";
    	 		                                    	 village="BHATRAHALLI";
    	 		                                    	  System.out.println("BHATRAHALLI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                      case 2:  {
    	 		                                    	 state="KARNATAKA";
    	 		                                    	 district="KOLAR";
    	 		                                    	  taluk="MULBAGAL";
    	 		                                    	 village="ANEHALLI";
    	 		                                    	  System.out.println("ANEHALLI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                       case 3: {
    	 		                                    	  state="KARNATAKA";
    	 		                                    	  district="KOLAR";
    	 		                                    	  taluk="MULBAGAL";
    	 		                                    	  village="DARENAHALLI";
    	 		                                    	   System.out.println("DARENAHALLI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break; }
    	 		                                        case 4:{
    	 		                                        	state="KARNATAKA";
    	 		                                        	district="KOLAR";
    	 		                                        	  taluk="MULBAGAL";
    	 		                                        	village="HOSAHALLI";
    	 		                                        	System.out.println("HOSAHALLI");
    	 		                                              System.out.println("enter the survey no");   
    	 		                                               sur=sc.nextInt(); 
    	 		                                              System.out.println("enter the hissa no");         
    	 		                                                 his=sc.nextInt();
    	 		                                                regest_set(state,district,taluk,village,cust_id,sur,his);
    	 		                                               break;}
    	 		                                             
    	 		                                        default:
    	 			 		                              {
    	 			 		    	                          System.out.println("PLEASE ENTER A VALID INPUT");
    	 		                                               System.out.println("GOING BACK TO OPTION MENU");
    	 			 		    	
    	 			 		                              }}}
    	 		                                  default:
 			 		                              {
 			 		    	                          System.out.println("PLEASE ENTER A VALID INPUT");
 		                                               System.out.println("GOING BACK TO OPTION MENU");
 			 		    	
 			 		                              }}break;}
    	 		                                default:
			 		                              {
			 		    	                          System.out.println("PLEASE ENTER A VALID INPUT");
		                                               System.out.println("GOING BACK TO OPTION MENU");
			 		    	
			 		                              }}break;
			 		                             }
    	 		                      default:
	 		                              {
	 		    	                          System.out.println("PLEASE ENTER A VALID INPUT");
                                            System.out.println("GOING BACK TO OPTION MENU");
	 		    	
	 		                              }
	 		                              }
    	 			  	 			 		
}   	
    	 				    	      
    	 				    	 }
    	 		
        void  regest_set(String state,String district,String taluk,String village,String p_n,int sur,int his)throws SQLException
        {
        	String father,mother,adr,oc,adhr,pan,id,dob;
         String cust_id = p_n;
   		 String url="jdbc:mysql://localhost:3306/miniproject";
   		 String uname="root";
   		 String pass="rmpcrmpc";
   		 String query="select CAPTCHA from login_details where CAPTCHA=? AND CUSTOMERID=?";
   		 String query1="select CAPTCHA from login_details where CUSTOMERID=? AND CAPTCHA IS NOT NULL";
   		 String query2="update registeration set FATHERNAME=?,MOTHERNAME=?,DOB=?,ADDRESS=?,ADHARCARD=?,PANCARD=?,ELECTIONID=?,OCCUPATION=?,STATE=?,DISTRICT=?,TALUK=?,VILLAGE=?,SURVEYNO=?,HISSANO=?,APPROVED=? where CUSTOMERID=?";
   	     try {
   			Class.forName("com.mysql.cj.jdbc.Driver");
   		} catch (ClassNotFoundException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   	     Connection con= DriverManager.getConnection(url,uname,pass);
   	     PreparedStatement pst1=con.prepareStatement(query1);
   	     pst1.setString(1,cust_id);
   	     ResultSet rs=pst1.executeQuery();
   	     Scanner sc=new Scanner(System.in);
   	     
   	     if(rs.next())
   	     {   

 	 		System.out.print("enter your father name:");
 	 		father=sc.nextLine();
 	 		System.out.print("enter your mother name:");
 	 		mother=sc.nextLine();
 	 		System.out.print("enter your address:");
 	 		adr=sc.nextLine();
 	 		System.out.print("enter your date of birth:");
 	 		dob=sc.nextLine();
 	 		System.out.print("enter your adhaar no:");
 	 		adhr=sc.nextLine();
 	 		System.out.print("enter your pan no:");
 	 		pan=sc.next();
 	 		System.out.print("enter your election id:");
 	 		id=sc.next();
 	 		System.out.print("enter your occupation:");
 	 		oc=sc.next();
 	 		
 	 		
	     	System.out.println("FATHERNAME:"+father);
   	    	 System.out.println("MOTHERNAME:"+mother);
   	    	 System.out.println("ADDRESS:"+adr);
   	    	 System.out.println("DOB:"+dob);
   	    	 System.out.println("ADHAAR NO:"+adhr);
   	    	 System.out.println("PAN NO:"+pan);
   	    	 System.out.println("ELECTION ID:"+id);
   	    	 System.out.println("OCCUPATION:"+oc);
   	    	System.out.println("STATE:"+state);
   	    	System.out.println("DISTRICT:"+district);
   	    	System.out.println("TALUK:"+taluk);
   	    	System.out.println("VILLAGE:"+village);
   	    	System.out.println("SURVEY NO:"+sur);
   	    	System.out.println("HISSA NO:"+his);
   	    	
   	    	 System.out.println("1.SERVER 1");
   	    	 System.out.println("2.SERVER 2");
   	    	 System.out.println("3.SERVER 3");
   	    	 
   	    	 System.out.println("ENTER THE SERVER TO PROCEED:");
   	    	 int ch=sc.nextInt();
   	    	 String pay;
   	    	 if(ch<=3&&ch>0)
   	    	 {
   	    		 System.out.println("ENTER YOUR CAPTCHA:");
       		     pay=sc.next();
   	    	     PreparedStatement pst=con.prepareStatement(query);
   	             pst.setString(1,pay);
   	             pst.setString(2,cust_id);
   	             ResultSet rsc=pst.executeQuery();
   	    	  if(rsc.next())
   	    	  { 
   	    		 
   	    	      	PreparedStatement pst2=con.prepareStatement(query2);
   	    	        pst2.setString(1,father);
     	        	pst2.setString(2,mother);
     	      	    pst2.setString(3,dob);
     	          	pst2.setString(4,adr);
     	    	    pst2.setString(5,adhr);
     	    	    pst2.setString(6,pan);
     	    	    pst2.setString(7,id);
     	    	    pst2.setString(8,oc);
     	    	    pst2.setString(9,state);
     	    	    pst2.setString(10,district);
     	    	     pst2.setString(11,taluk);
     	    	     pst2.setString(12,village);
     	    	   pst2.setInt(13,sur);
     	    	   pst2.setInt(14,his);
   	    	      	pst2.setString(15,"YES");
   	    	      	pst2.setString(16,cust_id);
   	    	      	pst2.executeUpdate();
   	    	      	pst2.close();
   	    	      
   	    	
   	    	      	System.out.println("SUBMITTED SUCCESSFUL");
   	    	      	
   	    	    	
   	    	      	System.out.println("you have successfully completed the REGISTERATION FORM!");
   	    	    	
   	    	      	System.out.println("GOING BACK!!!!!!");
   	    	    	 
   	    	      	
   	    	      
   	    	 }
   	          else
   	           {
   	        	   System.out.println("YOU HAVE ENTERED WRONG CAPTCHA");
   	 
   	 	            
   	        	    System.out.println("ENTER 1 GO BACK: ");
   	        	    int shs=sc.nextInt();
   	           }
   	    	}
   	    	 else
   	    	 {
   	    		 System.out.println("INVALID INPUT");
   	    	 }
   	     }
   	     else
   	     {
   	    	   System.out.println("please set your captcha");
   	    	    System.out.println("GOING BACK!!!!!!");
   	    		     }	
        }
    	 		                                   
    	 		                              
    	 		                                    void bill(String cs_id)throws SQLException
    	 		                              	 {
    	 		                              		 String p_n=cs_id;
    	 		                              		 String url="jdbc:mysql://localhost:3306/miniproject";
    	 		                              			String uname="root";
    	 		                              			String pass="rmpcrmpc";
    	 		                              	        try {
    	 		                              				Class.forName("com.mysql.cj.jdbc.Driver");
    	 		                              			} catch (ClassNotFoundException e) {
    	 		                              				// TODO Auto-generated catch block
    	 		                              				e.printStackTrace();
    	 		                              			}
    	 		                              	        Connection con= DriverManager.getConnection(url,uname,pass);
    	 		                              	        PreparedStatement pst=con.prepareStatement("select * from customer where CUSTOMERID=?");
    	 		                              	        pst.setString(1,p_n);
    	 		                              	        ResultSet rs=pst.executeQuery();
    	 		                              	        if(rs.next())
    	 		                              	        {
    	 		                              	        	System.out.println("LOADING YOUR BILL PLEASE WAIT...");
    	 		                              	        	
    	 		                              	        	System.out.println("***********----------BILL----------***********");
    	 		                              	        	System.out.println("CUSTOMERID    :"+rs.getString(1));
    	 		                              	        	System.out.println("CUSTOMERNAME  :"+rs.getString(2));
    	 		                              	        	System.out.println("TOTALUNITS    :"+rs.getString(3));
    	 		                              	        	System.out.println("TYPE          :"+rs.getString(4));
    	 		                              	        	System.out.println("TOTALAMOUNT   :"+rs.getString(5)+"RS-/-");
    	 		                              	        	System.out.println("PAYMENTSTATUS :"+rs.getString(6));

    	 		                              		 		System.out.println("PRESS 1 TO COUNTINUE:");
    	 		                              		 	    Scanner in=new Scanner(System.in);
    	 		                              		 		int x=in.nextInt();
    	 		                              		 	    pst.close();
    	 		                              		 	    con.close();	
    	 		                              	        }
    	 		                              	        else
    	 		                              	        {
    	 		                              	        	System.out.println("YOU DIDN'T BILLED OR CANCELLED THE PROCESS");

    	 		                              	            System.out.println("Going back!");
    	 		                              	        }
    	 		                              	        }
    	 		                                    
    	 		                                    void meter(String id )throws SQLException{
    	 		                                    	String p_n=id;
       	 		                              		 String url="jdbc:mysql://localhost:3306/miniproject";
       	 		                              			String uname="root";
       	 		                              			String pass="rmpcrmpc";
       	 		                              	        try {
       	 		                              				Class.forName("com.mysql.cj.jdbc.Driver");
       	 		                              			} catch (ClassNotFoundException e) {
       	 		                              				// TODO Auto-generated catch block
       	 		                              				e.printStackTrace();
       	 		                              			}
       	 		                              	        Connection con= DriverManager.getConnection(url,uname,pass);
       	 		                              	        PreparedStatement pst=con.prepareStatement("select * from registeration where CUSTOMERID=?");
       	 		                              	        pst.setString(1,p_n);
       	 		                              	        ResultSet rs=pst.executeQuery();
       	 		                              	        if(rs.next())
       	 		                              	        {
       	 		                              	        	System.out.println("LOADING YOUR FORM PLEASE WAIT...");
       	 		                              	  	
       	 		                 	        	System.out.println("CUSTOMERID    :\t"+rs.getString(1));
       	 		                 	        	System.out.println("CUSTOMER NAME :\t"+rs.getString(2));
       	 		                 	        	System.out.println("FATHERNAME    :\t"+rs.getString(3));
       	 		                 	        	System.out.println("MOTHERNAME    :\t"+rs.getString(4));
       	 		                 	        	System.out.println("DOB           :\t"+rs.getString(5));
       	 		                 	        	System.out.println("ADDRESS       :\t"+rs.getString(6));
       	 		                 	        	System.out.println("ADHAAR NO     :\t"+rs.getString(7));
       	 		                 	        	System.out.println("PAN NO        : "+rs.getString(8));
       	 		                 	        	System.out.println("ELECTION ID   :\t"+rs.getString(9));
       	 		                 	        	System.out.println("OCCUPATION    :\t"+rs.getString(10));
       	 		                 	        	System.out.println("STATE         :\t"+rs.getString(11));
       	 		                 	        	System.out.println("DISTRICT      : "+rs.getString(12));
       	 		                 	        	System.out.println("TALUK         : "+rs.getString(13));
       	 		                 	        	System.out.println("VILLAGE       : "+rs.getString(14));
       	 		                 	        	System.out.println("SURVEY NO     : "+rs.getString(15));
       	 		                 	        	System.out.println("HISSA NO      : "+rs.getString(16));    	
       	 		                 	        	System.out.println("APPROVED     : "+rs.getString(17));
       	 		                    	  
       	 		                              	       

       	 		                              		 		System.out.println("PRESS 1 TO COUNTINUE:");
       	 		                              		 	    Scanner in=new Scanner(System.in);
       	 		                              		 		int x=in.nextInt();
       	 		                              		 	    pst.close();
       	 		                              		 	    con.close();	
       	 		                              	        }
       	 		                              	        else
       	 		                              	        {
       	 		                              	        	System.out.println("YOU DIDN'T BILLED OR CANCELLED THE PROCESS");

       	 		                              	            System.out.println("Going back!");
       	 		                              	        }
    	 		                                    }
}
    	 		                                             
public class ele1{
	public static void main(String[] args) throws SQLException {
	
		int ch;
        Scanner sc=new  Scanner(System.in);
        int  isc,m=1;
        int z=1;
        System.out.printf("\n\t\t****************************************************************");
       
        System.out.printf("\n\t\t           WELCOME TO ELECTRICITY BILLING                  ");

        System.out.printf("\n\t\t************"
        		+ "*************************************************\n\n");
        System.out.println("\t\tLOADING PLEASE WAIT");
        
        while(m==1) 
        {
        	

	      System.out.printf("-----PLEASE LOGIN------- \n\n");
             System.out.println("1.ADMIN");
             System.out.println("2.CUSTOMER");
             System.out.println("3.EXIT");
        
          System.out.println("Enter your option:");
          isc =sc.nextInt();
          if(isc==1 || isc==2 || isc ==3)
          {
        	  if(isc==1)
        	  {
        	    Admin ad =new Admin();
        	    try {
					int f =ad.Adlogin();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	  }
        	  if(isc==2)
        	  {
        		  Boolean loopcontrol=true;
        		  while(loopcontrol)
        		  {	  
        		    Customer cs=new Customer();
        		    
        	
        		    System.out.println("1.LOGIN");
        		    System.out.println("2.CREATE A NEW ACCOUNT");
        		    System.out.println("3.CREATE A NEW ACCOUNT FOR CONNECTION");
        		    System.out.println("4.EXIT");
        	
        		    System.out.println("ENTER YOUR CHOICE:");
        		    ch=sc.nextInt();
        		    if(ch==1)
        		    {
        		    	
        		    	while(z==1) 
        		    	{
        		    	cs.cust_login();
        		    	  break;
        		    	}
        		    }
        		    else if (ch==2)
        		    {
        		    	while(z==1)
        		    	{
        		    	  cs.create_id();
        		    	  break;
        		    	}
        		    }
        		    else if (ch==3)
        		    {
        		    	while(z==1)
        		    	{
        		    	  cs.cret_id();
        		    	  break;
        		    	}
        		    }
        		    else if(ch==4) {
        		    	break;
        		    }
        		    else
        		    {
        		    	System.out.println("Invalid Input!");
        		    	System.out.println("Please Enter a valid Input");
        		    }
        		  }
        	      
        	  }
        	  else if(isc==3)
        	  {
        		  System.exit(1);
        	  }
          }
          else
          {
        	  System.out.println("PLEASE CHOOSE A VALID OPTION");
          }
        }
        
	}
}
    	 		                                            

