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
@Table(name = "phones")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "NETWORK_TECHNOLOGY")
    private String networks;

    @Column(name = "BANDS_2G")
    private String bands2;

    @Column(name = "BANDS_3G")
    private String bands3;

    @Column(name = "BANDS_4G")
    private String bands4;

    @Column(name = "NETWORK_SPEED")
    private String networkSpeed;

    @Column(name = "GPRS")
    private String GPRS;

    @Column(name = "EDGE")
    private String EDGE;

    @Column(name = "ANNOUNCED")
    private String announcedDate;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "DIMENSIONS")
    private String dimensions;

    @Column(name = "WEIGHT")
    private String weight;

    @Column(name = "SIM")
    private String SIM;

    @Column(name = "DISPLAY_TYPE")
    private String displayType;

    @Column(name = "DISPLAY_RESOLUTION")
    private String displayResolution;

    @Column(name = "DISPLAY_SIZE")
    private String displaySize;

    @Column(name = "OS")
    private String OS;

    @Column(name = "CPU")
    private String CPU;

    @Column(name = "CHIPSET")
    private String chipset;

    @Column(name = "GPU")
    private String GPU;

    @Column(name = "MEMORY_CARD")
    private String memoryCard;

    @Column(name = "INTERNAL_MEMORY")
    private String internalMemory;

    @Column(name = "RAM")
    private String RAM;

    @Column(name = "PRIMARY_CAMERA")
    private String primaryCamera;

    @Column(name = "SECONDARY_CAMERA")
    private String secondaryCamera;

    @Column(name = "LOUD_SPEAKER")
    private String loudSpeaker;

    @Column(name = "AUDIO_JACK")
    private String audioJack;

    @Column(name = "WLAN")
    private String WLAN;

    @Column(name = "BLUETOOTH")
    private String bluetooth;

    @Column(name = "GPS")
    private String GPS;

    @Column(name = "NFC")
    private String NFC;

    @Column(name = "RADIO")
    private String radio;

    @Column(name = "USB")
    private String USB;

    @Column(name = "SENSORS")
    private String sensors;

    @Column(name = "BATTERY")
    private String battery;

    @Column(name = "COLORS")
    private String colors;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

}