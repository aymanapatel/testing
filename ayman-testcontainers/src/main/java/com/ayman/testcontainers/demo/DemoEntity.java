package com.ayman.testcontainers.demo;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;



@Data
@Entity
@Getter
@Setter
@Table(name = "demoentity")
public class DemoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq-gen")
    private Long id;

    @Column
    private String value;
}
