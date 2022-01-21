package top.headfirst.vhr.task;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.headfirst.vhr.model.Employee;
import top.headfirst.vhr.model.MailConstants;
import top.headfirst.vhr.model.MailSendLog;
import top.headfirst.vhr.service.EmployeeService;
import top.headfirst.vhr.service.MailSendLogService;

import java.util.Date;
import java.util.List;

@Component
public class MailSendTask {
    @Autowired
    MailSendLogService mailSendLogService;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    EmployeeService employeeService;

    public void mailResendTask() {
        List<MailSendLog> logs = mailSendLogService.getMailSendLogsByStatus();
        if (logs == null || logs.size() == 0) {
            return;
        }
        logs.forEach(mailSendLog -> {
            if (mailSendLog.getCount() >= 3) {
                //直接设置该条消息发送失败
                mailSendLogService.updateMailSendLogStatus(mailSendLog.getMsgId(), 2);
            } else {
                mailSendLogService.updateCount(mailSendLog.getMsgId(), new Date());
                Employee emp = employeeService.getEmployeeById(mailSendLog.getEmpId());
                rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME, MailConstants.MAIL_ROUTING_KEY_NAME,
                        emp, new CorrelationData(mailSendLog.getMsgId()));
            }
        });
    }
}
