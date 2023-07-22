package com.stroreimg.img.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ImageData")
@Data//it will generate getter and setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String type;
    @Lob//the data  will store the in binary data to covert it normal we are using @lob annonatation
    @Column(name = "imagedata",length = 1000)
    private byte[] imageData;
}
