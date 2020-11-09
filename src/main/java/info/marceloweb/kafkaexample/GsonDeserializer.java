package info.marceloweb.kafkaexample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class GsonDeserializer<T> implements Deserializer<T> {

    private final Gson gson = new GsonBuilder().create();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        String typeName = configs.get(TYPE_CONFIG);
    }

    @Override
    public T deserialize(String s, byte[] bytes) {
        return gson.fromJson(bytes, type);
    }
}
