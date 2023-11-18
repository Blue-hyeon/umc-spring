package umc.blue.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import umc.blue.domain.common.BaseEntity;
import umc.blue.domain.enums.AnswerStatus;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Inquiry extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String inquiryTitle;
    @Column(nullable = false, length = 1000)
    private String inquiryContent;
    @Enumerated(EnumType.STRING)
    @ColumnDefault("'UNREGISTERED'")
    private AnswerStatus answerStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
