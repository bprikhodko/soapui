/*
 *  soapUI, copyright (C) 2004-2010 eviware.com 
 *
 *  soapUI is free software; you can redistribute it and/or modify it under the 
 *  terms of version 2.1 of the GNU Lesser General Public License as published by 
 *  the Free Software Foundation.
 *
 *  soapUI is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without 
 *  even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 *  See the GNU Lesser General Public License for more details at gnu.org.
 */

package com.eviware.soapui.security;

import com.eviware.soapui.security.check.SecurityCheck;

/**
 * Listener for security check events
 * 
 * @author dragica.soldo
 */

public interface SecurityChecksListener
{
	public void securityCheckAdded( SecurityCheck securityCheck );

	public void securityCheckRemoved( SecurityCheck securityCheck );

	public void securityCheckMoved( SecurityCheck securityCheck, int ix, int offset );
}