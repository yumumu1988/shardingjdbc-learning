package com.yumumu.shardingjdbclearning.ship.controller;

import com.yumumu.shardingjdbclearning.common.model.ResultData;
import com.yumumu.shardingjdbclearning.ship.model.vo.ShipEquipment;
import com.yumumu.shardingjdbclearning.ship.model.vo.ShipInfo;
import com.yumumu.shardingjdbclearning.ship.service.ShipService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhanghailin
 * @date 2022/6/2
 */
@RestController
@RequestMapping("/ship")
public class ShipController {

    @Resource
    private ShipService shipService;

    @PostMapping("/user/{userId}")
    public ResultData<ShipInfo> createOneShip(@PathVariable("userId") Long userId, @RequestBody ShipInfo shipInfo) {
        try {
            shipInfo.setUserId(userId);
            shipService.createShip(shipInfo);
            return ResultData.success(shipInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.failed(e.getMessage());
        }
    }

    @PutMapping("/{shipId}/user/{userId}/equipments")
    public ResultData<List<ShipEquipment>> armEquipment(@PathVariable("shipId") Long shipId,
                                                        @PathVariable("userId") Long userId,
                                                        @RequestBody List<ShipEquipment> shipEquipmentList) {
        try {
            shipEquipmentList.forEach(shipEquipment -> {
                shipEquipment.setShipId(shipId);
                shipEquipment.setUserId(userId);
            });
            shipService.arm(shipEquipmentList);
            return ResultData.success(shipEquipmentList);
        } catch (Exception e) {
            e.printStackTrace();;
            return ResultData.failed(e.getMessage());
        }
    }

    @GetMapping("/{shipId}/profile")
    public ResultData<ShipInfo> getShipProfile(@PathVariable("shipId") Long shipId) {
        try {
            ShipInfo shipInfo = shipService.getShipProfile(shipId);
            return ResultData.success(shipInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.failed(e.getMessage());
        }
    }

    @GetMapping("/{shipId}")
    public ResultData<ShipInfo> getShipInfo(@PathVariable("shipId") Long shipId) {
        try {
            ShipInfo shipInfo = shipService.getShipInfo(shipId);
            return ResultData.success(shipInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.failed(e.getMessage());
        }
    }
}
