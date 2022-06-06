package com.yumumu.shardingjdbclearning.ship.service;

import com.yumumu.shardingjdbclearning.ship.dao.ShipEquipmentMapper;
import com.yumumu.shardingjdbclearning.ship.dao.ShipMapper;
import com.yumumu.shardingjdbclearning.ship.dao.ShipProfileMapper;
import com.yumumu.shardingjdbclearning.ship.model.po.ShipEquipmentPo;
import com.yumumu.shardingjdbclearning.ship.model.po.ShipPo;
import com.yumumu.shardingjdbclearning.ship.model.po.ShipProfilePo;
import com.yumumu.shardingjdbclearning.ship.model.vo.ShipEquipment;
import com.yumumu.shardingjdbclearning.ship.model.vo.ShipInfo;
import com.yumumu.shardingjdbclearning.ship.model.vo.ShipProfile;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghailin
 * @date 2022/6/2
 */
@Service
public class ShipService {

    @Resource
    private ShipMapper shipMapper;
    @Resource
    private ShipEquipmentMapper shipEquipmentMapper;
    @Resource
    private ShipProfileMapper shipProfileMapper;

    public ShipInfo getShipProfile(Long shipId) {
        ShipPo shipPo = shipMapper.selectById(shipId);
        ShipInfo shipInfo = new ShipInfo();
        BeanUtils.copyProperties(shipPo, shipInfo);
        List<ShipEquipmentPo> shipEquipmentPos = shipEquipmentMapper.selectByShipId(shipId);
        List<ShipEquipment> shipEquipmentList = new ArrayList<>();
        shipEquipmentPos.forEach(e->{
            ShipEquipment shipEquipment = new ShipEquipment();
            BeanUtils.copyProperties(e, shipEquipment);
            shipEquipmentList.add(shipEquipment);
        });
        shipInfo.setShipEquipments(shipEquipmentList);
        return shipInfo;
    }

    public void createShip(ShipInfo shipInfo) {
        ShipPo shipPo = new ShipPo();
        BeanUtils.copyProperties(shipInfo, shipPo);
        shipMapper.insert(shipPo);
        ShipProfilePo shipProfilePo = new ShipProfilePo();
        shipProfilePo.setDefeat(0);
        shipProfilePo.setLevel(1);
        shipProfilePo.setVictory(0);
        shipProfilePo.setDescription("战舰诞生");
        shipProfilePo.setShipId(shipPo.getShipId());
        shipProfilePo.setUserId(shipPo.getUserId());
        shipProfileMapper.insert(shipProfilePo);
    }

    public ShipInfo getShipInfo(Long shipId) {
        ShipPo shipPo = shipMapper.selectById(shipId);
        ShipProfilePo shipProfilePo = shipProfileMapper.selectProfileByShipId(shipId);
        ShipInfo shipInfo = new ShipInfo();
        shipInfo.setShipId(shipPo.getShipId());
        shipInfo.setShipName(shipPo.getShipName());
        shipInfo.setStatus(shipPo.getStatus());
        shipInfo.setUserId(shipPo.getUserId());
        shipInfo.setType(shipPo.getType());
        ShipProfile shipProfile = new ShipProfile();
        BeanUtils.copyProperties(shipProfilePo, shipProfile);
        shipInfo.setShipProfile(shipProfile);
        return shipInfo;
    }

    public void arm(List<ShipEquipment> shipEquipmentList) {
        shipEquipmentList.forEach(e->{
            ShipEquipmentPo shipEquipmentPo = new ShipEquipmentPo();
            BeanUtils.copyProperties(e, shipEquipmentPo);
            shipEquipmentMapper.insert(shipEquipmentPo);
        });
    }
}
