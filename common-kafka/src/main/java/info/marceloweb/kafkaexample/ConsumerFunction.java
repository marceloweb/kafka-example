package info.marceloweb.kafkaexample;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public interface ConsumerFunction<T> {
    void consume(ConsumerRecord<String,T> record) throws ExecutionException, InterruptedException, SQLException;
}
