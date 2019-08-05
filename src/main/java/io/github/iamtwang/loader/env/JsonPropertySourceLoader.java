package io.github.iamtwang.loader.env;

import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @author Tao
 */
public class JsonPropertySourceLoader implements PropertySourceLoader {
    @Override
    public String[] getFileExtensions() {
        return new String[]{"json"};
    }

    @Override
    public PropertySource<?> load(String name, Resource resource, String profile) throws IOException {
        Map<String, Object> result = mapPropertySource(resource);
        return new MapPropertySource(name, result);
    }

    private Map<String, Object> mapPropertySource(Resource resource) throws IOException {
        if (resource == null) {
            return null;
        }
        String sourceString = StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset());
        Map<String, Object> map = JsonParserFactory.getJsonParser().parseMap(sourceString);
        return map;
    }
}
