package common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParseException;


/**
 * 
 * @author zzc
 *
 */
public class JsonEntity {

	private JsonNode entity = null;

	/**
	 * 
	 * @param Json
	 */
	public JsonEntity(String Json) {
		ObjectMapper mapper1 = new ObjectMapper();
		try {
			entity = mapper1.readTree(Json);
		} catch (Exception e3) {
			e3.printStackTrace();
		}
	}

	/**
	 * get Tjson node from lists by index
	 * 
	 * @param index
	 * @return
	 */
	public JsonEntity get(int index) {
		JsonNode a = entity.get(index);
		return new JsonEntity(a.toString());
	}

	/**
	 * get Tjson node by attribute name
	 * 
	 * @param name
	 * @return
	 */
	public JsonEntity get(String name) {
		JsonNode a = entity.get(name);

		return new JsonEntity(a.toString());
	}

	public boolean hasNode(String name) {
		if (entity.get(name) != null) {
			return true;
		}
		return false;

	}

	public int size() {
		return entity.size();
	}

	/**
	 * system.out.print Tjson to string
	 */
	public void show() {
		System.out.println(entity.toString());
	}

	@Override
	public String toString() {
		String re = entity.toString();

		if (re.startsWith("\"") && re.endsWith("\"")) {
			re = re.substring(1, re.length() - 1);
		}

		return re;
	}

	public Integer toInteger() {
		String re = entity.toString();

		if (re.startsWith("\"") && re.endsWith("\"")) {
			re = re.substring(1, re.length() - 1);
		}

		return Integer.valueOf(re);
	}

	public Double toDouble() {
		String re = entity.toString();

		if (re.startsWith("\"") && re.endsWith("\"")) {
			re = re.substring(1, re.length() - 1);
		}

		return Double.valueOf(re);
	}

	/**
	 * get URLEncoderString
	 * 
	 * @return
	 */
	public String URLEncoderString() {
		String re = null;
		try {
			re = URLEncoder.encode(entity.toString().replace("\"", ""), "UTF-8");
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		return re;
	}

	/**
	 * Map<String, Object> convert to String
	 * 
	 * @param a
	 * @return
	 */
	public static String ConvertJson(Object a) {
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(a);
		} catch (JsonGenerationException e) {

			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return json;
	}

	public static <T> T JsonToBean(String jsonStr, Class<?> beanClass) {

		ObjectMapper objectMapper = new ObjectMapper();

		try {

			@SuppressWarnings("unchecked")
			T readValue = (T) objectMapper.readValue(jsonStr, beanClass);
			return readValue;

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Map<String, Object> JsonToMap(String jsonStr) {
		try {

			ObjectMapper mapper = new ObjectMapper();

			Map<String, Object> a = new HashMap<String, Object>();

			// convert JSON string to Map
			@SuppressWarnings("unchecked")
			Map<String, Object> map = mapper.readValue(jsonStr, a.getClass());

			return map;

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		String Json = "[{\"a\":\"1\"},{\"b\":\"2\"}]";
		JsonEntity t = new JsonEntity(Json);
		System.out.println(t.toString());
		System.out.println(t.get(1).get("b").toString());

	}

}
