package com.chacha.guide.signup.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.chacha.guide.signup.beans.OldWorldUser;

public class UserDAO extends JdbcDaoSupport {

	private static final String QUERY_UNIQUE_EMAIL = "SELECT 1 FROM users WHERE email=?";
	private static final String QUERY_UNIQUE_HANDLE = "SELECT 1 FROM users WHERE handle=?";
	
	private static final String INSERT_USER =
			"INSERT INTO users "
			+ "(user_type, active, first_name, last_name, middle_initial, email, password, handle, gender, date_of_birth, "
					+ "phone_number, address_line1, address_line2, city, state_or_province, postal_code, created_at, created_by, updated_at)"
			+ "values (1, 0, ?, ?, ?, ?, aes_encrypt(?, f_seed()), ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), 2, NOW())";
	
	public long createUser(OldWorldUser user) {
		getJdbcTemplate().update(INSERT_USER,
				user.getFirstName(), user.getLastName(), user.getMiddleInitial(),
				user.getEmailAddress(), user.getPassword(), user.getHandle(),
				user.getGender().letter(), user.getBirthDate().toDate(),
				user.getPhoneNumber(), user.getAddress1(), user.getAddress2(),
				user.getCity(), user.getState(), user.getPostalCode());
		
		return getJdbcTemplate().queryForLong("SELECT id FROM users WHERE email=?", user.getEmailAddress());
	}
	
	public boolean doesEmailExist(String email) {
		SqlRowSet rowSet = getJdbcTemplate().queryForRowSet(QUERY_UNIQUE_EMAIL, email);
		
		/* next lets us know if another row exists, in this case the only row */
		return rowSet.next();
	}
	
	public boolean doesHandleExist(String handle) {
		SqlRowSet rowSet = getJdbcTemplate().queryForRowSet(QUERY_UNIQUE_HANDLE, handle);
		
		/* next lets us know if another row exists, in this case the only row */
		return rowSet.next();
	}
}
