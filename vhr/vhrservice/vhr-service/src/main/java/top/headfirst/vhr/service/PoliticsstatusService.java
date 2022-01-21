package top.headfirst.vhr.service;

import org.springframework.stereotype.Service;
import top.headfirst.vhr.mapper.PoliticsstatusMapper;
import top.headfirst.vhr.model.Politicsstatus;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PoliticsstatusService {

    @Resource
    PoliticsstatusMapper politicsstatusMapper;

    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusMapper.getAllPoliticsstatus();
    }
}
