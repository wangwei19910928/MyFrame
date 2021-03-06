package com.vv.base.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;
public class CustomObjectMapper extends ObjectMapper {  
	  
    public CustomObjectMapper(){  
        CustomSerializerFactory factory = new CustomSerializerFactory();  
        
        factory.addGenericMapping(Date.class, new JsonSerializer<Date>(){  
            @Override  
            public void serialize(Date value,   
                    JsonGenerator jsonGenerator,   
                    SerializerProvider provider)  
                    throws IOException, JsonProcessingException { 
            	/**
            	 * 返回的是String 类型
            	 */
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            	//Unix时间戳
            	//long unixtime = value.getTime()/1000;
            	//String StringUnixtime = String.valueOf(unixtime);
                jsonGenerator.writeString(sdf.format(value));  
            }  
        }); 
        this.setSerializerFactory(factory); 
        //返回结果如果是NULL 就返回“”
        this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>(){

			@Override
			public void serialize(Object arg0, JsonGenerator jsonGenerator,
					SerializerProvider arg2) throws IOException,
					JsonProcessingException {
				jsonGenerator.writeString("");
			}
        	
        });
    }  

}  
