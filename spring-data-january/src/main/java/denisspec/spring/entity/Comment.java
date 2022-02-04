package denisspec.spring.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comment_id")
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Userm userm;

    private String content;

    @Column(name="dt_created")
    private LocalDateTime dtCreated;
    @Column(name="dt_updated")
    private LocalDateTime dtUpdated;
}
