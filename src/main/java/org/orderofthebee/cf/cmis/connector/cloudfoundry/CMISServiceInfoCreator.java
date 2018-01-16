package org.orderofthebee.cf.cmis.connector.cloudfoundry;

import java.util.Map;

import org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator;
import org.springframework.cloud.cloudfoundry.Tags;

public class CMISServiceInfoCreator extends CloudFoundryServiceInfoCreator<CMISServiceInfo>{

    public CMISServiceInfoCreator() {
        super(new Tags("cmis"));
    }
    
	@Override
	public CMISServiceInfo createServiceInfo(Map<String, Object> serviceData) {
		
        String id = (String) serviceData.get("name");
        
        @SuppressWarnings("unchecked") Map<String, Object> credentials = (Map<String, Object>) serviceData.get("credentials");
		String url = (String) credentials.get("url");
		String user = (String) credentials.get("user");
		String pass = (String) credentials.get("pass");
		
		return new CMISServiceInfo(id, url, user, pass);
		
	}
	
    @Override
    public boolean accept(Map<String, Object> serviceData) {
        String name = (String) serviceData.get("name");
        return name.startsWith("cmis");
    }	

}
