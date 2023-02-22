package com.hudingwen.springboot.quartz;

import com.hudingwen.springboot.service.ScheduleService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * ClassName:TestJob
 * Package:com.hudingwen.springboot.quartz
 * Description:描述
 * Date:2022-10-21 17:07:11
 * Author:胡丁文
 * E-mail:admin@aiwanyun.cn
 **/
@Component
public class TestJob  extends QuartzJobBean {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TestJob.class);
    @Autowired
    private ScheduleService scheduleService;
    public TestJob() {
        super();
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        Trigger trigger = context.getTrigger();
        JobDetail jobDetail = context.getJobDetail();
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        String data = jobDataMap.getString("data");
        log.info("获取定时任务数据：{}",data);

        // 获取文章的 ID后获取文章，更新文章为发布的状态，还有发布的时间
        boolean success = true;

        //完成后删除触发器和任务
        if (success) {
            log.info("定时任务执行成功，开始清除定时任务");
            Boolean isClean = scheduleService.cancelScheduleJob(trigger.getKey().getName());
            if(isClean)
                log.info("定时任务清理成功");
            else
                log.info("定时任务清理失败");
        }
    }
}
