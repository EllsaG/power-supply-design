package com.powertransformerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transformer_selection")
public class TransformerSelection {
    @Id
    @Column(name = "transformer_selection_id")
    private short transformerSelectionId;
    @Column(name = "rated_power_for_transformer_selection")
    private float ratedPowerForTransformerSelection;

}
