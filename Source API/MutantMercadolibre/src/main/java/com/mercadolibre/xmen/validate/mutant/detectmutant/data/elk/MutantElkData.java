package com.mercadolibre.xmen.validate.mutant.detectmutant.data.elk;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mercadolibre.xmen.validate.mutant.detectmutant.data.IMutantData;
import com.mercadolibre.xmen.validate.mutant.detectmutant.model.HumanDataJson;
import com.mercadolibre.xmen.validate.mutant.detectmutant.model.Parameters;
import com.mercadolibre.xmen.validate.mutant.detectmutant.model.Stats;
import com.mercadolibre.xmen.validate.mutant.detectmutant.util.OkHttpUtil;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MutantElkData implements IMutantData {

	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	
	@Override
	public String save(String dna, boolean isMutant) throws Exception {
		HumanDataJson result = new HumanDataJson(dna, isMutant);
		
		OkHttpUtil.init(true);
		
		OkHttpClient client = OkHttpUtil.getClient();
		
		Gson gson = new Gson();
		
		
		RequestBody body = RequestBody.create(JSON, gson.toJson(result));
		
		Request request = new Request.Builder()
		  .url(Parameters.getENDPOINT_ELK())
		  .post(body)
		  .addHeader("Cache-Control", "no-cache")
		  .build();

		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	@Override
	public Stats result() throws Exception {
		int mutant = countHuman(true);
		int human =  countHuman(false);
		double ratio = Math.round((mutant / human) * 100.0) / 100.0;
		
		Stats stats = new Stats(mutant, human, ratio);
		
		return stats;
	}
	
	private int countHuman(boolean isMutant) throws Exception {
		OkHttpUtil.init(true);
		
		OkHttpClient client = OkHttpUtil.getClient();
				
		Request request = new Request.Builder()
		  .url(Parameters.getENDPOINT_ELK() + "/_count?q=isMutant:" + isMutant)
		  .get()
		  .addHeader("Cache-Control", "no-cache")
		  .build();

		Response response = client.newCall(request).execute();
		
		JsonParser parser = new JsonParser();
		JsonObject jsonMain = parser.parse(response.body().string()).getAsJsonObject();
		
		int count = jsonMain.get("count").getAsInt();
		
		return count;
	}

}
