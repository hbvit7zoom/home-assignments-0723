package ru.sberbank.jd.module11.service;

import ru.sberbank.jd.module11.controller.input.TaskInput;
import ru.sberbank.jd.module11.model.Task;

public class TaskServiceImpl implements TaskService {
    @Override
    public String getInfo(String taskId) {
        return taskId;
    }

    @Override
    public Task createTask(TaskInput taskInput) {
        return Task.of(taskInput);
    }
}
