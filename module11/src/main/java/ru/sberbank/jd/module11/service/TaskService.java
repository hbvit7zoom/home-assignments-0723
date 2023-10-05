package ru.sberbank.jd.module11.service;

import ru.sberbank.jd.module11.controller.input.TaskInput;
import ru.sberbank.jd.module11.model.Task;

public interface TaskService {

    String getInfo(String taskId);

    Task createTask(TaskInput taskInput);
}
