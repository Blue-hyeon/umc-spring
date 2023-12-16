package umc.blue.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import umc.blue.domain.common.BaseEntity;
import umc.blue.domain.enums.MissionStatus;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MyMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private MissionStatus missionStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    public void complete() {
        this.missionStatus = MissionStatus.DONE;
    }
}
