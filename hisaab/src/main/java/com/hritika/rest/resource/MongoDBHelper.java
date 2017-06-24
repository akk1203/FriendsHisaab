package com.hritika.rest.resource;

import java.util.UUID;

import com.hritika.model.InvocationOutcome;
import com.hritika.model.Response;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class MongoDBHelper {
	
	private static String _id = "_id";
	
	public DBObject convertToDBObject(String json) throws Exception{
		DBObject dbObject = null;
		try{
			dbObject = (DBObject)JSON.parse(json);
		}catch(Exception ex){
			throw new Exception("Validation failed for incoming request");
		}
		return dbObject;
	}
	
	public void enrichIdValue(DBObject dbObject){
		if(dbObject.get(_id) == null){
			dbObject.put(_id, UUID.randomUUID().toString());
		}
	}

	public DBObject getIdRequest(DBObject json){
		DBObject db = new BasicDBObject();
		db.put(_id, json.get(_id));
		return db;
	}
	
	public Response prepareResponse(String code, String message, String _id){
		Response resp = new Response();
		InvocationOutcome outcome = new InvocationOutcome();
		outcome.setCode(code);
		outcome.setMessage(message);
		resp.setInvocationOutcome(outcome);
		if(_id != null){
			resp.set_id(_id);
		}
		return resp;
	}
}
