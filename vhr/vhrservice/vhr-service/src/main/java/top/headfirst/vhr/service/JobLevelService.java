package top.headfirst.vhr.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import top.headfirst.vhr.mapper.JobLevelMapper;
import top.headfirst.vhr.model.JobLevel;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class JobLevelService {

    @Resource
    private JobLevelMapper jobLevelMapper;


    public List<JobLevel> getAllJobLevels() {
        return jobLevelMapper.getAllJobLevels();
    }

    public Integer addJobLevel(JobLevel jobLevel) {
        jobLevel.setCreateDate(new Date());
        jobLevel.setEnabled(true);
        return jobLevelMapper.insertSelective(jobLevel);
    }

    public Integer updateJobLevelById(JobLevel jobLevel) {
        return jobLevelMapper.updateByPrimaryKeySelective(jobLevel);
    }

    public Integer deleteJobLevelById(Integer id) {
        return jobLevelMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteJobLevelByIds(@Param("ids") Integer[] ids) {
        return jobLevelMapper.deleteJobLevelByIds(ids);
    }
}
