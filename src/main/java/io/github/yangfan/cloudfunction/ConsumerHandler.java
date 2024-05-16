package io.github.yangfan.cloudfunction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Consumer;

@Component
@Slf4j
public class ConsumerHandler implements Consumer<Map<String, Object>> {
    @Override
    public void accept(Map<String, Object> input) {
        input.forEach((k, v) -> log.info("{}: {}", k, v));
    }
}
