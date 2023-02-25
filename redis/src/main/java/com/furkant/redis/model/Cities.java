package com.furkant.redis.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Data
@EqualsAndHashCode
@Entity
@Table(name = "cities", schema = "rds")
@Builder
public class Cities implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(name = "plate_code")
    @Size(max = 20, message = "plate code should not be grater then 20 character")
    private String plateCode;

    @Column
    @Size(max = 30, message = "name should not be grater then 30 character")
    private String name;
}
