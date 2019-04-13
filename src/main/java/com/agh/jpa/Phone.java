package com.agh.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String brand;
    private String model;
    private String network_technology;
    @Column(name = "bands_2G")
    private String bands2;
    @Column(name = "bands_3G")
    private String bands3;
    @Column(name = "bands_4G")
    private String bands4;
    private String network_speed;
    private String GPRS;
    private String EDGE;
    private String announced;
    private String status;
    private String dimentions;
    private String weight_g;
    private String weight_oz;
    private String SIM;
    private String display_type;
    private String display_resolution;
    private String display_size;
    private String OS;
    private String CPU;
    private String Chipset;
    private String GPU;
    private String memory_card;
    private String internal_memory;
    private String RAM;
    private String primary_camera;
    private String secondary_camera;
    private String loud_speaker;
    private String audio_jack;
    private String WLAN;
    private String bluetooth;
    private String GPS;
    private String NFC;
    private String radio;
    private String USB;
    private String sensors;
    private String battery;
    private String colors;
    private String approx_price_EUR;
    private String img_url;

}