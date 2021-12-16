package util;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonMapper {
	private ObjectMapper objMap = new ObjectMapper();
	
	public <T> T jsonToPojo(HttpServletRequest request, Class clase) throws IOException{
        return (T) objMap.readValue(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())), clase);
    }
	
	public <T> String pojoToJson(T data) throws JsonProcessingException {
		return objMap.writerWithDefaultPrettyPrinter().writeValueAsString(data);
	}
}
