/**
 * 
 */
package br.com.navita.workflow.mdm.carrier;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.navita.workflow.mdm.dao.ConnectionPool;
import br.com.navita.workflow.mdm.dao.ConnectionPoolFactory;
import br.com.navita.workflow.mdm.model.Email;
import br.com.navita.workflow.mdm.model.impl.CarrierTO;
import br.com.navita.workflow.mdm.model.impl.DAOException;
import br.com.navita.workflow.mdm.model.impl.EmailTO;

import com.web2doctors.commons.properties.Propriedades;

/**
 * Implementation of CarrierDAO for MySQL database
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class CarrierDAOMySQLImpl implements CarrierDAO {
	
	private final Logger logger = Logger.getLogger(CarrierDAOMySQLImpl.class);
	
	private final String getCarrier = "select id, foreign_uuid, name, shortname, integrationUrl, integrationEmail from Carrier where shortname=?";
	private final String getAll = "select id, foreign_uuid, name, shortname, integrationUrl, integrationEmail from Carrier";
	
	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.carrier.CarrierDAO#getCarrier(java.lang.String)
	 */
	@Override
	public CarrierTO getCarrier(String shortName) throws DAOException {
		CarrierTO carrier = new CarrierTO();
        ConnectionPool pool = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
             pool = ConnectionPoolFactory.getInstance().getConnectionPool(Propriedades.getProperty("data_source_catalog", "navita"));
             conn = pool.getConnection();
             conn.setAutoCommit(true);
             pstmt = conn.prepareStatement(getCarrier);
             pstmt.setString(1, shortName);
             rs = pstmt.executeQuery();
             if (rs.next()) {
            	carrier.setId(rs.getLong("id"));
            	Email integrationEmailAddress = new EmailTO();
            	integrationEmailAddress.setEmail(rs.getString("integrationEmail"));
            	carrier.setIntegrationEmailAddress(integrationEmailAddress);
            	carrier.setIntegrationServicesURL(rs.getString("integrationUrl"));
            	carrier.setName(rs.getString("name"));
            	carrier.setShortName(shortName);
            	// inventory data here
             }
            logger.debug("executou: " + getCarrier);
            return carrier;
         } catch (SQLException ex) {
        	logger.error("Erro sql exception " + ex.getMessage());
            ex.printStackTrace();
            throw new DAOException("infrastructure error on retrieving a carrier");
        } catch (IOException e) {
        	logger.error("Error reading navita.properties");
            e.printStackTrace();
            throw new DAOException("infrastructure error on retrieving a carrier");
        } finally {
        	if (rs != null) {
        		pool.close(rs);
        	}
            if (pstmt != null) {
                pool.close(pstmt);
            }
            if (conn != null) {
                pool.close(conn);
            }
        }
	}

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.carrier.CarrierDAO#getAll()
	 */
	@Override
	public List<CarrierTO> getAll() throws DAOException {
		List<CarrierTO> carriers = new ArrayList<CarrierTO>();
        ConnectionPool pool = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
             pool = ConnectionPoolFactory.getInstance().getConnectionPool(Propriedades.getProperty("data_source_catalog", "navita"));
             conn = pool.getConnection();
             conn.setAutoCommit(true);
             pstmt = conn.prepareStatement(getAll);
             rs = pstmt.executeQuery();
             while (rs.next()) {
            	CarrierTO carrier = new CarrierTO();
            	carrier.setId(rs.getLong("id"));
            	Email integrationEmailAddress = new EmailTO();
            	integrationEmailAddress.setEmail(rs.getString("integrationEmail"));
            	carrier.setIntegrationEmailAddress(integrationEmailAddress);
            	carrier.setIntegrationServicesURL(rs.getString("integrationUrl"));
            	carrier.setName(rs.getString("name"));
            	carrier.setShortName(rs.getString("shortname"));
            	// inventory data here
            	carriers.add(carrier);
             }
            logger.debug("executou: " + getCarrier);
            return carriers;
         } catch (SQLException ex) {
        	logger.error("Erro sql exception " + ex.getMessage());
            ex.printStackTrace();
            throw new DAOException("infrastructure error on retrieving all carriers");
        } catch (IOException e) {
        	logger.error("Error reading navita.properties");
            e.printStackTrace();
            throw new DAOException("infrastructure error on retrieving all carriers");
        } finally {
        	if (rs != null) {
        		pool.close(rs);
        	}
            if (pstmt != null) {
                pool.close(pstmt);
            }
            if (conn != null) {
                pool.close(conn);
            }
        }
	}

}
