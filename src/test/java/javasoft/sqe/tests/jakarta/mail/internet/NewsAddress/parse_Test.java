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

package javasoft.sqe.tests.jakarta.mail.internet.NewsAddress;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.*;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import com.sun.javatest.*;
import javasoft.sqe.tests.jakarta.mail.util.MailTest;

/**
 * This class tests the <strong>parse()</strong> API.
 * It does by passing various valid input values and then checking
 * the type of the returned object.	<p>
 *
 *	Parse the given comma separated sequence of newsgroup into NewsAddress objects. <p>
 * api2test: public NewsAddress[] parse(String)  <p>
 *
 * how2test: Call API with string argument, verify returned object type to be
 *           NewsAddress[], if so then testcase passes, otherwise it fails.
 */

public class parse_Test extends MailTest {

    @org.junit.jupiter.api.Test
    public void test() {
        Status s = run(System.err, System.out);
        assertEquals(Status.PASSED, s.getType(), "Status " + s);
    }

    public Status run(PrintWriter log, PrintWriter out)
    {
    super.run(log, out);

        out.println("\nTesting class NewsAddress: parse(String)\n");

        try {
	   // Construct a NewsAddress object
	      NewsAddress na = new NewsAddress();

	      if( na == null ) {
		  return Status.failed("Failed to create newsgroup object!");
	      }
	   // BEGIN UNIT TEST 1:
              out.println("UNIT TEST 1:  parse("+pattern+")");

	      NewsAddress[] nalist = na.parse(pattern); 	// API TEST
	      boolean ngFound = false;

	      for( int k = 0; k < nalist.length; k++ ) {
                   if( nalist[k] != null ) {
		       out.println("Newsgroup name is "+ nalist[k].getNewsgroup());
		       ngFound = true;
		   }
	      }
	      if( ngFound )
                  out.println("UNIT TEST 1: passed");
              else {
                    out.println("UNIT TEST 1: FAILED");
                    errors++;
              }
           // END UNIT TEST 1:
              checkStatus();

        } catch ( Exception e ) {
	      handlException(e);
        }
	return status;
     }
}