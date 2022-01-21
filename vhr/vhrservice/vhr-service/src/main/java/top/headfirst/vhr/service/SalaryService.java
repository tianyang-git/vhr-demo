package top.headfirst.vhr.service;

import org.springframework.stereotype.Service;
import top.headfirst.vhr.mapper.SalaryMapper;
import top.headfirst.vhr.model.Salary;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SalaryService {

    @Resource
    SalaryMapper salaryMapper;

    public List<Salary> getAllSalaries() {
        return salaryMapper.getAllSalaries();
    }

    public Integer addSalary(Salary salary) {
        salary.setCreateDate(new Date());
        return salaryMapper.insertSelective(salary);
    }

    public Integer deleteSalaryById(Integer id) {
        return salaryMapper.deleteByPrimaryKey(id);
    }

    public Integer updateSalaryById(Salary salary) {
        return salaryMapper.updateByPrimaryKeySelective(salary);
    }
}
