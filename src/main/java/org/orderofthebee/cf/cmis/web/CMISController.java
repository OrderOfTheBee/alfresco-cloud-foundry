package org.orderofthebee.cf.cmis.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.commons.enums.BaseTypeId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CMISController {
	
	@Autowired
	Session session;
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String repositoryInformation() {
    	    return session.getRepositoryInfo().toString();
    }

    @RequestMapping(value = "/{objectId}/children", method = RequestMethod.GET)
    @ResponseBody
    public List<Child> getChildren(@PathVariable String objectId) {
    	    List<Child> children = new ArrayList<Child>();
    	    CmisObject object = session.getObject(objectId);
    	    if (object.getBaseTypeId() == BaseTypeId.CMIS_FOLDER) {
    	    	   Folder folder = (Folder) object;
    	    	   for (CmisObject child : folder.getChildren().getPage(50)) {
    	    		   if (child.getName().toLowerCase().endsWith(".pdf")) {
    	    		       children.add(new Child(child.getName()));
    	    		   }
    	    	   }
    	    }
    	    return children;
    }
    
    class Child {
    	    private String name;
    	    public Child(String name) {
    	    	    this.name = name;
    	    }
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
    }
    
}
