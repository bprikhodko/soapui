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

package com.eviware.soapui.security.check.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import com.eviware.soapui.impl.wsdl.teststeps.assertions.TestAssertionRegistry;
import com.eviware.soapui.model.testsuite.Assertable;
import com.eviware.soapui.model.testsuite.TestAssertion;
import com.eviware.soapui.security.Securable;
import com.eviware.soapui.security.check.SecurityCheck;
import com.eviware.soapui.security.registry.SecurityCheckRegistry;
import com.eviware.soapui.support.UISupport;

/**
 * Adds a WsdlAssertion to a WsdlTestRequest
 * 
 * @author Ole.Matzura
 */

public class AddSecurityCheckAction extends AbstractAction
{
	private final Securable securable;

	public AddSecurityCheckAction( Securable securable )
	{
		super( "Add SecurityCheck" );
		this.securable = securable;

		putValue( Action.SHORT_DESCRIPTION, "Adds a security check to this item" );
		putValue( Action.SMALL_ICON, UISupport.createImageIcon( "/addSecurityCheck.gif" ) );
	}

	public void actionPerformed( ActionEvent e )
	{
		String[] assertions = SecurityCheckRegistry.getInstance().getAvailableSecurityChecksNames( securable );

		if( assertions == null || assertions.length == 0 )
		{
			UISupport.showErrorMessage( "No assertions available for this message" );
			return;
		}

		String selection = ( String )UISupport.prompt( "Select assertion to add", "Select Assertion", assertions );
		if( selection == null )
			return;

		// if( !TestAssertionRegistry.getInstance().canAddMultipleAssertions(
		// selection, securable ) )
		// {
		// UISupport.showErrorMessage( "This assertion can only be added once" );
		// return;
		// }

		SecurityCheck securityCheck = securable.addSecurityCheck( selection );
		if( securityCheck == null )
		{
			UISupport.showErrorMessage( "Failed to add security check" );
			return;
		}

		// if( securityCheck.isConfigurable() )
		{
			securityCheck.configure();
		}
	}
}
