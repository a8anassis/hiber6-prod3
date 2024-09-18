package gr.aueb.cf.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "branches")
public class Branch extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_category_id")
    private BranchCategory branchCategory;

    @Getter(AccessLevel.PROTECTED)
    @OneToMany(mappedBy = "branch")
    private Set<Teacher> teachers = new HashSet<>();

    public void addTeacher(Teacher teacher) {
        if (teachers == null) teachers = new HashSet<>();
        teachers.add(teacher);
        teacher.setBranch(this);
    }

    public void removeTeacher(Teacher teacher) {
        if (teachers == null) teachers = new HashSet<>();
        teachers.remove(teacher);
        teacher.setBranch(null);
    }
}
