package ru.sberbank.jd.module11.service;

import ru.sberbank.jd.module11.controller.input.TaskInput;
import ru.sberbank.jd.module11.model.Task;

public class TaskServiceErrorImpl implements TaskService {
    @Override
    public String getInfo(String taskId) {
        throw new RuntimeException("Error TaskServiceErrorImpl");
    }

    @Override
    public Task createTask(TaskInput taskInput) {
        return null;
    }
}
