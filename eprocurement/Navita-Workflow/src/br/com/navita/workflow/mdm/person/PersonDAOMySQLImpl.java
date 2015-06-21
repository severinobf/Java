/**
 * 
 */
package br.com.navita.workflow.mdm.person;

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
import br.com.navita.workflow.mdm.model.Group;
import br.com.navita.workflow.mdm.model.Person;
import br.com.navita.workflow.mdm.model.Role;
import br.com.navita.workflow.mdm.model.impl.DAOException;
import br.com.navita.workflow.mdm.model.impl.EmailTO;
import br.com.navita.workflow.mdm.model.impl.GroupTO;
import br.com.navita.workflow.mdm.model.impl.PersonTO;
import br.com.navita.workflow.mdm.model.impl.RoleTO;

import com.web2doctors.commons.properties.Propriedades;

/**
 * Implementation of the interface PersonDAO for the MySQL database.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class PersonDAOMySQLImpl implements PersonDAO {
	
	private final Logger logger = Logger.getLogger(PersonDAOMySQLImpl.class);
	
	private final String getPerson = "select up.id, up.email, up.name, up.username, up.address, up.login_type, up.fk_corporation, up.fk_organizational_unity from user_portal up where up.uuid=?";
	private final String getGroups = "select pgm.id, g.id, g.group_name, g.description from portal_group_members pgm, portal_groups g where g.id = pgm.fk_portal_group_id and pgm.fk_user_portal_id = ?";
	@SuppressWarnings("unused")
	private final String getProfiles = "select p.id, p.description, p.name from profile p, portal_groups g, profile_group pg where pg.fk_profile_id = p.id and pg.fk_portal_group_id = g.id and g.id in (select g.id from portal_group_members pgm, portal_groups g where g.id = pgm.fk_portal_group_id and pgm.fk_user_portal_id = ?)";
	private final String getRoles = "select r.id, r.description from roles r, profile_role pr where pr.fk_role_id = r.id and pr.fk_profile_id in (select p.id from profile p, portal_groups g, profile_group pg where pg.fk_profile_id = p.id and pg.fk_portal_group_id = g.id and g.id in (select g.id from portal_group_members pgm, portal_groups g where g.id = pgm.fk_portal_group_id and pgm.fk_user_portal_id = ?))";

	@Override
	public Person getPerson(String userID) throws DAOException {
		Person aPerson = new PersonTO();
		ConnectionPoolFactory poolFact = null;
        ConnectionPool pool = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
        	 poolFact = ConnectionPoolFactory.getInstance();
             pool = poolFact.getConnectionPool(Propriedades.getProperty("data_source_mysql", "navita"));
             conn = pool.getConnection();
             conn.setAutoCommit(true);
             pstmt = conn.prepareStatement(getPerson);
             pstmt.setString(1, userID);
             rs = pstmt.executeQuery();
             while (rs.next()) {
            	 aPerson.setIdCompany(rs.getString("up.fk_corporation"));
            	 aPerson.setName(rs.getString("up.username"));
            	 aPerson.setUUID(userID);
            	 Email email = new EmailTO();
            	 email.setEmail(rs.getString("up.email"));
            	 aPerson.addEmailAddress(email);
            	 aPerson.setRoles(this.getRoles(userID));
            	 aPerson.setGroups(this.getGroups(userID));
             }
            logger.debug("executou: " + getPerson);
            return aPerson;
         } catch (SQLException ex) {
        	logger.error("Erro sql exception " + ex.getMessage());
            ex.printStackTrace();
            throw new DAOException("infrastructure error on retrieving a person");
        } catch (IOException e) {
        	logger.error("Error reading navita.properties");
            e.printStackTrace();
            throw new DAOException("infrastructure error on retrieving a person");
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
	 * get all groups by userid
	 * @param userID
	 * @return
	 * @throws DAOException
	 */
	private List<Group> getGroups(String userID) throws DAOException {
		List<Group> groups = new ArrayList<Group>();
		ConnectionPoolFactory poolFact = null;
        ConnectionPool pool = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            poolFact = ConnectionPoolFactory.getInstance();
            pool = poolFact.getConnectionPool(Propriedades.getProperty("data_source_mysql", "navita"));
            conn = pool.getConnection();
            conn.setAutoCommit(true);
            pstmt = conn.prepareStatement(getGroups);
            pstmt.setString(1, userID);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            	Group aGroup = new GroupTO();
            	aGroup.setID(rs.getLong("g.id"));
            	aGroup.setDescription(rs.getString("g.description"));
            	groups.add(aGroup);
            }
            logger.debug("executou: " + getGroups);
            return groups;
         } catch (SQLException ex) {
        	logger.error("Erro sql exception " + ex.getMessage());
            ex.printStackTrace();
            throw new DAOException("infrastructure error on retrieving groups of a person");
        } catch (IOException e) {
        	logger.error("Error reading navita.properties");
            e.printStackTrace();
            throw new DAOException("infrastructure error on retrieving groups of a person");
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
	 * gets all roles by user id.
	 * @param userID
	 * @return
	 * @throws DAOException
	 */
	private List<Role> getRoles(String userID) throws DAOException {
		List<Role> roles = new ArrayList<Role>();
		ConnectionPoolFactory poolFact = null;
        ConnectionPool pool = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            poolFact = ConnectionPoolFactory.getInstance();
            pool = poolFact.getConnectionPool(Propriedades.getProperty("data_source_mysql", "navita"));
            conn = pool.getConnection();
            conn.setAutoCommit(true);
            pstmt = conn.prepareStatement(getRoles);
            pstmt.setString(1, userID);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            	Role aRole = new RoleTO();
            	aRole.setDescription(rs.getString("r.description"));
            	aRole.setID(rs.getLong("r.id"));
            	aRole.setName(rs.getString("r.description"));
            	roles.add(aRole);
            }
            logger.debug("executou: " + getGroups);
            return roles;
         } catch (SQLException ex) {
        	logger.error("Erro sql exception " + ex.getMessage());
            ex.printStackTrace();
            throw new DAOException("infrastructure error on retrieving roles of a person");
        } catch (IOException e) {
        	logger.error("Error reading navita.properties");
            e.printStackTrace();
            throw new DAOException("infrastructure error on retrieving roles of a person");
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
	public Person getProductsAndServices(String userID) throws DAOException {
		// via serviços Employee do back-end
		return null;
	}
	
	public static void main(String[] args) {
		PersonDAO dao = PersonDAOFactory.getInstance().getimplementation();
		Person p = null;
		try {
			p = dao.getPerson("f277de20-c405-11e4-9220-8f7251fd9065");
		} catch (DAOException e) {
			e.printStackTrace();
		}
		System.out.println(p.getUUID());
	}

}
