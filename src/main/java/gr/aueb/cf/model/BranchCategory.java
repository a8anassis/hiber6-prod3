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
@Table(name = "branch_categories")
public class BranchCategory extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Getter(AccessLevel.PROTECTED)
    @OneToMany(mappedBy = "branchCategory")
    private Set<Branch> branches = new HashSet<>();

    @Getter(AccessLevel.PROTECTED)
    @OneToMany(mappedBy = "branchCategory")
    private Set<Teacher> teachers = new HashSet<>();

    public void addBranch(Branch branch) {
        if (branches == null) branches = new HashSet<>();
        branches.add(branch);
        branch.setBranchCategory(this);
    }

    public void removeBranch(Branch branch) {
        if (branches == null) branches = new HashSet<>();
        branches.remove(branch);
        branch.setBranchCategory(null);
    }

    public void addTeacher(Teacher teacher) {
        if (teachers == null) teachers = new HashSet<>();
        teachers.add(teacher);
        teacher.setBranchCategory(this);
    }

    public void removeTeacher(Teacher teacher) {
        if (teachers == null) teachers = new HashSet<>();
        teachers.remove(teacher);
        teacher.setBranchCategory(null);
    }
}
