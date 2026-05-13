package class5.policy;

import class5.role.Role;

public class LionSubmissionPolicy implements SubmissionPolicy {
    @Override
    public boolean canSubmit(Role role) {
        return true;  // 아기사자는 과제 제출 가능
    }
}