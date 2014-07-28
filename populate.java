
import java.sql.*;
import java.util.*;
import java.io.*;

public class populate
{
	static Connection mainConnection = null;
  	static Statement mainStatement = null;
  	static ResultSet mainResultSet = null;
  	static PreparedStatement SecondStatement = null;
	static Statement ThirdStatement = null;
	
	/*****************************/
    public static void main(String args[])
    {
        if(args.length == 0){
			System.out.println("The command line is not right.");
			return;
		}
		String filenm[]=new String[2];
        filenm[0] = args[0];
        filenm[1] = args[1];
		ConnectToDB();
		
		//Read information from file and store to database
		try
        {
			if(filenm[0].equals("restaurants.txt") && filenm[1].equals("photos.txt"))
			{
				// delete previous data from the DB
				System.out.print( "\n ** Deleting previous tuples ..." );
				mainStatement.executeUpdate("delete from rsensor");
				mainStatement.executeUpdate("delete from psensor");
				mainStatement.executeUpdate("delete from ptpoints");
				mainStatement.executeUpdate("delete from rspoints");
				System.out.println( ", Deleted. **" );
				// publish new data
				System.out.print( " ** Inserting Data ...\n" );
				FileReader read0 = new FileReader(filenm[0]);
				BufferedReader br0 = new BufferedReader(read0);
				FileReader read1 = new FileReader(filenm[1]);
				BufferedReader br1 = new BufferedReader(read1);
				String row1, row2;
				while((row1=br0.readLine())!=null)
				{
					row1 = row1.replaceAll("'", "''");
					String row3[]=row1.split(",");
					String sql0, sql2;
					sql0="Insert into rspoints values('"+row3[0]+"','" +row3[1] + "', SDO_GEOMETRY(2001,NULL,SDO_point_TYPE("+row3[2]+","+row3[3]+",NULL),NULL,NULL),'" +row3[5] + "')";
					System.out.println(sql0);
					mainStatement.executeQuery(sql0);
                    sql2="Insert into rsensor values('"+row3[0]+"','"+row3[4]+"')";
					System.out.println(sql2);
					mainStatement.executeQuery(sql2);

				}
				while((row2=br1.readLine())!=null)
				{
					row2 = row2.replaceAll("'", "''");
					String row4[]=row2.split(",");
					String row6[]=row4[4].split(";");
					String sql1, sql3;
					sql1="Insert into ptpoints values('"+row4[0]+"','" +row4[1] + "', SDO_GEOMETRY(2001,NULL,SDO_point_TYPE("+row4[2]+"," +row4[3]+",NULL),NULL,NULL),'" + row6[0]+"')";
					System.out.println(sql1);
					mainStatement.executeQuery(sql1);
					for(int i=1; i<row6.length; i++)
					{
						sql3="Insert into psensor values('"+row4[0]+"','"+row6[i]+"')";
						System.out.println(sql3);
						mainStatement.executeQuery(sql3);
					}
				}
				br0.close();
				br1.close();
				System.out.println( "Done.\n **" );
			}

        }
        catch( Exception e )
        { System.out.println( " Error 2: " + e.toString() ); }
    }

    /*****************************/
	
	public static void ConnectToDB()
    {
		try
		{
			// loading Oracle Driver
    		System.out.print("Looking for Oracle's jdbc-odbc driver ... ");
	    	DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
	    	System.out.println(", Loaded.");

			String host = "localhost";
	  	    String port = "1521";
		    String dbName = "orcl";
		    String userName = "SYSTEM";
            String password = "KIDkid123";
		    String dbURL = "jdbc:oracle:thin:@" + host + ":" + port + "/" + dbName;

	    	System.out.print("Connecting to DB...");
	    	mainConnection = DriverManager.getConnection(dbURL, userName, password);
	    	System.out.println(", Connected!");

    		mainStatement = mainConnection.createStatement();
	    	SecondStatement = mainConnection.prepareStatement( "insert into values" );
            ThirdStatement = mainConnection.createStatement(
                                         ResultSet.TYPE_SCROLL_INSENSITIVE,
                                         ResultSet.CONCUR_READ_ONLY);

   		}
   		catch (Exception e)
   		{
     		System.out.println( "Error while connecting to DB: "+ e.toString() );
     		e.printStackTrace();
     		System.exit(-1);
   		}
    }
}