/**
 * 
 */
package br.com.navita.workflow.mdm.catalog;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.navita.workflow.mdm.catalog.sku.SkuDAO;
import br.com.navita.workflow.mdm.catalog.sku.SkuDAOFactory;
import br.com.navita.workflow.mdm.dao.ConnectionPool;
import br.com.navita.workflow.mdm.dao.ConnectionPoolFactory;
import br.com.navita.workflow.mdm.model.Group;
import br.com.navita.workflow.mdm.model.Person;
import br.com.navita.workflow.mdm.model.Role;
import br.com.navita.workflow.mdm.model.impl.CarrierTO;
import br.com.navita.workflow.mdm.model.impl.DAOException;
import br.com.navita.workflow.mdm.model.impl.GroupTO;
import br.com.navita.workflow.mdm.model.impl.PersonTO;
import br.com.navita.workflow.mdm.tenant.TenantEprocurementParametersTO;

import com.web2doctors.commons.properties.Propriedades;

/**
 * Implementation of CatalogDAO for MySQL database.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class CatalogDAOMySQLImpl implements CatalogDAO {
	
	private final Logger logger = Logger.getLogger(CatalogDAOMySQLImpl.class);
	
	/* find parameters by the user's groups */
	private final String findByGroup = "select carrier_shortname, sku_model, price, daysForCommodatum, basePriceForCommodatum, fine from TenantConfiguration where tenant_shortname = ? and group_description = ?";
	/* find parameters by the user's roles */
	private final String findByRole = "select carrier_shortname, sku_model, price, daysForCommodatum, basePriceForCommodatum, fine from TenantConfiguration where tenant_shortname = ? and role_description = ?";
	/* inserts a parameter in the database */
	private final String addParameter = "insert into TenantConfiguration(tenant_uuid, tenant_shortname, group_description, role_description, carrier_shortname, sku_model, price, daysForCommodatum, basePriceForCommodatum, fine) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/* instance wrapper for a Catalog */
	private CatalogTO aCatalog = null;
	
	public CatalogTO getCatalog(Person aPerson) throws DAOException {
		aCatalog = new CatalogTO();
		Iterator<TenantEprocurementParametersTO> parameters = null;
		if (aPerson.getGroups() != null) {
			parameters = getParametersByGroup(aPerson).iterator();
			while (parameters.hasNext()) {
				populateCatalog(aCatalog, parameters.next());
			}
		}
		if (aPerson.getRoles() != null) {
			parameters = getParametersByRole(aPerson).iterator();
			while (parameters.hasNext()) {
				populateCatalog(aCatalog, parameters.next());
			}
		}
		return aCatalog;
	}
	
	private void populateCatalog(CatalogTO aCatalog, TenantEprocurementParametersTO parameters) throws DAOException {
		
		SkuDAO skuDAO = SkuDAOFactory.getInstance().getimplementation();
		SkuTO aSku = skuDAO.getByModel(parameters.getSku().getModel());
		aSku.setPrice(parameters.getPrice());
		aSku.setDaysOfCommodatum(parameters.getDaysOfCommodatum());
		aSku.setBasePriceForCommodatum(parameters.getBasePriceForCommodatum());
		aSku.setFine(parameters.getFine());
		aCatalog.addProduto(aSku);
		
	}
	
	/**
	 * gets all the parameters by all groups that a person belongs to.  
	 * @param aPerson
	 * @return
	 * @throws DAOException
	 */
	private List<TenantEprocurementParametersTO> getParametersByGroup(Person aPerson) throws DAOException {
		TenantEprocurementParametersTO parameters = null;
		List<TenantEprocurementParametersTO> ret = new ArrayList<TenantEprocurementParametersTO>();
        ConnectionPool pool = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
             pool = ConnectionPoolFactory.getInstance().getConnectionPool(Propriedades.getProperty("data_source_catalog", "navita"));
             conn = pool.getConnection();
             conn.setAutoCommit(true);
             pstmt = conn.prepareStatement(findByGroup);
             Iterator<Group> i = aPerson.getGroups().iterator();
             while (i.hasNext()) {
            	 String description = i.next().getDescription();
	             pstmt.setString(1, aPerson.getIdCompany());
	             pstmt.setString(2,  description);
	             rs = pstmt.executeQuery();
		             while (rs.next()) {
		            	parameters = new TenantEprocurementParametersTO(); 
		            	CarrierTO aCarrier = new CarrierTO();
						aCarrier.setShortName(rs.getString("carrier_shortname"));
						parameters.setCarrier(aCarrier);
		            	SkuTO sku = new SkuTO();
		            	sku.setModel(rs.getString("sku_model"));
		            	parameters.setSku(sku);
		            	parameters.setBasePriceForCommodatum(rs.getDouble("basePriceForCommodatum"));
		            	parameters.setDaysOfCommodatum(rs.getInt("daysForCommodatum"));
		            	parameters.setFine(rs.getDouble("fine"));
		            	parameters.setGroupName(description);
						ret.add(parameters);
		             }
	             }
            logger.debug("executou: " + findByGroup);
            return ret;
         } catch (SQLException ex) {
        	logger.error("Erro sql exception " + ex.getMessage());
            ex.printStackTrace();
            throw new DAOException("infrastructure error on retrieving parameters by group");
        } catch (IOException e) {
        	logger.error("Error reading navita.properties");
            e.printStackTrace();
            throw new DAOException("infrastructure error on retrieving parameters by group");
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
	
	/**
	 * gets all the parameters by all roles that a person belongs to.
	 * @param aPerson
	 * @return
	 * @throws DAOException
	 */
	private List<TenantEprocurementParametersTO> getParametersByRole(Person aPerson) throws DAOException {
		TenantEprocurementParametersTO parameters = null;
		List<TenantEprocurementParametersTO> ret = new ArrayList<TenantEprocurementParametersTO>();
        ConnectionPool pool = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
             pool = ConnectionPoolFactory.getInstance().getConnectionPool(Propriedades.getProperty("data_source_catalog", "navita"));
             conn = pool.getConnection();
             conn.setAutoCommit(true);
             pstmt = conn.prepareStatement(findByRole);
             Iterator<Role> i = aPerson.getRoles().iterator();
             while (i.hasNext()) {
             String name = i.next().getName(); 	 
             pstmt.setString(1, aPerson.getIdCompany());
             pstmt.setString(2,  name);
             rs = pstmt.executeQuery();
	             while (rs.next()) {
	            	 parameters = new TenantEprocurementParametersTO(); 
	            	 // tenant_uuid, tenant_shortname, group_description, role_description, carrier_shortname, sku_model, price, daysForCommodatum, basePriceForCommodatum, fine
					CarrierTO aCarrier = new CarrierTO();
					aCarrier.setShortName((rs.getString("carrier_shortname")));
					parameters.setCarrier(aCarrier);
	            	SkuTO sku = new SkuTO();
	            	sku.setModel(rs.getString("sku_model"));
	            	parameters.setSku(sku);
	            	parameters.setBasePriceForCommodatum(rs.getDouble("basePriceForCommodatum"));
	            	parameters.setDaysOfCommodatum(rs.getInt("daysForCommodatum"));
	            	parameters.setFine(rs.getDouble("fine"));
	            	parameters.setRoleName(name);
					ret.add(parameters);
	             }
             }
            logger.debug("executou: " + findByGroup);
            return ret;
         } catch (SQLException ex) {
        	logger.error("Erro sql exception " + ex.getMessage());
            ex.printStackTrace();
            throw new DAOException("infrastructure error on retrieving parameters by group");
        } catch (IOException e) {
        	logger.error("Error reading navita.properties");
            e.printStackTrace();
            throw new DAOException("infrastructure error on retrieving parameters by group");
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

	@Override
	public void addParameters(TenantEprocurementParametersTO parameters) throws DAOException {
		ConnectionPool pool = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        String nullString = null;
        try {
        	 // gets the sku by its model if importing a file.
        	 if (parameters.getSku().getId() == null) {
	        	 SkuDAO skuDAO = SkuDAOFactory.getInstance().getimplementation();
	        	 SkuTO sku = skuDAO.getByModel(parameters.getSku().getModel());
	        	 parameters.setSku(sku);
        	 }
        	 pool = ConnectionPoolFactory.getInstance().getConnectionPool(Propriedades.getProperty("data_source_catalog", "navita"));
             conn = pool.getConnection();
             conn.setAutoCommit(true);
             pstmt = conn.prepareStatement(addParameter);
             // tenant_uuid, tenant_shortname, group_description, role_description, carrier_shortname, sku_model, price, daysForCommodatum, basePriceForCommodatum, fine
             if (parameters.getTenantUUID() != null) pstmt.setString(1, parameters.getTenantUUID().toString());
             else pstmt.setString(1, nullString);
             pstmt.setString(2, parameters.getTenantShortName());
             pstmt.setString(3, parameters.getGroupName());
             pstmt.setString(4,  parameters.getRoleName());
             pstmt.setString(5, parameters.getCarrier().getShortName());
             pstmt.setString(6, parameters.getSku().getModel());
             pstmt.setDouble(7, parameters.getPrice());
             pstmt.setInt(8,  parameters.getDaysOfCommodatum());
             pstmt.setDouble(9, parameters.getBasePriceForCommodatum());
             pstmt.setDouble(10, parameters.getFine());
             pstmt.executeUpdate();
             logger.debug("executou: " + addParameter);
         } catch (SQLException ex) {
        	logger.error("Erro sql exception " + ex.getMessage());
            ex.printStackTrace();
            throw new DAOException("infrastructure error on adding parameters of a tenant");
        } catch (IOException e) {
        	logger.error("Error reading navita.properties");
            e.printStackTrace();
            throw new DAOException("infrastructure error on adding parameters of a tenant");
        } finally {
        	if (pstmt != null) {
                pool.close(pstmt);
            }
            if (conn != null) {
                pool.close(conn);
            }
        }
		
	}
	
	public static void main(String[] args) {
		Person aPerson = new PersonTO();
		aPerson.setIdCompany("PORTO");
		//RoleTO aRole = new RoleTO();
		//aRole.setName("CLEVEL");
		//aPerson.addRole(aRole);
		GroupTO aGroup = new GroupTO();
		aGroup.setDescription("GERENTES");
		aPerson.addGroup(aGroup);
		
		CatalogDAO dao = new CatalogDAOMySQLImpl();
		try {
			CatalogTO to = dao.getCatalog(aPerson);
			System.out.println("tamanho " + to.getProdutos().size());
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

}
