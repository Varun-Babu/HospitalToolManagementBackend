package com.nest.strykerwebappbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tools")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToolSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String category;
    private int quantity;
    private String description;
    private String status;
    @ElementCollection
    @CollectionTable(name = "surgrery_tools", joinColumns = @JoinColumn(name = "tools_id"))
    private List<String> toolset;
    @Column(name = "is_deleted")
    private int deleted=0;

}
