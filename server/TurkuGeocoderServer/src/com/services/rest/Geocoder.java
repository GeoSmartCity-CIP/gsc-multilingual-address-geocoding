package com.services.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.dbg.connector.DBConnector;

public class Geocoder {
	
	 public static List<Results> GetAddress (String adress)     {
	    	
	    	ArrayList<Results> results = new ArrayList<Results>();

	    	
	        Connection con = null;
	        Statement st = null;
	        ResultSet rs = null;
	    	try {
	    		
	    			con = DBConnector.getConnection();
	            
	    		
	    			st = con.createStatement();
	            
	            
	    			String query1 = "SELECT id, ts_headline(name, query) as address , ST_AsGeoJSON(geom) as geometry , rank FROM (SELECT gid AS id, name_fi AS name, geom , query, ts_rank_cd(ts, query, 32 /* rank/(rank+1) */ ) AS rank FROM multilingual_roads, to_tsquery(\'simple\', regexp_replace(trim(\'";
		            String query2 = "\'), E'\\\\s+\', \'&\', \'g\')) query WHERE query @@ ts ORDER BY rank DESC LIMIT 10) AS foo;";
		            //String query = "SELECT id, name as address, ST_AsGeoJSON(geom) as geometry FROM geonames limit 10;";
	            rs = st.executeQuery(query1 + adress + query2);

	            while (rs.next()) {
	            	Results result = new Results();
	            	result.getData(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4) );
	            	results.add(result);
	            	
	            }

	        } catch (SQLException ex) {
	        	//result = ex.getMessage();
	        	Logger lgr = Logger.getLogger(DBConnector.class.getName());
	            lgr.log(Level.SEVERE, ex.getMessage(), ex);



	        } catch (Exception  ex) {
				// TODO Auto-generated catch block
	        	//result = e.getMessage();
	        	Logger lgr = Logger.getLogger(DBConnector.class.getName());
	            lgr.log(Level.SEVERE, ex.getMessage(), ex);


			}  finally {
	            try {
	                if (rs != null) {
	                    rs.close();
	                }
	                if (st != null) {
	                    st.close();
	                }
	                if (con != null) {
	                    //con.close();
	                }

	            } catch (SQLException ex) {
	            	//result = ex.getMessage();
	            	Logger lgr = Logger.getLogger(DBConnector.class.getName());
	                lgr.log(Level.SEVERE, ex.getMessage(), ex);
	            }
	            
	        }
	    	return results;
	    }
}
