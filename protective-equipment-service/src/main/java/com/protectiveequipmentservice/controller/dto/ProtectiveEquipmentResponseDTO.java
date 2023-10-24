package com.protectiveequipmentservice.controller.dto;


import com.protectiveequipmentservice.entity.ProtectiveEquipment;
import com.protectiveequipmentservice.entity.ProtectiveEquipmentSelection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProtectiveEquipmentResponseDTO {
    List<ProtectiveEquipment> protectiveEquipmentList;
    List<ProtectiveEquipmentSelection> protectiveEquipmentSelectionList;
}
