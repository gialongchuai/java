// StageManager.java
package com.example;

import com.example.Stage;
import com.example.StageTasks;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
@Slf4j
public class StageManager {

    private final ThreadPoolTaskExecutor initExecutor;
    private final ThreadPoolTaskExecutor processExecutor;
    private final ThreadPoolTaskExecutor completeExecutor;
    private final ThreadPoolTaskExecutor cancelExecutor;

    // Phương thức chính: bắt đầu workflow
    public <T> void startWorkflow(T data) {
        String stageId = UUID.randomUUID().toString().substring(0, 8);
        Stage<T> stage = new Stage<>(stageId, data);

        log.info("🚀 Bắt đầu workflow cho stage: {}", stageId);

        // BƯỚC 1: Init → BƯỚC 2: Process → BƯỚC 3: Complete
        CompletableFuture<Void> future =
                CompletableFuture.runAsync(() -> StageTasks.initStage(stage), initExecutor)
                        .thenRunAsync(() -> StageTasks.processStage(stage), processExecutor)
                        .thenRunAsync(() -> StageTasks.completeStage(stage), completeExecutor);

        // Nếu có lỗi ở bất kỳ bước nào → hủy
        future.exceptionally(throwable -> {
            log.error("💥 Lỗi trong workflow: {}", throwable.getMessage());
            StageTasks.cancelStage(stage); // Chạy trên thread hiện tại (hoặc submit vào cancelExecutor nếu muốn)
            return null;
        });

        // KHÔNG DÙNG .join() ở đây vì nó sẽ block thread chính!
        // Trong ứng dụng web, bạn thường để nó chạy nền.
    }
}