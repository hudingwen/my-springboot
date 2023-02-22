package com.hudingwen.springboot.service;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * ClassName:ScheduleService
 * Package:com.hudingwen.springboot.service
 * Description:描述
 * Date:2022-10-21 16:59:53
 * Author:胡丁文
 * E-mail:admin@aiwanyun.cn
 **/
@Service
public class ScheduleService {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ScheduleService.class);
    private String defaultGroup = "default_group";

    @Autowired
    private Scheduler scheduler;
    public String scheduleJob(Class<? extends Job> jobBeanClass, String cron, String data) {
        String jobName = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        JobDetail jobDetail = JobBuilder.newJob(jobBeanClass)
                .withIdentity(jobName, defaultGroup)
                .usingJobData("data", data)
                .build();
        //创建触发器，指定任务执行时间
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity(jobName, defaultGroup)
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();
        // 调度器进行任务调度
        try {
            scheduler.scheduleJob(jobDetail, cronTrigger);
        } catch (SchedulerException e) {
            log.error("任务调度执行失败{}", e.getMessage());
        }
        return jobName;
    }
    public String scheduleFixTimeJob(Class<? extends Job> jobBeanClass, String cron, String data) {
        //日期转CRON表达式
        return scheduleJob(jobBeanClass, cron, data);
    }
    public Boolean cancelScheduleJob(String jobName) {
        boolean success = false;
        try {
            // 暂停触发器
            scheduler.pauseTrigger(new TriggerKey(jobName, defaultGroup));
            // 移除触发器中的任务
            scheduler.unscheduleJob(new TriggerKey(jobName, defaultGroup));
            // 删除任务
            scheduler.deleteJob(new JobKey(jobName, defaultGroup));
            success = true;
        } catch (SchedulerException e) {
            log.error("任务取消失败{}", e.getMessage());
        }
        return success;
    }
}
