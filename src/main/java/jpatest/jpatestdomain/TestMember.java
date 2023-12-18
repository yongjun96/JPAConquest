package jpatest.jpatestdomain;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Generated
public class TestMember {

    public TestMember(){}

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @ManyToOne(fetch = FetchType.LAZY) // testTeam이 N인 경우
    @JoinColumn(name = "TEAM_ID")
    private TestTeam testTeam;

    public void changeTeam(TestTeam testTeam){
        this.testTeam = testTeam;
        testTeam.getTestMembers().add(this);
    }
}
