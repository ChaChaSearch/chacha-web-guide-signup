package com.chacha.guide.signup.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.chacha.guide.signup.beans.GovernmentIdentifierType;
import com.chacha.guide.signup.beans.OldWorldUser;

public class VendorDAO extends JdbcDaoSupport {

	private static final String QUERY_UNIQUE_SSN = "SELECT 1 FROM vendor WHERE ssn=aes_encrypt(?, f_seed())";
	private static final String QUERY_UNIQUE_EIN = "SELECT 1 FROM vendor WHERE ein=aes_encrypt(?, f_seed())";
	
	private static final String INSERT_VENDOR_RECORD =
			"INSERT INTO vendor "
			+ "(id, first_name, last_name, middle_initial, ssn, ein, "
				+ "address_line1, address_line2, city, state_or_province, postal_code, "
				+ "exempt_status, pay_instantly, bank_account, payment_type, verified, "
				+ "created_at, created_by, updated_at)"
			+ "values (?, ?, ?, ?, aes_encrypt(?, f_seed()), aes_encrypt(?, f_seed()), ?, ?, ?, ?, ?, 1, 1, ?, 'PAYPAL', 0, NOW(), ?, NOW())";
	
	public void createVendorRecord(OldWorldUser user) {
		String ssn = user.getGovernmentIdType() == GovernmentIdentifierType.SSN ? user.getGovernmentId() : null;
		String ein = user.getGovernmentIdType() == GovernmentIdentifierType.EIN ? user.getGovernmentId() : null;
		
		getJdbcTemplate().update(INSERT_VENDOR_RECORD,
				user.getUserId(), user.getFirstName(), user.getLastName(), user.getMiddleInitial(), ssn, ein,
				user.getAddress1(), user.getAddress2(), user.getCity(), user.getState(), user.getPostalCode(),
				user.getEmailAddress(), user.getUserId());
	}
	
	public boolean doesSSNExist(String ssn) {
		SqlRowSet rowSet = getJdbcTemplate().queryForRowSet(QUERY_UNIQUE_SSN, ssn);
		
		/* next lets us know if another row exists, in this case the only row */
		return rowSet.next();
	}
	
	public boolean doesEINExist(String ein) {
		SqlRowSet rowSet = getJdbcTemplate().queryForRowSet(QUERY_UNIQUE_EIN, ein);
		
		/* next lets us know if another row exists, in this case the only row */
		return rowSet.next();
	}
	
}
