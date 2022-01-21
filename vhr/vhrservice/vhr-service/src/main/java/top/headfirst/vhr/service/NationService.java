package top.headfirst.vhr.service;

import org.springframework.stereotype.Service;
import top.headfirst.vhr.mapper.NationMapper;
import top.headfirst.vhr.model.Nation;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NationService {

    @Resource
    NationMapper nationMapper;

    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }
}
