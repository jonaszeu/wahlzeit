/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.services;

import com.google.appengine.api.datastore.Email;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Test cases for the EmailAddress class.
 */
public class EmailAddressTest extends TestCase {

	/**
	 *
	 */
	public EmailAddressTest(String name) {
		super(name);
	}

	/**
	 *
	 */
	public void testGetEmailAddressFromString() {
		// invalid email addresses are allowed for local testing and online avoided by Google

		assertTrue(createEmailAddressIgnoreException("bingo@bongo"));
		assertTrue(createEmailAddressIgnoreException("bingo@bongo.com"));
		assertTrue(createEmailAddressIgnoreException("bingo.bongo@bongo.com"));
		assertTrue(createEmailAddressIgnoreException("bingo+bongo@bango"));
	}

	/**
	 *
	 */
	protected boolean createEmailAddressIgnoreException(String ea) {
		try {
			EmailAddress.getFromString(ea);
			return true;
		} catch (IllegalArgumentException ex) {
			// creation failed
			return false;
		}
	}

	/**
	 *
	 */
	public void testEmptyEmailAddress() {
		assertFalse(EmailAddress.EMPTY.isValid());
	}

	@Test
	public void testGetFromString(){
		EmailAddress address1 = new EmailAddress("address1@test.io");

		assertEquals("address1@test.io", address1.asString());
	}

	@Test
	public void testAsString(){
		EmailAddress address1 = new EmailAddress("address1@test.io");
		EmailAddress address2 = EmailAddress.getFromString("address2@test.io");

		assertEquals("address1@test.io", address1.asString());
		assertEquals("address2@test.io", address2.asString());
	}

	@Test
	public void testAsInternetAddress(){
		EmailAddress address1 = EmailAddress.getFromString("address1@test.io");
		assertEquals("address1@test.io", address1.asInternetAddress().toString());

	}

	@Test
	public void testIsEquals(){
		assertTrue((EmailAddress.EMPTY.isEqual(EmailAddress.EMPTY)));

		EmailAddress validAdress = new EmailAddress("address1@test.io");
		assertFalse((validAdress.isEqual(EmailAddress.EMPTY)));
		assertFalse((EmailAddress.EMPTY.isEqual(validAdress)));

		assertTrue(validAdress.isEqual(validAdress));
	}

	@Test
	public void testIsValid(){
		EmailAddress address1 = new EmailAddress("address1@test.io");
		EmailAddress address2 = EmailAddress.getFromString("address2@test.io");

		assertTrue(address1.isValid());
		assertTrue(address2.isValid());
		assertFalse(EmailAddress.EMPTY.isValid());
	}

	@Test
	public void testIsEmpty(){
		EmailAddress address1 = new EmailAddress("address1@test.io");
		EmailAddress address2 = EmailAddress.getFromString("address2@test.io");

		assertFalse(address1.isEmpty());
		assertFalse(address2.isEmpty());
		assertTrue(EmailAddress.EMPTY.isEmpty());
	}

}

