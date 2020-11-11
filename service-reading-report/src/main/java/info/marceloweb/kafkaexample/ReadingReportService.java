package info.marceloweb.kafkaexample;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Map;
import java.util.Properties;

public class ReadingReportService {

    public static void main(String[] args) {
        var reportService = new ReadingReportService();
        try (var service = new KafkaService<>(ReadingReportService.class.getSimpleName(),
                "USER_GENERATE_READING_REPORT",
                reportService::parse,
                User.class,
                Map.of())) {
            service.run();
        }
    }

    private void parse(ConsumerRecord<String, User> record) {
        System.out.println("-----------------------------");
        System.out.println("Processing new order, checking for fraud");
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());
    }

}
