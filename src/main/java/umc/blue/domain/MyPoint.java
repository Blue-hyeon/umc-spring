package umc.blue.domain;

import lombok.*;
import umc.blue.domain.common.BaseEntity;
import umc.blue.domain.enums.PointType;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MyPoint extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int changePoint;
    @Enumerated(EnumType.STRING)
    private PointType pointType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mymission_id")
    private MyMission myMission;
}
