package class5.policy;

import class5.role.Role;

public interface SubmissionPolicy {
    boolean canSubmit(Role role);
}