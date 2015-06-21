/**
 * 
 */
package br.com.navita.workflow.mdm.catalog.sku;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.navita.workflow.mdm.catalog.SkuTO;
import br.com.navita.workflow.mdm.dao.ConnectionPool;
import br.com.navita.workflow.mdm.dao.ConnectionPoolFactory;
import br.com.navita.workflow.mdm.model.ProductOrServiceType;
import br.com.navita.workflow.mdm.model.impl.DAOException;

import com.web2doctors.commons.properties.Propriedades;

/**
 * Implementation of SkuDAO for MySQL.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class SkuDAOMySQLImpl implements SkuDAO {
	
	private final Logger logger = Logger.getLogger(SkuDAOMySQLImpl.class);
	
	private final String getSku = "select foreign_uuid, short_description, long_description, technical_characteristics, warranty, url_thumbnail, url_image, productType, lastModificationTime, model, dual_chip, manufacturer, platform, price from Sku where id = ?";
	private final String getByModel = "select id, foreign_uuid, short_description, long_description, technical_characteristics, warranty, url_thumbnail, url_image, productType, lastModificationTime, dual_chip, manufacturer, platform, price from Sku where model = ?";
	private final String addSku = "insert into Sku (foreign_uuid, short_description, long_description, technical_characteristics, warranty, url_thumbnail, url_image, productType, lastModificationTime, model, dual_chip, manufacturer, platform, price) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	
	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.catalog.sku.SkuDAO#addSku(br.com.navita.workflow.mdm.catalog.SkuTO)
	 */
	@Override
	public void addSku(SkuTO sku) throws DAOException {
		ConnectionPool pool = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
        	 pool = ConnectionPoolFactory.getInstance().getConnectionPool(Propriedades.getProperty("data_source_catalog", "navita"));
             conn = pool.getConnection();
             conn.setAutoCommit(true);
             pstmt = conn.prepareStatement(addSku);
             pstmt.setString(1, sku.getUUID());
             pstmt.setString(2, sku.getShortDescription());
             pstmt.setString(3, sku.getLongDescription());
             pstmt.setString(4, sku.getTechnicalCharacteristics());
             pstmt.setString(5, sku.getWarranty());
             pstmt.setString(6, sku.getUrlThumbnail());
             pstmt.setString(7, sku.getUrlImage());
             pstmt.setString(8, sku.getProductType().toString());
             pstmt.setTimestamp(9, new Timestamp(sku.getLastModificationTime().getTimeInMillis()));
             pstmt.setString(10, sku.getModel());
             pstmt.setString(11, sku.getDual());
             pstmt.setString(12, sku.getManufacturer());
             pstmt.setString(13, sku.getPlatform());
             pstmt.setDouble(14, sku.getPrice());
             pstmt.executeUpdate();
             logger.debug("executou: " + addSku);
         } catch (SQLException ex) {
        	logger.error("Erro sql exception " + ex.getMessage());
            ex.printStackTrace();
            throw new DAOException("infrastructure error on adding a sku");
        } catch (IOException e) {
        	logger.error("Error reading navita.properties");
            e.printStackTrace();
            throw new DAOException("infrastructure error on adding a sku");
        } finally {
        	if (pstmt != null) {
                pool.close(pstmt);
            }
            if (conn != null) {
                pool.close(conn);
            }
        }

	}

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.catalog.sku.SkuDAO#getSku(java.lang.Long)
	 */
	@Override
	public SkuTO getSku(Long id) throws DAOException {
		SkuTO sku = new SkuTO();
        ConnectionPool pool = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
             pool = ConnectionPoolFactory.getInstance().getConnectionPool(Propriedades.getProperty("data_source_catalog", "navita"));
             conn = pool.getConnection();
             conn.setAutoCommit(true);
             pstmt = conn.prepareStatement(getSku);
             pstmt.setLong(1, id);
             rs = pstmt.executeQuery();
             if (rs.next()) {
            	sku.setDual(rs.getString("dual_chip"));
            	sku.setId(id);
            	Calendar lastModification = Calendar.getInstance();
            	lastModification.setTimeInMillis(rs.getTimestamp("lastModificationTime").getTime());
            	sku.setLastModificationTime(lastModification);
            	sku.setLongDescription(rs.getString("long_description"));
            	sku.setManufacturer(rs.getString("manufacturer"));
            	sku.setModel(rs.getString("model"));
            	sku.setPlatform(rs.getString("platform"));
            	sku.setPrice(rs.getDouble("price"));
            	sku.setProductType(ProductOrServiceType.valueOf(rs.getString("productType")));
            	sku.setShortDescription(rs.getString("short_description"));
            	sku.setTechnicalCharacteristics(rs.getString("technical_characteristics"));
            	sku.setUrlImage(rs.getString("url_image"));
            	sku.setUrlThumbnail(rs.getString("url_thumbnail"));
            	sku.setUUID(rs.getString("foreign_uuid"));
            	sku.setWarranty(rs.getString("warranty"));
            	// Carrier
             }
            logger.debug("executou: " + getSku);
            return sku;
         } catch (SQLException ex) {
        	logger.error("Erro sql exception " + ex.getMessage());
            ex.printStackTrace();
            throw new DAOException("infrastructure error on retrieving a sku");
        } catch (IOException e) {
        	logger.error("Error reading navita.properties");
            e.printStackTrace();
            throw new DAOException("infrastructure error on retrieving a sku");
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
	 * @see br.com.navita.workflow.mdm.catalog.sku.SkuDAO#getSkus(br.com.navita.workflow.mdm.catalog.SkuTO)
	 */
	@Override
	public List<SkuTO> getSkus(SkuTO parameters) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	@Override
	public SkuTO getByModel(String model) throws DAOException {
		SkuTO sku = new SkuTO();
        ConnectionPool pool = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
             pool = ConnectionPoolFactory.getInstance().getConnectionPool(Propriedades.getProperty("data_source_catalog", "navita"));
             conn = pool.getConnection();
             conn.setAutoCommit(true);
             pstmt = conn.prepareStatement(getByModel);
             pstmt.setString(1, model);
             rs = pstmt.executeQuery();
             if (rs.next()) {
            	sku.setDual(rs.getString("dual_chip"));
            	sku.setId(rs.getLong("id"));
            	Calendar lastModification = Calendar.getInstance();
            	lastModification.setTimeInMillis(rs.getTimestamp("lastModificationTime").getTime());
            	sku.setLastModificationTime(lastModification);
            	sku.setLongDescription(rs.getString("long_description"));
            	sku.setManufacturer(rs.getString("manufacturer"));
            	sku.setModel(model);
            	sku.setPlatform(rs.getString("platform"));
            	sku.setPrice(rs.getDouble("price"));
            	sku.setProductType(ProductOrServiceType.valueOf(rs.getString("productType")));
            	sku.setShortDescription(rs.getString("short_description"));
            	sku.setTechnicalCharacteristics(rs.getString("technical_characteristics"));
            	sku.setUrlImage(rs.getString("url_image"));
            	sku.setUrlThumbnail(rs.getString("url_thumbnail"));
            	sku.setUUID(rs.getString("foreign_uuid"));
            	sku.setWarranty(rs.getString("warranty"));
            	// Carrier
             }
            logger.debug("executou: " + getSku);
            return sku;
         } catch (SQLException ex) {
        	logger.error("Erro sql exception " + ex.getMessage());
            ex.printStackTrace();
            throw new DAOException("infrastructure error on retrieving a sku");
        } catch (IOException e) {
        	logger.error("Error reading navita.properties");
            e.printStackTrace();
            throw new DAOException("infrastructure error on retrieving a sku");
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
