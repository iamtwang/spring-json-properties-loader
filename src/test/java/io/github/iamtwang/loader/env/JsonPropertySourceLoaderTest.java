package io.github.iamtwang.loader.env;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Tao
 */
public class JsonPropertySourceLoaderTest {

    private JsonPropertySourceLoader jsonPropertySourceLoader;

    @Before
    public void setUp() {
        jsonPropertySourceLoader = new JsonPropertySourceLoader();
    }

    @Test
    public void getFileExtensions() {
        assertThat(jsonPropertySourceLoader.getFileExtensions(), is(new String[]{"json"}) );
    }

    @Test
    public void load_StandardJson() throws IOException {
        Map<String, Object> expected = mockStandardData();
        String json = createJson(expected);
        Resource resource = new ByteArrayResource(json.getBytes());
        PropertySource<?> result = jsonPropertySourceLoader.load("jsonMapTest", resource, "");
        assertThat(result.getSource(), is(expected));
    }

    @Test
    public void load_ComplexJson() throws IOException {
        Map<String, Object> expected = mockComplexData();
        String json = createJson(expected);
        Resource resource = new ByteArrayResource(json.getBytes());
        PropertySource<?> result = jsonPropertySourceLoader.load("jsonMapTest", resource, "");
        assertThat(result.getSource(), is(expected));
    }


    private String createJson(Map<String, Object> map) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(map);
        return json;
    }

    private Map<String, Object> mockComplexData() {
        Map<String, Object> info = new HashMap<>();
        info.put("info","info");
        info.put("value",3345);
        info.put("config", Arrays.asList(
                new HashMap<String,Object>(){{put("key-1", new HashMap<String ,String >());}},
                new HashMap<String,Object>(){{put("key-a", "abc");}},
                new HashMap<String,Object>(){{put("key-a", Arrays.asList("a","b","c"));}}
                ));
        Map<String, Object> expected = new HashMap<>();
        expected.put("io.github.iamtwang.config", info);
        return expected;
    }
    private Map<String, Object> mockStandardData(){
        Map<String, Object> expected = new HashMap<>();
        expected.put("name", "John");
        expected.put("age", 30);
        expected.put("cars", Arrays.asList("Ford", "BMW", "Fiat"));
        return expected;
    }
}