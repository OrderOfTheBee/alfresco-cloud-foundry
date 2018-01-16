package org.orderofthebee.cf.cmis.connector.spring;

import java.util.HashMap;
import java.util.Map;

import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.enums.BindingType;
import org.orderofthebee.cf.cmis.connector.cloudfoundry.CMISServiceInfo;
import org.springframework.cloud.service.AbstractServiceConnectorCreator;
import org.springframework.cloud.service.ServiceConnectorConfig;

public class CMISServiceConnectorCreator extends AbstractServiceConnectorCreator<Session, CMISServiceInfo> {

	@Override
	public Session create(CMISServiceInfo serviceInfo, ServiceConnectorConfig serviceConnectorConfig) {

		// default factory implementation
		SessionFactory factory = SessionFactoryImpl.newInstance();
		Map<String, String> parameter = new HashMap<String, String>();

		// user credentials
		parameter.put(SessionParameter.USER, serviceInfo.getUser());
		parameter.put(SessionParameter.PASSWORD, serviceInfo.getPass());

		// connection settings
		parameter.put(SessionParameter.BROWSER_URL, serviceInfo.getUrl());
		parameter.put(SessionParameter.BINDING_TYPE, BindingType.BROWSER.value());
		parameter.put(SessionParameter.REPOSITORY_ID, "-default-");

		// create session
		Session session = factory.createSession(parameter);
		return session;
	}

}
