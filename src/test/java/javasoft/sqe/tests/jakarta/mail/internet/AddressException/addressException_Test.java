/*
 * Copyright (c) 2002, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package javasoft.sqe.tests.jakarta.mail.internet.AddressException;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.*;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import com.sun.javatest.*;
import javasoft.sqe.tests.jakarta.mail.util.MailTest;

/**
 * This class tests the <strong>AddressException()</strong> API.
 * It does this by passing various valid input values and then checking
 * the type of the returned object.	<p>
 *
 * api2test: public AddressException(String) <p>
 *
 * how2test: Call this InternetAddress API with invalid address string and if
 *	     this results in an address exception, then this testcase passes.
 */

public class addressException_Test extends MailTest {

    @org.junit.jupiter.api.Test
    public void test() {
        Status s = run(System.err, System.out);
        assertEquals(Status.PASSED, s.getType(), "Status " + s);
    }

    public Status run(PrintWriter log, PrintWriter out)
    {
	super.run(log, out);

        out.println("\nTesting class AddressException: AddressException(String)\n");

        try {
           // BEGIN UNIT TEST 1:
              out.println("UNIT TEST 1: AddressException("+ to +")");

              InternetAddress addr = new InternetAddress(to);	    // API TEST

              if( addr != null ) {
                  out.println("UNIT TEST 1: FAILED.\n");
                  errors++;
              }
           // END UNIT TEST 1:

	      status = Status.failed("Failed to catch AddressException ");
        } catch ( AddressException e ) {
		out.println("UNIT TEST 1: passed.\n");
		ExceptionTest(e);
        }
	return status;
     }
}