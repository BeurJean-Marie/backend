package com.likelion14.PBL_Spring.member.domain.role;

import com.likelion14.PBL_Spring.member.domain.policy.LionSubmissionPolicy;
import com.likelion14.PBL_Spring.member.domain.policy.SubmissionPolicy;

public class Lion extends Role {
    private String studentId;
    private final SubmissionPolicy submissionPolicy = new LionSubmissionPolicy();

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.studentId = studentId;
    }

    public String getStudentId() { return studentId; }

    @Override
    public String getRoleType() { return "아기사자"; }

    @Override
    public boolean canSubmit() { return submissionPolicy.canSubmit(this); }

    @Override
    public String getDetail() { return "학번: " + studentId; }

    @Override
    public String toString() {
        return "이름: " + name + " | 전공: " + major + " | 기수: " + generation + " | 파트: " + part
                + "\n학번: " + studentId;
    }
}