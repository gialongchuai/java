// Main.java
package com.example;

import com.example.StageManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws InterruptedException {
//        BootApplication started...
//
//  .   ____          _            __ _ _
//                /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
//( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
// \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
//        '  |____| .__|_| |_|_| |_\__, | / / / /
//                =========|_|==============|___/=/_/_/_/
// :: Spring Boot ::                (v3.2.5)
//
//        INFO  10:36:04.285 [main]  com.example.Main - No active profile set, falling back to 1 default profile: "default"
//        INFO  10:36:05.089 [main]  com.example.Main - Started Main in 1.282 seconds (process running for 1.874)
//        INFO  10:36:05.161 [main]  com.example.StageManager - 🚀 Bắt đầu workflow cho stage: 6cd9b58c
//        INFO  10:36:05.166 [init-worker-1]  com.example.StageTasks - 🔄 [INIT] Bắt đầu khởi tạo stage: 6cd9b58c
//        INFO  10:36:05.167 [main]  com.example.StageManager - 🚀 Bắt đầu workflow cho stage: d15db96b
//        Hello universe!
//        INFO  10:36:06.172 [init-worker-1]  com.example.StageTasks - ✅ [INIT] Hoàn thành khởi tạo stage: 6cd9b58c
//        INFO  10:36:06.173 [init-worker-1]  com.example.StageTasks - 🔄 [INIT] Bắt đầu khởi tạo stage: d15db96b
//        INFO  10:36:06.173 [process-worker-1]  com.example.StageTasks - 🔄 [PROCESS] Bắt đầu xử lý stage: 6cd9b58c
//        INFO  10:36:07.173 [init-worker-1]  com.example.StageTasks - ✅ [INIT] Hoàn thành khởi tạo stage: d15db96b
//        INFO  10:36:07.174 [process-worker-2]  com.example.StageTasks - 🔄 [PROCESS] Bắt đầu xử lý stage: d15db96b
//        INFO  10:36:07.688 [process-worker-1]  com.example.StageTasks - ✅ [PROCESS] Hoàn thành xử lý stage: 6cd9b58c
//        INFO  10:36:07.689 [complete-worker-1]  com.example.StageTasks - 🔄 [COMPLETE] Bắt đầu hoàn tất stage: 6cd9b58c
//        INFO  10:36:08.687 [process-worker-2]  com.example.StageTasks - ✅ [PROCESS] Hoàn thành xử lý stage: d15db96b
//        INFO  10:36:08.703 [complete-worker-1]  com.example.StageTasks - ✅ [COMPLETE] Hoàn thành hoàn tất stage: 6cd9b58c
//        INFO  10:36:08.703 [complete-worker-1]  com.example.StageTasks - 🔄 [COMPLETE] Bắt đầu hoàn tất stage: d15db96b
//        INFO  10:36:09.717 [complete-worker-1]  com.example.StageTasks - ✅ [COMPLETE] Hoàn thành hoàn tất stage: d15db96b
//        Hello galaxy!

        System.out.println("BootApplication started...");

        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        StageManager stageManager = context.getBean(StageManager.class);

        // Bắt đầu 1 workflow
        stageManager.startWorkflow("Order 01!");
        stageManager.startWorkflow("Order 02!");


        System.out.println("Hello universe!");

        // Đợi đủ lâu để các task chạy xong (vì chúng chạy nền!)
        Thread.sleep(5000);

        System.out.println("Hello galaxy!");

        // In trạng thái thread pool
        StageManager sm = context.getBean(StageManager.class);
        // (Bạn có thể thêm phương thức in info nếu muốn)

        context.close(); // Đóng ứng dụng Spring
    }
}