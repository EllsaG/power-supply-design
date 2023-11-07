package com.project.protectiveequipmentservice.controller.dto;


import com.project.protectiveequipmentservice.entity.ProtectiveEquipment;
import com.project.protectiveequipmentservice.entity.ProtectiveEquipmentSelection;
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
