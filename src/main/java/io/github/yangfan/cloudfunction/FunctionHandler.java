package io.github.yangfan.cloudfunction;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.function.Function;

@Slf4j
public class FunctionHandler implements Function<Map<String, Object>, String> {

    @Override
    public String apply(Map<String, Object> input) {
        return "heya";
    }
}
