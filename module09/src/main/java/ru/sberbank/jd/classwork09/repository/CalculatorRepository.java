package ru.sberbank.jd.classwork09.repository;

import ru.sberbank.jd.classwork09.model.CalcResult;

public interface CalculatorRepository {

    CalcResult save(CalcResult calcResult);

}
