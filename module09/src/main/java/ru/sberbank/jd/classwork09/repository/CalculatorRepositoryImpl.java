package ru.sberbank.jd.classwork09.repository;

import ru.sberbank.jd.classwork09.model.CalcResult;

import java.util.HashMap;
import java.util.Map;

public class CalculatorRepositoryImpl implements CalculatorRepository {
    private final Map<String, CalcResult> storage = new HashMap();
    @Override
    public CalcResult save(CalcResult calcResult) {
        return storage.put(calcResult.getId(), calcResult);
    }
}
