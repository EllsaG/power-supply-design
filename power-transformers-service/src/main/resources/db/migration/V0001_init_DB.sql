create table power_transformers
(
    power_transformers_id  int2 primary key,
    transformer_model varchar(255) not null,
    transformer_full_power float4 not null,
    transformer_load_coef float4 not null,
    short_circuit_voltage float4 not null,
    transformer_idle_losses float4 not null,
    high_side_voltage float4 not null,
    low_side_voltage float4 not null,
    short_circuit_losses float4 not null,
    idle_current float4 not null
);
create table transformer_selection
(
    transformer_selection_id int2 primary key ,
    rated_power_for_transformer_selection float4 not null
);