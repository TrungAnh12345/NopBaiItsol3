package constant;

public enum Level {
    GS_TS("Giáo sư tiến sỹ"),
    PGS_TS("Phó giáo sư tiến sĩ"),
    GVC("Giảng viên chính"),
    THS("Thạc sĩ");
    String value;

    Level(String value) {
        this.value = value;
    }
}
