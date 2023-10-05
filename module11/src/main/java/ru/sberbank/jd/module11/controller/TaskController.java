package ru.sberbank.jd.module11.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.jd.module11.controller.input.TaskInput;
import ru.sberbank.jd.module11.model.Task;
import ru.sberbank.jd.module11.service.TaskService;

@RestController
@RequestMapping("/task")
@Slf4j
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final ObjectMapper objectMapper;

    @PostMapping
    public Task createTask(@RequestBody TaskInput taskInput) {
        log.debug("[createTask] taskInput={}", taskInput);
        Task task = taskService.createTask(taskInput);
        return task;
    }

    // http://localhost:8080/task/123
//    @GetMapping("/{id}")
//    public String getInfo(@PathVariable("id") String id) {
//        return id;
//    }

    // http://localhost:8080/task?taskId=value1
    @GetMapping
    public String getInfoParams(
            @RequestParam("taskId") String taskId,
            @RequestHeader("user-x") String headerUserX) {
        String result = new StringBuilder()
                .append("taskId=")
                .append(taskService.getInfo(taskId))
                .append("header user-x=")
                .append(headerUserX)
                .toString();
        return result;
    }

}
