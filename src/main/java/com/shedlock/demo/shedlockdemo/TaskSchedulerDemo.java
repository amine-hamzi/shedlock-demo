package com.shedlock.demo.shedlockdemo;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
class TaskSchedulerDemo {

    @Scheduled(cron = "0/1 * * * * *")
    @SchedulerLock(name = "TaskScheduler_scheduledTask",
            lockAtLeastFor = "PT3M", lockAtMostFor = "PT4M")
    public void scheduledTask() throws InterruptedException {
        log.info("*****************************NOT DONE*************************  {}", new Date());
        Thread.sleep(20000L);
        log.info("*****************************DONE*************************  {}", new Date());
    }
}
