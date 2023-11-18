package umc.blue.domain;

import lombok.*;
import umc.blue.domain.common.BaseEntity;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 30)
    private String storeName;
    @Column(nullable = false, length = 100)
    private String storeAddress;
    @Column(nullable = false, length = 11)
    private String storePhone;
    private Float rating;
    private LocalTime openTime;
    private LocalTime closeTime;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

}
