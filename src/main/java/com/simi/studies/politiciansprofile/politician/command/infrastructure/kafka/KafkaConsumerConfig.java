package com.simi.studies.politiciansprofile.politician.command.infrastructure.kafka;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.simi.studies.politiciansprofile.politician.command.domain.Command;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import java.util.HashMap;
import java.util.Map;

@Configuration
class KafkaConsumerConfig {

  @Value("${spring.kafka.bootstrap-servers}")
  private String bootstrapServers;

  @Bean
  public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Command>> kafkaListenerContainerFactory() {
    final var containerFactory = new ConcurrentKafkaListenerContainerFactory<String, Command>();
    containerFactory.setConsumerFactory(consumerFactory());
    return containerFactory;
  }

  @Bean
  public ConsumerFactory<String, Command> consumerFactory() {
    return new DefaultKafkaConsumerFactory<>(
        consumerConfigs(),
        new StringDeserializer(),
        new JsonDeserializer<>(Command.class));
  }

  @Bean
  public Map<String, Object> consumerConfigs() {
    final var properties = new HashMap<String, Object>();
    properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    properties.put(ConsumerConfig.GROUP_ID_CONFIG, "politiciansService");
    properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    return properties;
  }

}
