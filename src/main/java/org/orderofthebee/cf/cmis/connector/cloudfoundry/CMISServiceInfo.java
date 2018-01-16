package org.orderofthebee.cf.cmis.connector.cloudfoundry;

import org.springframework.cloud.service.BaseServiceInfo;

public class CMISServiceInfo extends BaseServiceInfo {
	
	private String url;
	private String user;
	private String pass;

	public CMISServiceInfo(String id, String url, String user, String pass) {
		super(id);
		this.url=url;
		this.user=user;
		this.pass=pass;
	}

    @ServiceProperty
	public String getUrl() {
		return url;
	}

    @ServiceProperty
	public String getUser() {
		return user;
	}

    @ServiceProperty
	public String getPass() {
		return pass;
	}

}
