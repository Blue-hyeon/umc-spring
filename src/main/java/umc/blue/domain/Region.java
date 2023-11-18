package umc.blue.domain;

import lombok.*;
import umc.blue.domain.common.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Region extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 10)
    private String regionName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;
}
