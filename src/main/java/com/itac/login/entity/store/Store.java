package com.itac.login.entity.store;

import com.itac.login.dto.ImageVo;
import com.itac.login.entity.StringListConverter;
import com.itac.login.entity.user.Users;

import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.stream.FileImageInputStream;
import javax.persistence.*;

import com.vladmihalcea.hibernate.type.json.JsonType;

import org.hibernate.annotations.TypeDef;

import java.io.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode(of= {"storeNum"}) // equals, hashCode 자동 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@TypeDef(name="json", typeClass= JsonType.class)
public class Store implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="storenum")
    private Long storeNum;
    @Column(name="storename")
    private String storeName;
    @Column(name="storelocation")
    private String storeLocation;
    @Column(name="storephonenum")
    private String storePhoneNum;
    @Column(name="grade")
    private String grade;
    @Column(name="storeinfo")
    private String storeInfo;
    @Column(name="createdate")
    private LocalDate createDate;
    @Column(name="modificationdate")
    private LocalDate modificationDate;

    @Column(name="images")
    @Convert(converter = StringListConverter.class)
    private List<String> images = new ArrayList<>();

    /*@ManyToOne
    @JoinColumn(name="usernum")
    private Users users;
*/

    @Builder
    public Store(Long storeNum, String storeName, String storeLocation, String storePhoneNum,String grade,String storeInfo, List<String> images) {
        super();
        this.storeNum = storeNum;
        this.storeName = storeName;
        this.storeLocation = storeLocation;
        this.storePhoneNum = storePhoneNum;
        this.grade = grade;
        this.storeInfo = storeInfo;
        this.images = images;
        this.createDate = LocalDate.now();


    }



}
