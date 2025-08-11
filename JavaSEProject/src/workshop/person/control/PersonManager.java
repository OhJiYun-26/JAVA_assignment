package workshop.person.entity;

public class PersonEntity {
    private String name;     // 이름
    private String rrn;      // 주민등록번호(또는 학번 등 식별자)
    private String address;  // 주소
    private String phone;    // 전화번호

    // 네가 쓰는 생성자 시그니처: (이름, 주민번호, 주소, 전화)
    public PersonEntity(String name, String rrn, String address, String phone) {
        this.name = name;
        this.rrn = rrn;
        this.address = address;
        this.phone = phone;
    }

    public String getName()    { return name; }
    public String getRrn()     { return rrn; }
    public String getAddress() { return address; }
    public String getPhone()   { return phone; }

    /** 주민번호 7번째 자리로 성별 계산: 1/3=남, 2/4=여, 그 외는 "미상" */
    public String getGender() {
        if (rrn == null || rrn.length() < 7) return "미상";
        char g = rrn.charAt(6);
        if (g == '1' || g == '3') return "남";
        if (g == '2' || g == '4') return "여";
        return "미상";
    }

    @Override
    public String toString() {
        return name + " / " + getGender() + " / " + phone + " / " + address;
    }
}
