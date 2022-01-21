package top.headfirst.vhr.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import top.headfirst.vhr.mapper.PositionMapper;
import top.headfirst.vhr.model.Position;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class PositionService {

    @Resource
    private PositionMapper positionMapper;

    public List<Position> getAllPositions() {
        return positionMapper.getAllPositions();
    }

    public Integer addPosition(Position position) {
        position.setCreateDate(new Date());
        position.setEnabled(true);
        return positionMapper.insertSelective(position);
    }

    public Integer updatePosition(Position position) {
        return positionMapper.updateByPrimaryKeySelective(position);
    }

    public Integer deletePositionById(Integer id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    public Integer deletePositionByIds(@Param("ids") Integer[] ids) {
        return positionMapper.deletePositionsByIds(ids);
    }
}
