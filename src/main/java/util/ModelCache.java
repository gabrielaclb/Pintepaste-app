package util;

import java.util.HashMap;

import models.ModelClass;
import models.ResponseModel;
import models.SessionModel;
import models.UserModel;

public class ModelCache {
	private static ModelCache modelCache = new ModelCache();
	
	private HashMap<String, ModelClass> modelMap = new HashMap<String, ModelClass>();
	
	public <T> T getModel(String type) throws CloneNotSupportedException {
		return (T)modelMap.get(type).clone();
	}
	
	public static ModelCache getInstance() {
		return modelCache;
	}
	
	private ModelCache() {
		modelMap.put("User", new UserModel());
		modelMap.put("Response", new ResponseModel<>());
		modelMap.put("Session", new SessionModel());
	}
}
