// StageTasks.java (gộp gọn cho dễ đọc)
package com.example;

import com.example.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StageTasks {

    // BƯỚC 1: Khởi tạo
    public static <T> void initStage(Stage<T> stage) {
        log.info("🔄 [INIT] Bắt đầu khởi tạo stage: {}", stage.getId());
        try {
            Thread.sleep(1000); // Giả lập tốn thời gian
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        stage.setStatus("Initialized");
        log.info("✅ [INIT] Hoàn thành khởi tạo stage: {}", stage.getId());
    }

    // BƯỚC 2: Xử lý chính
    public static <T> void processStage(Stage<T> stage) {
        log.info("🔄 [PROCESS] Bắt đầu xử lý stage: {}", stage.getId());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        stage.setStatus("Processed");
        log.info("✅ [PROCESS] Hoàn thành xử lý stage: {}", stage.getId());
    }

    // BƯỚC 3: Hoàn tất
    public static <T> void completeStage(Stage<T> stage) {
        log.info("🔄 [COMPLETE] Bắt đầu hoàn tất stage: {}", stage.getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        stage.setStatus("Completed");
        log.info("✅ [COMPLETE] Hoàn thành hoàn tất stage: {}", stage.getId());
    }

    // BƯỚC HỦY: Khi có lỗi
    public static <T> void cancelStage(Stage<T> stage) {
        log.info("⚠️ [CANCEL] Đang hủy stage do lỗi: {}", stage.getId());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        stage.setStatus("Cancelled");
        log.info("❌ [CANCEL] Đã hủy stage: {}", stage.getId());
    }
}