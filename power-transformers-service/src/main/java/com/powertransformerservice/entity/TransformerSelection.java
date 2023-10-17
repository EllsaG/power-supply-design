package com.powertransformerservice.entity;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "transformer_selection")
public class TransformerSelection {
    @Id
    @Column(name = "transformer_selection_id")
    private short transformerSelectionId;
    @Column(name = "rated_power_for_transformer_selection")
    private float ratedPowerForTransformerSelection;

}
