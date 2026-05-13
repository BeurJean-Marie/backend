package class5.policy;

import class5.role.Role;

public class StaffSubmissionPolicy implements SubmissionPolicy {
    @Override
    public boolean canSubmit(Role role) {
        return false;  // 운영진은 과제 제출 불가
    }
}