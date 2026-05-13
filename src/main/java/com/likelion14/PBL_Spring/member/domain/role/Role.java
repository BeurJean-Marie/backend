package class5.role;

public abstract class Role {
    public String name;
    public String major;
    public int generation;
    public String part;

    protected Role(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    public final String getName() {
        return name;
    }

    public final String getMajor() {
        return major;
    }

    public final int getGeneration() {
        return generation;
    }

    public final String getPart() {
        return part;
    }

    public abstract String getRoleType();   // "아기사자" or "운영진"

    public abstract boolean canSubmit();    // 과제 제출 가능 여부

    public abstract String getDetail();     // 세부 정보 (학번 or 직책)

}