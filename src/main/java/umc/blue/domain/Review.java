package umc.blue.domain;

import lombok.*;
import umc.blue.domain.common.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 500)
    private String reviewContent;
    @Column(nullable = false, length = 1)
    private int reviewStar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;
}
